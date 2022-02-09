package com.seledtsova.java.convertors.impl;

import com.seledtsova.java.dto.EmployeeDTO;
import com.seledtsova.java.entity.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceConverterImplTest {


    @InjectMocks
    private EmployeeServiceConverterImpl employeeServiceConverter;

    @Test
    void shouldConvertEmployeeToDTOAndReturnEmployeeFirstname() {
        Employee employee = new Employee();
        String firstname = "Test";
        employee.setFirstname(firstname);
        EmployeeDTO employeeDTO = employeeServiceConverter.convertEmployeeToDTO(employee);
        Assertions.assertEquals(firstname, employeeDTO.getFirstname());
    }

    @Test
    void shouldConvertEmployeeToDTOAndReturnEmployeeLastname() {
        Employee employee = new Employee();
        String lastname = "Test";
        employee.setLastname(lastname);
        EmployeeDTO employeeDTO = employeeServiceConverter.convertEmployeeToDTO(employee);
        Assertions.assertEquals(lastname, employeeDTO.getLastname());
    }

    @Test
    void shouldConvertEmployeeToDTOAndReturnCorrectId() {
        Employee employee = new Employee();
        Long testId = 1L;
        employee.setId(testId);
        EmployeeDTO employeeDTO = employeeServiceConverter.convertEmployeeToDTO(employee);
        Assertions.assertEquals(testId, employeeDTO.getId());
    }

    @Test
    void shouldConvertEmployeeToDTOAndReturnCorrectGender() {
        Gender gender = new Gender();
        Employee employee = new Employee();
        gender.setName(GenderType.FEMALE);
        employee.setGender(gender);
        EmployeeDTO employeeDTO = employeeServiceConverter.convertEmployeeToDTO(employee);
        Assertions.assertEquals(gender.getName(), employeeDTO.getGender());
    }

    @Test
    void shouldDepartmentEmployeeToDTOAndReturnCorrectGender() {
        Department department = new Department();
        Employee employee = new Employee();
        department.setName(DepartmentType.DEVELOPMENT_DEPARTMENT);
        employee.setDepartment(department);
        EmployeeDTO employeeDTO = employeeServiceConverter.convertEmployeeToDTO(employee);
        Assertions.assertEquals(department.getName(), employeeDTO.getDepartment());
    }

}