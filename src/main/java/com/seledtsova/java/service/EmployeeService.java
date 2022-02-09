package com.seledtsova.java.service;

import com.seledtsova.java.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> getEmployees();

    EmployeeDTO findEmployeeById(Long id);

    void addEmployee(EmployeeDTO employeeDTO);

    void removeEmployeeById(Long id);

}

