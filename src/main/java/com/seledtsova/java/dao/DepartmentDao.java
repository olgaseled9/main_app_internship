package com.seledtsova.java.dao;

import com.seledtsova.java.entity.Department;
import com.seledtsova.java.entity.DepartmentType;

public interface DepartmentDao extends GenericDao<Long, Department> {

    Department findDepartmentByName(DepartmentType departmentType);
}
