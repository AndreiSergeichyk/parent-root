package by.itacademy.dao.interfaces;

import by.itacademy.entity.Publisher;

import java.util.List;

public interface PublisherDao extends Dao<Long, Publisher> {

    List<Publisher> findAll(Integer limit, Integer offset);
}
