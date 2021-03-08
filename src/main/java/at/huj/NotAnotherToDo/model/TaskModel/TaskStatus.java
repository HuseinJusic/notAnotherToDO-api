package at.huj.NotAnotherToDo.model.TaskModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskStatus {

    private boolean finished = false;
    private boolean finishedOnTime = false;
    private Date created = new Date();
    private Date lastEdited = new Date() ;

    private List<Task> taskHistory = new ArrayList<>();

    public TaskStatus(Task taskHistory) {
        this.taskHistory.add(taskHistory);
    }
}
