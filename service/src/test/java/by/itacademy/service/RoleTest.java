package by.itacademy.service;

import by.itacademy.entity.Role;
import by.itacademy.service.interfaces.RoleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class RoleTest extends BaseCase {

    @Autowired
    private RoleService roleService;

    @Test
    public void findAllRole() {
        List<Role> roles = roleService.findAll();
        assertThat(roles, hasSize(2));
        Role role = roles.get(0);
        assertThat(role.getName(), equalTo("admin"));
    }
}
