package by.itacademy.service.impl;

import by.itacademy.entity.Role;
import by.itacademy.repository.initerface.RoleRepository;
import by.itacademy.service.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role save(Role object) {
        return roleRepository.save(object);
    }

    @Override
    public void delete(Role object) {
        roleRepository.delete(object);
    }

    @Override
    public Role findById(Integer id) {
        Role role = null;
        Optional<Role> result = roleRepository.findById(id);
        if (result.isPresent()) {
            role = result.get();
        }

        return role;
    }

    @Override
    public List<Role> findAll() {
        Iterable<Role> result = roleRepository.findAll();
        ArrayList<Role> roles = new ArrayList<>();
        result.forEach(roles::add);

        return roles;
    }
}
