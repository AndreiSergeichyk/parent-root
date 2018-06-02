package by.itacademy.repository.initerface;

import by.itacademy.entity.UserBook;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.List;

public interface UserBookRepository extends CrudRepository<UserBook, Long> {

    List<UserBook> findAllByUserId(Serializable userId);
}
