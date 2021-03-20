package at.huj.NotAnotherToDo.model.TaskModel.TaskBody;

import at.huj.NotAnotherToDo.model.TaskModel.ETaskBody;

import java.util.ArrayList;
import java.util.List;

public class MultiTask extends TaskBody{

    List<CheckItem> tasks = new ArrayList<>();

    @Override
    public ETaskBody type() {
        return ETaskBody.MULTI;
    }

    private CheckItem getCheckItem(SimpleTask t){
        //basically if tasktitle is the same
        for(int i = 0; i < tasks.size(); i++){
            if(tasks.get(i).getSimpleTask().equals(t)){
                return tasks.get(i);
            }
        }

        return null;
    }

    public boolean toggleCheckItem(SimpleTask t){
        CheckItem item = getCheckItem(t);
        if(item != null){
            item.finished = !item.finished;
            return item.finished;
        }
        return false;
    }

    public boolean addSimpleTask(SimpleTask t){
        CheckItem item = getCheckItem(t);
        if(item == null){
            this.tasks.add(new CheckItem(t));
            return true;
        }
        return false;
    }

    public boolean removeSimpleTask(SimpleTask t){
        CheckItem item = getCheckItem(t);
        if(item != null){
            this.tasks.remove(item);
            return true;
        }
        return false;
    }

    private static class CheckItem{
        private SimpleTask simpleTask;
        private boolean finished;

        public CheckItem(SimpleTask simpleTask) {
            this.simpleTask = simpleTask;
            this.finished = false;
        }

        public SimpleTask getSimpleTask() {
            return simpleTask;
        }

        public void setSimpleTask(SimpleTask simpleTask) {
            this.simpleTask = simpleTask;
        }

        public boolean isFinished() {
            return finished;
        }

        public void setFinished(boolean finished) {
            this.finished = finished;
        }
    }
}
