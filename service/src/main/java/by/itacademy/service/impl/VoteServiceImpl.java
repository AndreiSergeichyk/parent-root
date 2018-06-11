package by.itacademy.service.impl;

import by.itacademy.entity.Vote;
import by.itacademy.repository.initerface.VoteRepository;
import by.itacademy.service.interfaces.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class VoteServiceImpl implements VoteService {

    private final VoteRepository voteRepository;

    @Autowired
    public VoteServiceImpl(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @Override
    public List<Vote> findAllByBookId(Serializable bookId) {
        return voteRepository.findAllByBookId(bookId);
    }

    @Override
    public BigDecimal avgVote(Serializable bookId) {
        return voteRepository.avgVote(bookId);
    }

    @Override
    public Vote save(Vote object) {
        return voteRepository.save(object);
    }

    @Override
    public void delete(Vote object) {
        voteRepository.delete(object);
    }

    @Override
    public Vote findById(Long id) {
        Vote vote = null;
        Optional<Vote> result = voteRepository.findById(id);
        if (result.isPresent()) {
            vote = result.get();
        }

        return vote;
    }

    @Override
    public List<Vote> findAll() {
        Iterable<Vote> result = voteRepository.findAll();
        ArrayList<Vote> votes = new ArrayList<>();
        result.forEach(votes::add);

        return votes;
    }
}
