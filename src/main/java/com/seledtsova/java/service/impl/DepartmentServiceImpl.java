package com.seledtsova.java.service.impl;

import com.seledtsova.java.dao.DepartmentDao;
import com.seledtsova.java.dto.DepartmentDTO;
import com.seledtsova.java.entity.Department;
import com.seledtsova.java.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentDao departmentDao;

    @Override
    @Transactional
    public List<DepartmentDTO> findAll() {
        List<Department> departments = departmentDao.findAll();
        List<DepartmentDTO> departmentDTOS = new ArrayList<>();
        for (Department department : departments) {
            departmentDTOS.add(convertDepartmentToDTO(department));
        }
        return departmentDTOS;
    }

    private DepartmentDTO convertDepartmentToDTO(Department department) {
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setName(department.getName());
        return departmentDTO;
    }
}
