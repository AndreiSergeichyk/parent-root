package by.itacademy.service.interfaces;

import by.itacademy.entity.UserBook;

import java.io.Serializable;
import java.util.List;

public interface UserBookService extends ServiceInt<Long, UserBook> {

    List<UserBook> findAllByUserId(Serializable userId);
}
