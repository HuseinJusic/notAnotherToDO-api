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
        //TODO: fix creation of tasks.
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByUsername(userDetails.getUsername()).get();

        Task t = new Task(user, new SimpleTask());
        t.setStatus(new TaskStatus());
        t.setScedule(new Scedule());
        t.getScedule().setFrom(task.getDueDate());
        t.getScedule().setTo(task.getDueDate());
        t.getTaskBody().setTaskTitle(task.getTaskTitle());
        t.getTaskBody().setTaskDescription(task.getTaskDescription());

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
    public Task remove(@RequestBody String id) {

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByUsername(userDetails.getUsername()).get();

        Task t = taskRepository.findByIdAndUser(id, user);

        if(t != null){
            taskRepository.delete(t);
        }
        return t;
    }

    /*
    TODO: ADD Methods like "toggleStatus" etc. to update the Task accordingly. The /update method should not be used in production.
     */

}
