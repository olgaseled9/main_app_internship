package com.seledtsova.java.service.impl;

import com.seledtsova.java.convertors.EmployeeServiceConverter;
import com.seledtsova.java.dao.EmployeeDao;
import com.seledtsova.java.dto.EmployeeDTO;
import com.seledtsova.java.entity.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @Mock
    EmployeeDao employeeDao;
    @Mock
    EmployeeServiceConverter converter;
    @InjectMocks
    EmployeeServiceImpl itemService;

    @Test
    void shouldReturnEmployeeList() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Long testId = 1L;
        employeeDTO.setId(testId);
        Employee employee = new Employee();
        when(employeeDao.findAll()).thenReturn(Collections.singletonList(employee));
        when(converter.convertEmployeeToDTO(employee)).thenReturn(employeeDTO);
        List<EmployeeDTO> items = itemService.getEmployees();
        assertEquals(items.get(0).getId(), employeeDTO.getId());
    }

    @Test
    void shouldGetEmptyListOfEmployees() {
        List<Employee> items = employeeDao.findAll();
        assertTrue(items.isEmpty());
    }

    @Test
    void shouldFindEmployeeById() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Long id = 8L;
        Employee employee = new Employee();
        employee.setId(id);
        when(employeeDao.findById(id)).thenReturn(employee);
        when(converter.convertEmployeeToDTO(employee)).thenReturn(employeeDTO);
        assertEquals(itemService.findEmployeeById(employee.getId()), employeeDTO);
    }

}