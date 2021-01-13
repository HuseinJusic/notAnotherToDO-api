package at.huj.NotAnotherToDo.controller;

import at.huj.NotAnotherToDo.model.User;
import at.huj.NotAnotherToDo.model.Week;
import at.huj.NotAnotherToDo.repository.UserRepository;
import at.huj.NotAnotherToDo.repository.WeekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/week")
public class WeekController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WeekRepository weekRepository;

    @GetMapping("/getAll")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Week> getAllWeeks() {

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByUsername(userDetails.getUsername()).get();

        return user.getWeeks();
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Week> getWeek(@PathVariable("id") String id) {

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByUsername(userDetails.getUsername()).get();

        Week w = user.getWeekById(id);
        if(w.equals(null)){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }


        return new ResponseEntity<>(w, HttpStatus.OK);
    }

    @DeleteMapping("/remove/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Week> removeWeek(@PathVariable("id") String id) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByUsername(userDetails.getUsername()).get();

        Week removeWeek = userRepository.findByUserAndWeekId(user.getId(), id);

        if(user.removeWeekById(id)){
            weekRepository.delete(removeWeek);
            userRepository.save(user);
        }else{
            return new ResponseEntity<>(removeWeek, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(removeWeek, HttpStatus.OK);
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Week> removeWeek(@RequestBody Week addWeek) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByUsername(userDetails.getUsername()).get();

        //prevents setting the id in POST..
        addWeek.setId(null);

        weekRepository.save(addWeek);

        user.addWeek(addWeek);
        userRepository.save(user);

        return new ResponseEntity<>(addWeek, HttpStatus.OK);
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Week> updateWeek(@RequestBody Week week) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByUsername(userDetails.getUsername()).get();

        if(!user.updateWeek(week)){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }else{
            weekRepository.save(week);
            return new ResponseEntity<>(user.getWeekById(week.id), HttpStatus.OK);
        }

    }
}
