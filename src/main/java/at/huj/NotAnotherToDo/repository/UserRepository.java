package at.huj.NotAnotherToDo.repository;

import at.huj.NotAnotherToDo.model.User;
import at.huj.NotAnotherToDo.model.Week;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);

    @Query(value = "{ 'id' : ?0, 'weeks.id' : ?1 }", fields = "{ 'weeks.id' : 1 }")
    List<Week> findByUserIdAndWeeksId(String userId, String weekNumber);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
