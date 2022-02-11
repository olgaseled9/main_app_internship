package com.seledtsova.java.dao.impl;

import com.seledtsova.java.dao.EmployeeDao;
import com.seledtsova.java.entity.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl extends GenericDaoImpl<Long, Employee> implements EmployeeDao {

}