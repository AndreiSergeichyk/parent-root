package by.itacademy.service.impl;

import by.itacademy.entity.Publisher;
import by.itacademy.repository.initerface.PublisherRepository;
import by.itacademy.service.interfaces.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;

    @Autowired
    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Publisher save(Publisher object) {
        return publisherRepository.save(object);
    }

    @Override
    public void delete(Publisher object) {
        publisherRepository.delete(object);
    }

    @Override
    public Publisher findById(Long id) {
        Publisher publisher = null;
        Optional<Publisher> result = publisherRepository.findById(id);
        if (result.isPresent()) {
            publisher = result.get();
        }

        return publisher;
    }

    @Override
    public List<Publisher> findAll() {
        Iterable<Publisher> result = publisherRepository.findAll();
        ArrayList<Publisher> publishers = new ArrayList<>();
        result.forEach(publishers::add);

        return publishers;
    }
}
