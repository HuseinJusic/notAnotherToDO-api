package at.huj.NotAnotherToDo.controller;

import at.huj.NotAnotherToDo.model.User;
import at.huj.NotAnotherToDo.model.Week;
import at.huj.NotAnotherToDo.model.task.MultiTask;
import at.huj.NotAnotherToDo.model.task.SingleTask;
import at.huj.NotAnotherToDo.repository.UserRepository;
import at.huj.NotAnotherToDo.repository.WeekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


/**
 * TODO: IMPLEMENT NEW
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WeekRepository weekRepository;

    @GetMapping("/weekTest")
    @PreAuthorize("hasRole('ADMIN')")
    public Week userAccess() {

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByUsername(userDetails.getUsername()).get();

        Week week = new Week();
        week.addSingleTask(new SingleTask());
        week.addSingleTask(new SingleTask());
        week.addSingleTask(new SingleTask());

        week.addMultiTask(new MultiTask());
        week.addMultiTask(new MultiTask());
        week.addMultiTask(new MultiTask());
        week.addMultiTask(new MultiTask());
        week.addMultiTask(new MultiTask());


        weekRepository.save(week);

        return weekRepository.findById(week.getId()).get();
    }

    @GetMapping("/userWeekTest")
    @PreAuthorize("hasRole('ADMIN')")
    public User userWeekTest() {

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByUsername(userDetails.getUsername()).get();

        Week week = new Week();
        week.addSingleTask(new SingleTask());
        week.addSingleTask(new SingleTask());
        week.addSingleTask(new SingleTask());

        week.addMultiTask(new MultiTask());
        week.addMultiTask(new MultiTask());
        week.addMultiTask(new MultiTask());
        week.addMultiTask(new MultiTask());
        week.addMultiTask(new MultiTask());

        weekRepository.save(week);

        user.setWeeks(new ArrayList<>());
        user.addWeek(week);

        userRepository.save(user);

        return userRepository.findByUsername(userDetails.getUsername()).get();
    }

    @PostMapping("/create/singleTask")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String createSingleTask() {

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByUsername(userDetails.getUsername()).get();

        return "";
    }


}
