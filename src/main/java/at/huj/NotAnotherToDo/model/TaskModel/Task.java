package at.huj.NotAnotherToDo.model.TaskModel;

import at.huj.NotAnotherToDo.model.Role;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
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
    private final Set<Scale> scales = new HashSet<>();

    public Task() {
        this.status = new TaskStatus(this);
    }

    public Task(TaskBody taskBody) {
        this();
        this.taskBody = taskBody;
    }

    public Task(Scedule scedule, TaskBody taskBody) {
        this(taskBody);
        this.scedule = scedule;
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
}
