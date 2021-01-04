package at.huj.NotAnotherToDo.repository;

import at.huj.NotAnotherToDo.model.ERole;
import at.huj.NotAnotherToDo.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}
