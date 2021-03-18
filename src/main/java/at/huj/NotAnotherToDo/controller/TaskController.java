package at.huj.NotAnotherToDo.controller;

import at.huj.NotAnotherToDo.model.TaskModel.Scedule;
import at.huj.NotAnotherToDo.model.TaskModel.Task;
import at.huj.NotAnotherToDo.model.TaskModel.TaskBody.SimpleTask;
import at.huj.NotAnotherToDo.model.TaskModel.TaskStatus;
import at.huj.NotAnotherToDo.model.User;
import at.huj.NotAnotherToDo.payload.request.TaskRequest;
import at.huj.NotAnotherToDo.repository.TaskRepository;
import at.huj.NotAnotherToDo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/allTasks")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Task> getAllAdmin() {
        return taskRepository.findAll();
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Task> getAll() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByUsername(userDetails.getUsername()).get();
        return taskRepository.findAllByUser(user);
    }

    @PostMapping("/new")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Task newTask(@RequestBody TaskRequest task) {
        //TODO: implement multitasks etc.
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByUsername(userDetails.getUsername()).get();

        Task t = new Task(user, new SimpleTask());
        t.getTaskBody().setTaskTitle(task.getTaskTitle());
        t.getTaskBody().setTaskDescription(task.getTaskDescription());

        handleDateScedule(task, t);

        return taskRepository.save(t);
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Task updateTask(@RequestBody Task task) {

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByUsername(userDetails.getUsername()).get();

        if(taskRepository.findByIdAndUser(task.getId(), user) != null){
            return taskRepository.save(task);
        }else{
            return null;
        }

    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Task get(@PathVariable String id) {

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByUsername(userDetails.getUsername()).get();

        return taskRepository.findByIdAndUser(id, user);

    }

    @PostMapping("/remove")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Task remove(@RequestBody TaskRequest task) {

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByUsername(userDetails.getUsername()).get();

        Task t = taskRepository.findByIdAndUser(task.getTaskId(), user);

        if(t != null){
            taskRepository.delete(t);
        }

        //TODO: error handling
        return t;
    }

    /*
    TODO: ADD Methods like "toggleStatus" etc. to update the Task accordingly. The /update method should not be used in production.
     */

    @PostMapping("/toggleTask")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Task toggle(@RequestBody TaskRequest task) {

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByUsername(userDetails.getUsername()).get();

        Task t = taskRepository.findByIdAndUser(task.getTaskId(), user);

        if(t != null){

            if(task.getDueDate() != null){
                t.toggle(task.getDueDate());
            }else{
                t.toggle();
            }

            taskRepository.save(t);
        }
        //TODO: add error handling (task not found...)
        return t;
    }

    @PostMapping("/updateScedule")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Task updateScedule(@RequestBody TaskRequest task) {

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByUsername(userDetails.getUsername()).get();

        if(task.getTaskId() != null) {
            Task t = taskRepository.findByIdAndUser(task.getTaskId(), user);

            if (t != null) {
                handleDateScedule(task, t);
            }
            return t;
        }
        //TODO: add error handling :)
        return null;

    }

    private void handleDateScedule(@RequestBody TaskRequest task, Task t) {
        if (task.getDueDate() != null) {
            t.setScedule(new Scedule(task.getDueDate()));
        } else if (task.getRecurrence() != null && task.getRecurrence().size() > 0) {
            t.setScedule(new Scedule(task.getRecurrence()));
        } else {
            t.setScedule(new Scedule());
        }
    }


}
