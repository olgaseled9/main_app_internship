package com.seledtsova.java.service.impl;

import com.seledtsova.java.convertors.EmployeeServiceConverter;
import com.seledtsova.java.dao.EmployeeDao;
import com.seledtsova.java.dto.EmployeeDTO;
import com.seledtsova.java.entity.Employee;
import com.seledtsova.java.exception.ServiceException;
import com.seledtsova.java.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {


    private final EmployeeDao employeeDao;
    private final EmployeeServiceConverter converter;

    @Override
    @Transactional
    public void addEmployee(EmployeeDTO employeeDTO) {
        employeeDao.add(converter.convertDTOtoEmployee(employeeDTO));
    }


    @Override
    @Transactional
    public EmployeeDTO findEmployeeById(Long id) {
        Employee employee = employeeDao.findById(id);
        if (Objects.nonNull(employee)) {
            return converter.convertEmployeeToDTO(employee);
        } else {
            throw new ServiceException(String.format("Employee is not found with id=", id));
        }
    }

    @Override
    @Transactional
    public List<EmployeeDTO> getEmployees() {
        List<Employee> employees = employeeDao.findAll();
        List<EmployeeDTO> employeesDTOS = new ArrayList<>();
        for (Employee employee : employees) {
            employeesDTOS.add(converter.convertEmployeeToDTO(employee));
        }
        return employeesDTOS;
    }

    @Override
    @Transactional
    public void removeEmployeeById(Long id) {
        Employee employee = employeeDao.findById(id);
        if (Objects.nonNull(employee)) {
            employeeDao.delete(employee);
        } else {
            throw new ServiceException(String.format("Employee is not found with id=", id));
        }
    }

    @Override
    @Transactional
    public void updateEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeDao.findById(employeeDTO.getId());
        if (Objects.nonNull(employee)) {
            employee.setFirstname(employeeDTO.getFirstname());
            employee.setLastname(employeeDTO.getLastname());
            employee.setDepartment(employee.getDepartment());
            employee.setGender(employee.getGender());
            employee.setDateOfBirth(employee.getDateOfBirth());
        } else {
            throw new ServiceException(String.format("Employee was not found ", employeeDTO.getId()));
        }
    }

    @Override
    @Transactional
    public EmployeeDTO getById(Long id) {
        Employee employee = employeeDao.findById(id);
        if (Objects.nonNull(employee)) {
            return converter.convertEmployeeToDTO(employee);
        } else {
            throw new ServiceException(String.format("Employee was not found with id=", id));
        }
    }
}

