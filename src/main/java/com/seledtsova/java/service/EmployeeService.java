package com.seledtsova.java.service;

import com.seledtsova.java.dto.EmployeeDTO;
import com.seledtsova.java.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> getEmployees();

    EmployeeDTO findEmployeeById(Long id);

    void addEmployee(EmployeeDTO employeeDTO);

    void removeEmployeeById(Long id);

}

