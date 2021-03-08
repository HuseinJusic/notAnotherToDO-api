package at.huj.NotAnotherToDo.controller;

import at.huj.NotAnotherToDo.model.User;
import at.huj.NotAnotherToDo.model.task.Task;
import at.huj.NotAnotherToDo.model.task.TaskFactory;
import at.huj.NotAnotherToDo.payload.request.TaskRequest;
import at.huj.NotAnotherToDo.repository.TaskRepository;
import at.huj.NotAnotherToDo.repository.UserRepository;
import at.huj.NotAnotherToDo.repository.WeekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WeekRepository weekRepository;

    @Autowired
    private TaskRepository taskRepository;


    @GetMapping("/getByWeek/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Task> getByWeek(@PathVariable("id") String weekId) {
        //TODO: ERROR HANDLING

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByUsername(userDetails.getUsername()).get();
        try{
            List<Task> tasks = userRepository.findWeeks(user.getId(), weekId).getWeeks().get(0).getTasks();
            return tasks ;
        }catch(Exception e){
            return null;
        }
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Task createSingleTask(@RequestBody TaskRequest taskRequest) {
        //TODO: Nullcheck
        //TODO: ERROR HANDLING

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByUsername(userDetails.getUsername()).get();

        try{
            Week week = userRepository.findWeeks(user.getId(), taskRequest.getWeekId()).getWeeks().get(0);

            Task task = TaskFactory.getTask(taskRequest.getTaskType());
            taskRepository.save(task);

            week.addTask(task);
            weekRepository.save(week);

            return task;
        }catch(Exception e){
            return null;
        }

    }


}
