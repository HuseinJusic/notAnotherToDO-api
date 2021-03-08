package at.huj.NotAnotherToDo.model.task;

import org.springframework.data.annotation.Id;

import java.util.Date;

public abstract class Task {

    @Id
    public String id;
    private TaskType type;

    private Date dueDate;
    private boolean finished = false;

    private String taskTitle;
    private String taskDescription;

    public Task(Date dueDate, TaskType type) {
        this.dueDate = dueDate;
        this.type = type;
    }

    public Task(TaskType type) {
        this.type = type;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public void setType(TaskType type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TaskType getType() {
        return type;
    }
}
