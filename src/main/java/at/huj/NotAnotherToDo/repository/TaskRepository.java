package at.huj.NotAnotherToDo.repository;

import at.huj.NotAnotherToDo.model.TaskModel.Task;
import at.huj.NotAnotherToDo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {

    List<Task> findAllByUser(User user);

    Task findByIdAndUser(String id, User user);
}
