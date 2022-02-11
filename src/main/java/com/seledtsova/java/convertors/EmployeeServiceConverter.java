package com.seledtsova.java.convertors;

import com.seledtsova.java.dto.EmployeeDTO;
import com.seledtsova.java.entity.Employee;

public interface EmployeeServiceConverter {

    EmployeeDTO convertEmployeeToDTO(Employee employee);

    Employee convertDTOtoEmployee(EmployeeDTO employeeDTO);
}
