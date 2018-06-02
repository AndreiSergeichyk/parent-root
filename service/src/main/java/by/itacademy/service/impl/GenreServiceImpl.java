package by.itacademy.service.impl;

import by.itacademy.entity.Genre;
import by.itacademy.repository.initerface.GenreRepository;
import by.itacademy.service.interfaces.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Autowired
    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public Genre findByName(String genreName) {
        Genre genre = null;
        Optional<Genre> result = genreRepository.findByName(genreName);
        if (result.isPresent()) {
            genre = result.get();
        }

        return genre;
    }

    @Override
    public Genre save(Genre object) {
        return genreRepository.save(object);
    }

    @Override
    public void delete(Genre object) {
        genreRepository.delete(object);
    }

    @Override
    public Genre findById(Long id) {
        Genre genre = null;
        Optional<Genre> result = genreRepository.findById(id);
        if (result.isPresent()) {
            genre = result.get();
        }

        return genre;
    }

    @Override
    public List<Genre> findAll() {
        Iterable<Genre> result = genreRepository.findAll();
        ArrayList<Genre> genres = new ArrayList<>();
        result.forEach(genres::add);

        return genres;
    }
}
