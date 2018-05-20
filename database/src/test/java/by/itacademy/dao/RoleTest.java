package by.itacademy.dao;

import by.itacademy.entity.Role;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

public class RoleTest extends BaseTest {

    @Test
    public void saveRole() {
        Role role = new Role("admin11");
        save(role);
    }

    @Test
    public void findRole() {
        Role role = new Role("admin12");
        find(role);
    }
}
