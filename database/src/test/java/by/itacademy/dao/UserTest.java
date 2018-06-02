package by.itacademy.dao;

import by.itacademy.dao.impl.RoleDaoImpl;
import by.itacademy.dao.impl.UserDaoImpl;
import by.itacademy.entity.Contact;
import by.itacademy.entity.Role;
import by.itacademy.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.equalTo;

public class UserTest extends BaseTest {

    @Autowired
    private RoleDaoImpl roleDao;

    @Autowired
    private UserDaoImpl userDao;

    @Test
    public void saveUser() {
        Role role = new Role("admin15");
        User user = new User("Andrei15", "admin15",
                new Contact("12345615", "qwerty@mail.com15"), role);

        Integer roleId = roleDao.save(role);
        Assert.assertNotNull("Id is null", roleId);
        Long userId = userDao.save(user);
        Assert.assertNotNull("Id is null", userId);
    }

    @Test
    public void findUser() {
        User user = userDao.findByNameAndPassword("Petr", "admin");
        Assert.assertThat(user.getName(), equalTo("Petr"));
        user = userDao.findById(user.getId());
        Assert.assertThat(user.getName(), equalTo("Petr"));
    }

    @Test
    public void findByNameAndPassword() {
        User user = userDao.findByNameAndPassword("Petr", "admin");
        Assert.assertThat(user.getName(), equalTo("Petr"));
    }
}
