package by.itacademy.service;

import by.itacademy.entity.User;
import by.itacademy.service.interfaces.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserTest extends BaseCase {

    @Autowired
    private UserService userService;

    @Test
    public void findByNameAndPassword() {
        User user = userService.findByNameAndPassword("Petr", "admin");
        Assert.assertNotNull("user is null", user);
    }
}
