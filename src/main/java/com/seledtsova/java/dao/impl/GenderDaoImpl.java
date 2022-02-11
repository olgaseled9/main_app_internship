package com.seledtsova.java.dao.impl;

import com.seledtsova.java.dao.GenderDao;
import com.seledtsova.java.entity.Gender;
import com.seledtsova.java.entity.GenderType;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public class GenderDaoImpl extends GenericDaoImpl<Long, Gender> implements GenderDao {

    private static final String FIND_GENDER_BY_NAME_QUERY = "from Gender as g where g.name=:name";

    @Override
    public Gender findGenderByName(GenderType genderType) {
        Query query = entityManager.createQuery(FIND_GENDER_BY_NAME_QUERY);
        query.setParameter("name", genderType);
        return (Gender) query.getSingleResult();
    }
}