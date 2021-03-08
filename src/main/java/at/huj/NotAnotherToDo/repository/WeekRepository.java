package at.huj.NotAnotherToDo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface WeekRepository extends MongoRepository<Week, String> {
    Optional<Week> findById(String id);
}
