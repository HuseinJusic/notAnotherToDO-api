package at.huj.NotAnotherToDo.model.TaskModel.TaskBody;

import at.huj.NotAnotherToDo.model.TaskModel.ETaskBody;

public class SimpleTask extends TaskBody {
    @Override
    public ETaskBody type() {
        return ETaskBody.SIMPLE;
    }
}
