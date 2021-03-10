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

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public boolean isFinishedOnTime() {
        return finishedOnTime;
    }

    public void setFinishedOnTime(boolean finishedOnTime) {
        this.finishedOnTime = finishedOnTime;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLastEdited() {
        return lastEdited;
    }

    public void setLastEdited(Date lastEdited) {
        this.lastEdited = lastEdited;
    }

    public List<Task> getTaskHistory() {
        return taskHistory;
    }

    public void setTaskHistory(List<Task> taskHistory) {
        this.taskHistory = taskHistory;
    }
}
