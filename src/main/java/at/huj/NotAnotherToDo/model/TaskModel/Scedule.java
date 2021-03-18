package at.huj.NotAnotherToDo.model.TaskModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Scedule {

    private Date from;
    private Date to;
    private Date due;
    private boolean isSceduled;
    private boolean isActive = true;
    private List<Scedule> recurrence = new ArrayList<>();
    private TaskStatus status = new TaskStatus();

    public Scedule(Date from, Date to) {
        this.from = from;
        this.to = to;
        this.isSceduled = true;
    }

    public Scedule(Date due) {
        this.due = due;
        this.from = due;
        this.to = due;
        this.isSceduled = true;
    }

    public Scedule(List<Date> recurrence) {
        for (Date date : recurrence) {
            this.recurrence.add(new Scedule(date));
        }

        if(this.recurrence.size() > 0){
            this.from = this.recurrence.get(0).getDue();
            this.to = this.recurrence.get(this.recurrence.size() - 1).getDue();
        }
        this.isSceduled = true;
    }

    public Scedule() {

    }

    public boolean hasRecurrence(){
        return this.recurrence.size() > 0;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public boolean isSceduled() {
        return isSceduled;
    }

    public void setSceduled(boolean sceduled) {
        isSceduled = sceduled;
    }

    public List<Scedule> getRecurrence() {
        return recurrence;
    }

    public void setRecurrence(List<Scedule> recurrence) {
        this.recurrence = recurrence;
    }

    public Date getDue() {
        return due;
    }

    public void setDue(Date due) {
        this.due = due;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public void sceduleRecurrenceWeekly(){
        //todo
    }

    public void sceduleRecurrenceMonthly(){
        //todo
    }
    public void sceduleRecurrenceDaily(){
        //todo
    }
}
