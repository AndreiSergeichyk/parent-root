package by.itacademy.dao;

import by.itacademy.dao.impl.RoleDaoImpl;
import by.itacademy.entity.Role;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class RoleTest extends BaseTest {

    @Autowired
    private RoleDaoImpl roleDao;

    @Test
    public void saveRole() {
        Role role = new Role("admin11");
        Integer roleId = roleDao.save(role);
        Assert.assertNotNull("Id is null", roleId);
    }

    @Test
    public void findRole() {
        List<Role> roles = roleDao.findAll();
        assertThat(roles, hasSize(2));
        Role role = roles.get(0);
        role = roleDao.findById(role.getId());
        assertThat(role.getName(), equalTo("admin"));
    }
}
