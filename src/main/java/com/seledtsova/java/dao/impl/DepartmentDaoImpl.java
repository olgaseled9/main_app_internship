package com.seledtsova.java.dao.impl;

import com.seledtsova.java.dao.DepartmentDao;
import com.seledtsova.java.entity.Department;
import com.seledtsova.java.entity.DepartmentType;
import com.seledtsova.java.entity.Gender;
import com.seledtsova.java.entity.GenderType;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public class DepartmentDaoImpl extends GenericDaoImpl<Long, Department> implements DepartmentDao {

    private static final String FIND_DEPARTMENT_BY_NAME_QUERY = "from Department as d where d.name=:name";

    @Override
    public Department findDepartmentByName(DepartmentType departmentType) {
        Query query = entityManager.createQuery(FIND_DEPARTMENT_BY_NAME_QUERY);
        query.setParameter("name", departmentType);
        return (Department) query.getSingleResult();
    }
}
