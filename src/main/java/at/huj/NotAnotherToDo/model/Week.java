package at.huj.NotAnotherToDo.model;

import at.huj.NotAnotherToDo.model.task.MultiTask;
import at.huj.NotAnotherToDo.model.task.SingleTask;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.*;

@Document
public class Week {

    @Id
    public String id;

    private Calendar week;

    private int weekNumber;


    private List<SingleTask> singleTaskList = new ArrayList<>();
    private List<MultiTask> multiTaskList = new ArrayList<>();

    public Week() {

    }

    public Week(int weekNumber) {
        week = new GregorianCalendar();
        week.set(Calendar.WEEK_OF_YEAR, weekNumber);

        this.weekNumber = week.get(Calendar.WEEK_OF_YEAR);
    }

    public Week(Calendar week, int weekNumber) {
        this.week = week;
        this.weekNumber = weekNumber;
    }

    public void addSingleTask(SingleTask s){
        this.singleTaskList.add(s);
    }

    public void addMultiTask(MultiTask m){
        this.multiTaskList.add(m);
    }

    public Week(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Calendar getWeek() {
        return week;
    }

    public void setWeek(Calendar week) {
        this.week = week;
    }

    public int getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(int weekNumber) {
        this.weekNumber = weekNumber;
    }

    public List<SingleTask> getSingleTaskList() {
        return singleTaskList;
    }

    public void setSingleTaskList(List<SingleTask> singleTaskList) {
        this.singleTaskList = singleTaskList;
    }

    public List<MultiTask> getMultiTasks() {
        return multiTaskList;
    }

    public void setMultiTasks(List<MultiTask> multiTaskList) {
        this.multiTaskList = multiTaskList;
    }
}
