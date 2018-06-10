package by.itacademy.service.impl;

import by.itacademy.entity.User;
import by.itacademy.repository.initerface.UserRepository;
import by.itacademy.converter.UserDetailsConverter;
import by.itacademy.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserDetailsConverter userDetailsConverter;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserDetailsConverter detailsConverter) {
        this.userRepository = userRepository;
        this.userDetailsConverter = detailsConverter;
    }

    @Override
    public User findByNameAndPassword(String userName, String pasword) {
        User user = null;
        Optional<User> result = userRepository.findByNameAndPassword(userName, pasword);
        if (result.isPresent()) {
            user = result.get();
        }

        return user;
    }

    @Override
    public User save(User object) {
        return userRepository.save(object);
    }

    @Override
    public void delete(User object) {
        userRepository.delete(object);
    }

    @Override
    public User findById(Long id) {
        User user = null;
        Optional<User> result = userRepository.findById(id);
        if (result.isPresent()) {
            user = result.get();
        }

        return user;
    }

    @Override
    public List<User> findAll() {
        Iterable<User> result = userRepository.findAll();
        ArrayList<User> users = new ArrayList<>();
        result.forEach(users::add);

        return users;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println();
        return Optional.of(name)
                .map(userRepository::findByName)
                .map(userDetailsConverter::convert)
                .orElseThrow(() -> new UsernameNotFoundException("User does not exist!"));
    }
}
