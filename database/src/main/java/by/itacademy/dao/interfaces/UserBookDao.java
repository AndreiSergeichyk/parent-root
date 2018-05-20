package by.itacademy.dao.interfaces;

import by.itacademy.entity.UserBook;

import java.util.List;

public interface UserBookDao {

    List<UserBook> findByUserId(Long userId);
}
