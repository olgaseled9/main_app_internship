package com.seledtsova.java.dao.impl;

import com.seledtsova.java.dao.GenericDao;
import com.seledtsova.java.exception.DaoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class GenericDaoImpl<I, T> implements GenericDao<I, T> {

    private static final Logger logger = LoggerFactory.getLogger(GenericDaoImpl.class);

    @PersistenceContext
    public EntityManager entityManager;
    public Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public GenericDaoImpl() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass()
                .getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[1];
    }

    @Override
    public void add(T entity) {
        try {
            entityManager.persist(entity);
        } catch (Exception e) {
            logger.error("Cannot save " + entity.getClass() + e.getMessage(), e);
        }
    }

    @Override
    public void delete(T entity) {
        try {
            entityManager.remove(entity);
        } catch (Exception e) {
            logger.error("Cannot delete " + entity.getClass() + e.getMessage(), e);
        }
    }

    @Override
    public T findById(I id) {
        try {
            return entityManager.find(entityClass, id);
        } catch (IllegalArgumentException e) {
            logger.error(e.getMessage(), e);
            throw new DaoException(entityClass.getName() + " with id " + id + " was not found");
        }
    }

    @Override
    public void merge(T entity) {
        try {
            entityManager.merge(entity);
        } catch (Exception e) {
            logger.error("Cannot update " + entity.getClass() + e.getMessage(), e);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        String queryString = "from " + entityClass.getName();
        Query query = entityManager.createQuery(queryString);
        return query.getResultList();
    }

}
