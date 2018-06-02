package by.itacademy.dao.impl;

import by.itacademy.dao.interfaces.Dao;
import by.itacademy.entity.BaseEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class BaseDao<PK extends Serializable, T extends BaseEntity<PK>> implements Dao<PK, T> {

    @Autowired
    protected SessionFactory sessionFactory;
    private Class<T> clazz;

    @SuppressWarnings("unchecked")
    public BaseDao() {
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        this.clazz = (Class<T>) type.getActualTypeArguments()[1];
    }

    @Override
    @SuppressWarnings("unchecked")
    public PK save(T object) {
        return (PK) sessionFactory.getCurrentSession().save(object);
    }

    @Override
    public void update(T object) {
        sessionFactory.getCurrentSession().update(object);
    }

    @Override
    public void delete(T object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    @Override
    public T findById(PK id) {
        return sessionFactory.getCurrentSession().find(clazz, id);
    }

    @Override
    public List<T> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery(String.format(" select o from %s o", clazz.getSimpleName()), clazz).list();
    }
}
