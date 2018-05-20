package by.itacademy.dao;

import by.itacademy.dao.impl.UserDaoImpl;
import by.itacademy.entity.Contact;
import by.itacademy.entity.Role;
import by.itacademy.entity.User;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;

public class UserTest extends BaseTest {

    @Test
    public void saveUser() {
        Role role = new Role("admin15");
        User user = new User("Andrei15", "admin15",
                new Contact("12345615", "qwerty@mail.com15"), role);
        save(role, user);
    }

    @Test
    public void findUser() {
        Role role = new Role("admin16");
        User user = new User("Andrei16", "admin16",
                new Contact("1234567816", "qwerty@mail.com16"), role);
        find(role, user);
    }

    @Test
    public void finfByNameAndPassword() {
        User user = UserDaoImpl.getInstance().findByNameAndPassword("Petr", "admin");
        Assert.assertThat(user.getName(), equalTo("Petr"));
    }
}
