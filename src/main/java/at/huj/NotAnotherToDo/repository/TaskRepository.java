package at.huj.NotAnotherToDo.repository;

import at.huj.NotAnotherToDo.model.TaskModel.Task;
import at.huj.NotAnotherToDo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String>, QuerydslPredicateExecutor<Task> {

    List<Task> findAllByUser(User user);

    Task findByIdAndUser(String id, User user);



}
