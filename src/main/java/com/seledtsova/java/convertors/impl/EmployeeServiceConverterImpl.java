package com.seledtsova.java.convertors.impl;


import com.seledtsova.java.convertors.EmployeeServiceConverter;
import com.seledtsova.java.dao.DepartmentDao;
import com.seledtsova.java.dao.GenderDao;
import com.seledtsova.java.dto.EmployeeDTO;
import com.seledtsova.java.entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class EmployeeServiceConverterImpl implements EmployeeServiceConverter {

    @Autowired
    private final GenderDao genderDao;
    @Autowired
    private final DepartmentDao departmentDao;

    @Override
    public EmployeeDTO convertEmployeeToDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setFirstname(employee.getFirstname());
        employeeDTO.setLastname(employee.getLastname());
        employeeDTO.setJobTitle(employee.getJobTitle());
        employeeDTO.setDateOfBirth(employee.getDateOfBirth());
        if (Objects.nonNull(employee.getGender())) {
            GenderType genderType = (employee.getGender().getName());
            employeeDTO.setGender(genderType);
        }
        if (Objects.nonNull(employee.getDepartment())) {
            DepartmentType departmentType = (employee.getDepartment().getName());
            employeeDTO.setDepartment(departmentType);
        }
        return employeeDTO;
    }

    @Override
    public Employee convertDTOtoEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setFirstname(employeeDTO.getFirstname());
        employee.setLastname(employeeDTO.getLastname());
        employee.setJobTitle(employeeDTO.getJobTitle());
        employee.setDateOfBirth(employeeDTO.getDateOfBirth());
        if (Objects.nonNull(employeeDTO.getGender())) {
            Gender gender = genderDao.findGenderByName(employeeDTO.getGender());
            employee.setGender(gender);
        }
        if (Objects.nonNull(employeeDTO.getDepartment())) {
            Department department = departmentDao.findDepartmentByName(employeeDTO.getDepartment());
            employee.setDepartment(department);
        }
        return employee;
    }
}
