package at.huj.NotAnotherToDo.model.task;

public class TaskFactory {


    public static Task getTask(TaskType type){

        switch (type){
            case MultiTask:
                return new MultiTask();
            case SingleTask:
                return new SingleTask();
            default:
                return null;
        }

    }

    public static TaskType parseType(String type){
        switch (type){
            case "MultiTask":
                return TaskType.MultiTask;
            case "SingleTask":
                return TaskType.SingleTask;
            default:
                return null;
        }
    }
}
