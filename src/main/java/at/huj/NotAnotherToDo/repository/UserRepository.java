package at.huj.NotAnotherToDo.repository;

import at.huj.NotAnotherToDo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);

    @Query(value = "{ 'id' : ?0, 'weeks.id' : ?1 }")
    User findByUserAndWeekId(String userId, String weekId);

    @Query(value = "{ 'id' : ?0, 'weeks.id' : ?1 }", fields = "{'weeks' : 1}")
    User findWeeks(String userId, String weekId);


    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
