package at.huj.NotAnotherToDo.model.task;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class SingleTask extends Task {
    public SingleTask() {
        super(TaskType.SingleTask);
    }
    //TODO: Implement single Task
}
