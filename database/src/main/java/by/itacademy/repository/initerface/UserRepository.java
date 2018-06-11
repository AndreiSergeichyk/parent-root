package by.itacademy.repository.initerface;

import by.itacademy.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByNameAndPassword(String userName, String pasword);
}
