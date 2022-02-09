package com.seledtsova.java.service.impl;

import com.seledtsova.java.dao.DepartmentDao;
import com.seledtsova.java.dto.DepartmentDTO;
import com.seledtsova.java.entity.Department;
import com.seledtsova.java.entity.DepartmentType;
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
class DepartmentServiceImplTest {

    @Mock
    private DepartmentDao departmentDao;
    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Test
    void shouldFindEmptyListOfDepartments() {
        List<Department> departments = departmentDao.findAll();
        assertTrue(departments.isEmpty());
    }

    @Test
    void shouldReturnDepartmentsList() {
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setName(DepartmentType.DEVELOPMENT_DEPARTMENT);
        Department department = new Department();
        department.setName(DepartmentType.DEVELOPMENT_DEPARTMENT);
        when(departmentDao.findAll()).thenReturn(Collections.singletonList(department));
        List<DepartmentDTO> departments = departmentService.findAll();
        assertEquals(departments.get(0).getName(), departmentDTO.getName());
    }
}