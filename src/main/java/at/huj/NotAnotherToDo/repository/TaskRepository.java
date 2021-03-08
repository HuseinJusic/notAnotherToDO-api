package at.huj.NotAnotherToDo.repository;

import at.huj.NotAnotherToDo.model.task.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {

}
