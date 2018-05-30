package by.itacademy.dao.impl;

import by.itacademy.entity.Publisher;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Repository
public class PublisherDaoImpl extends BaseDao<Long, Publisher> {
}
