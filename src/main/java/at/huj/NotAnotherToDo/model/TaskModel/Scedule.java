package at.huj.NotAnotherToDo.model.TaskModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Scedule {

    private Date from;
    private Date to;
    private Date due;
    private boolean isSceduled;
    private List<Scedule> recurrence = new ArrayList<>();

    public Scedule(Date from, Date to) {
        this.from = from;
        this.to = to;
    }

    public Scedule(Date due) {
        this.due = due;
    }

    public Scedule(List<Date> recurrence) {
        for (Date date : recurrence) {
            this.recurrence.add(new Scedule(date));
        }
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
