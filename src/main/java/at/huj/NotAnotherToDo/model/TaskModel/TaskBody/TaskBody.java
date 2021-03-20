package at.huj.NotAnotherToDo.model.TaskModel.TaskBody;

import at.huj.NotAnotherToDo.model.TaskModel.ETaskBody;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = SimpleTask.class)
public abstract class TaskBody {
    private ETaskBody taskType;
    private String taskTitle;
    private String taskDescription;

    public TaskBody() {
        this.taskType = type();
    }

    public abstract ETaskBody type();

    public ETaskBody getTaskType() {
        return taskType;
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

    public void setTaskType(ETaskBody taskType) {
        this.taskType = taskType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskBody taskBody = (TaskBody) o;

        return taskTitle != null ? taskTitle.equals(taskBody.taskTitle) : taskBody.taskTitle == null;
    }

    @Override
    public int hashCode() {
        return taskTitle != null ? taskTitle.hashCode() : 0;
    }
}
