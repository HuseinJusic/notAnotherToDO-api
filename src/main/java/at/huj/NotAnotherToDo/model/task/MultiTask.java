package at.huj.NotAnotherToDo.model.task;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class MultiTask extends Task{

    List<SingleTask> tasks = new ArrayList<>();

    public MultiTask() {
        super(TaskType.MultiTask);
    }

    public List<SingleTask> getTasks() {
        return tasks;
    }

    public void addTask(SingleTask task) {
        this.tasks.add(task);
    }

    public SingleTask removeTask(String taskId) {
        //TODO: implement..
        return null;
    }
}
