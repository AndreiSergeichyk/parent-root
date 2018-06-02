package by.itacademy.service.interfaces;

import by.itacademy.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;

public interface ServiceInt<PK extends Serializable, T extends BaseEntity<PK>> {

    T save(T object);

    void delete(T object);

    T findById(PK id);

    List<T> findAll();
}
