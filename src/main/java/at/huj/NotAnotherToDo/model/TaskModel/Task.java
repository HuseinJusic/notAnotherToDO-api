package at.huj.NotAnotherToDo.model.TaskModel;

import at.huj.NotAnotherToDo.model.TaskModel.TaskBody.TaskBody;
import at.huj.NotAnotherToDo.model.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Document(collection = "tasks")
public class Task {

    @Id
    private String id;

    private Scedule scedule;
    private TaskBody taskBody;
    private TaskStatus status;

    @DBRef
    private Category category;

    @DBRef
    private Set<Scale> scales = new HashSet<>();

    @DBRef
    private User user;

    public Task() {
    }

    public Task(User user) {
        this.user = user;
    }

    public Task(User user, TaskBody taskBody) {
        this(user);
        this.taskBody = taskBody;
    }

    public Task(User user, Scedule scedule, TaskBody taskBody) {
        this(user, taskBody);
        this.scedule = scedule;
    }

    public void toggle(){
        this.getStatus().setFinished(!getStatus().isFinished());

        //TODO: implement finished on Time logic after sceduling od tasks
        /*Date date = new Date();
        if(this.getScedule().getTo().after(date) && this.getStatus().isFinished()){
            this.getStatus().setFinishedOnTime(!this.getStatus().isFinishedOnTime());
        }*/
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Scedule getScedule() {
        return scedule;
    }

    public void setScedule(Scedule scedule) {
        this.scedule = scedule;
    }

    public TaskBody getTaskBody() {
        return taskBody;
    }

    public void setTaskBody(TaskBody taskBody) {
        this.taskBody = taskBody;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public Set<Scale> getScales() {
        return scales;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setScales(Set<Scale> scales) {
        this.scales = scales;
    }

}
