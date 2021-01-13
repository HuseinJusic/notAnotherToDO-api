package at.huj.NotAnotherToDo.model.task;

import org.springframework.data.annotation.Id;

import java.util.Date;

public abstract class Task {

    @Id
    public String id;

    private Date dueDate;
    private Date plannedCalenderWeek;
    private boolean finished;

    public Task(Date dueDate, Date plannedCalenderWeek) {
        this.dueDate = dueDate;
        this.plannedCalenderWeek = plannedCalenderWeek;
    }

    public Task(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Task() {

    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getPlannedCalenderWeek() {
        return plannedCalenderWeek;
    }

    public void setPlannedCalenderWeek(Date plannedCalenderWeek) {
        this.plannedCalenderWeek = plannedCalenderWeek;
    }
}
