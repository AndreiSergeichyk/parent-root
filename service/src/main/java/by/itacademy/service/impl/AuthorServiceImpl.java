package by.itacademy.service.impl;

import by.itacademy.entity.Author;
import by.itacademy.repository.initerface.AuthorRepository;
import by.itacademy.service.interfaces.AuthorService;
import by.itacademy.service.interfaces.ServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author save(Author object) {
        return authorRepository.save(object);
    }

    @Override
    public void delete(Author object) {
        authorRepository.delete(object);
    }

    @Override
    public Author findById(Long id) {
        Author author = null;
        Optional<Author> result = authorRepository.findById(id);
        if (result.isPresent()) {
            author = result.get();
        }

        return author;
    }

    @Override
    public List<Author> findAll() {
        Iterable<Author> result = authorRepository.findAll();
        ArrayList<Author> authors = new ArrayList<>();
        result.forEach(authors::add);

        return authors;
    }
}
