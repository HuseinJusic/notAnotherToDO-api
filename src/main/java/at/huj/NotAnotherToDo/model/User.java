package at.huj.NotAnotherToDo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Document(collection = "users")
public class User {

    @Id
    private String id;

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;

    @DBRef
    private Set<Role> roles = new HashSet<>();

    @DBRef
    private List<Week> weeks = new ArrayList<>();

    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public List<Week> getWeeks() {
        return weeks;
    }

    public void setWeeks(List<Week> weeks) {
        this.weeks = weeks;
    }

    public void addWeek(Week w){
        this.weeks.add(w);
    }

    public boolean removeWeek(Week w){
        return weeks.remove(w);
    }

    public boolean removeWeekById(String weekId){

        for(int i = 0; i < weeks.size(); i++){
            if(weeks.get(i).getId().equals(weekId)){
                weeks.remove(i);
                return true;
            }
        }

        return false;
    }

    public Week getWeekById(String weekId){

        for(int i = 0; i < weeks.size(); i++){
            if(weeks.get(i).getId().equals(weekId)){
                return weeks.get(i);
            }
        }

        return null;
    }

    public boolean updateWeek(Week week){

        for(int i = 0; i < weeks.size(); i++){
            if(weeks.get(i).getId().equals(week.getId())){
                weeks.set(i, week);
                return true;
            }
        }

        return false;
    }

}
