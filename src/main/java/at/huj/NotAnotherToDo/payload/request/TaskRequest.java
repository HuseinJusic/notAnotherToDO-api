package at.huj.NotAnotherToDo.payload.request;

import at.huj.NotAnotherToDo.model.task.TaskFactory;
import at.huj.NotAnotherToDo.model.task.TaskType;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class TaskRequest {

    private TaskType taskType;

    @NotBlank
    private String weekId;
    @NotBlank
    private String type;

    private Date dueDate;

    private String taskTitle;
    private String taskDescription;

    public TaskRequest(@NotBlank String type, Date dueDate) {
        this.taskType = TaskFactory.parseType(type);
        this.dueDate = dueDate;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
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

    public String getWeekId() {
        return weekId;
    }

    public void setWeekId(String weekId) {
        this.weekId = weekId;
    }
}
