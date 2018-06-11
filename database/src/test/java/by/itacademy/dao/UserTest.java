package by.itacademy.dao;

import by.itacademy.entity.User;
import by.itacademy.repository.initerface.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserTest extends BaseCase {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByUserId() {
        Optional<User> user = userRepository.findByNameAndPassword("Petr", "admin");
        Assert.assertTrue(user.isPresent());
    }
}
