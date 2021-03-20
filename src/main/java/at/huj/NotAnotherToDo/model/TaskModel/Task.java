package at.huj.NotAnotherToDo.model.TaskModel;

import at.huj.NotAnotherToDo.model.TaskModel.TaskBody.TaskBody;
import at.huj.NotAnotherToDo.model.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Document(collection = "tasks")
public class Task {

    @Id
    private String id;

    private Scedule scedule;
    private TaskBody taskBody;

    @DBRef
    private List<Category> category;

    @DBRef
    private Set<Scale> scales = new HashSet<>();

    @DBRef
    private User user;

    public Task() {
    }

    public Task(User user) {
        this.user = user;
    }

    public Task(User user, TaskBody taskBody) {
        this(user);
        this.taskBody = taskBody;
    }

    public Task(User user, Scedule scedule, TaskBody taskBody) {
        this(user, taskBody);
        this.scedule = scedule;
    }

    public void toggle(){
        if(!scedule.hasRecurrence()){
            scedule.getStatus().setFinished(!scedule.getStatus().isFinished());
        }else{
           //Throw error... cant toggle if no date is given !
        }
    }

    public void toggle(Date date){
        if(scedule.hasRecurrence()){
            List<Scedule> dateList = scedule.getRecurrence();

            for(int i = 0; i < dateList.size(); i++){
                if(dateList.get(i).getDue().equals(date)){
                    dateList.get(i).getStatus().setFinished(!dateList.get(i).getStatus().isFinished());
                    i = dateList.size();
                }
            }
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Scedule getScedule() {
        return scedule;
    }

    public void setScedule(Scedule scedule) {
        this.scedule = scedule;
    }

    public TaskBody getTaskBody() {
        return taskBody;
    }

    public void setTaskBody(TaskBody taskBody) {
        this.taskBody = taskBody;
    }

    public Set<Scale> getScales() {
        return scales;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setScales(Set<Scale> scales) {
        this.scales = scales;
    }

}
