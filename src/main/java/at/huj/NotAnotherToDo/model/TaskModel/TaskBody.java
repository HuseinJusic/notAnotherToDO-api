package at.huj.NotAnotherToDo.model.TaskModel;

public abstract class TaskBody {
    private final ETaskBody taskType;
    private String taskTitle;
    private String taskDescription;

    public TaskBody() {
        this.taskType = type();
    }

    public abstract ETaskBody type();

    public ETaskBody getTaskType() {
        return taskType;
    }
}
