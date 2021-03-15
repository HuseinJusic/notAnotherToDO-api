package at.huj.NotAnotherToDo.payload.request;

import at.huj.NotAnotherToDo.model.TaskModel.ETaskBody;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

public class TaskRequest {

    private String taskId;
    private String taskTitle;
    private String taskDescription;
    private String taskType;
    private Date dueDate;
    private List<Date> recurrence;
    private ETaskBody taskTypeBody;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
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

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public ETaskBody getTaskTypeBody() {
        return taskTypeBody;
    }

    public void setTaskTypeBody(ETaskBody taskTypeBody) {
        this.taskTypeBody = taskTypeBody;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public List<Date> getRecurrence() {
        return recurrence;
    }

    public void setRecurrence(List<Date> recurrence) {
        this.recurrence = recurrence;
    }
}
