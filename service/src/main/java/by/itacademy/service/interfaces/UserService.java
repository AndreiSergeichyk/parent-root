package by.itacademy.service.interfaces;

import by.itacademy.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends ServiceInt<Long, User>, UserDetailsService {

    User findByNameAndPassword(String userName, String pasword);
}
