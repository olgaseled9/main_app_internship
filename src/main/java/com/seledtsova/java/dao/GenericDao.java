package com.seledtsova.java.dao;

import java.util.List;

public interface GenericDao<I, T> {

    void add(T entity);

    void delete(T entity);

    void merge(T entity);

    T findById(I id);

    List<T> findAll();

}
