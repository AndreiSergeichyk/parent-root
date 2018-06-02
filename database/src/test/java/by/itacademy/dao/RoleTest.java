package by.itacademy.dao;

import by.itacademy.entity.Role;
import by.itacademy.repository.initerface.RoleRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class RoleTest extends BaseCase {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void findAllRole() {
        Iterable<Role> roles = roleRepository.findAll();
        ArrayList<Role> result = new ArrayList<>();
        roles.forEach(result::add);
        assertThat(result, hasSize(2));
        Role role = result.get(0);
        assertThat(role.getName(), equalTo("admin"));
    }
}
