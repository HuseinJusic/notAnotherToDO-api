package at.huj.NotAnotherToDo.model.TaskModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Scedule {

    private Date from;
    private Date to;
    private boolean isSceduled;
    private List<Date> recurrence = new ArrayList<>();

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

    public List<Date> getRecurrence() {
        return recurrence;
    }

    public void setRecurrence(List<Date> recurrence) {
        this.recurrence = recurrence;
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
