package by.itacademy.dao.impl;

import by.itacademy.entity.Author;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Repository
public class AuthorDaoImpl extends BaseDao<Long, Author> {
}
