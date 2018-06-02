package by.itacademy.repository.initerface;

import by.itacademy.entity.Genre;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GenreRepository extends CrudRepository<Genre, Long> {

    Optional<Genre> findByName(String genreName);
}
