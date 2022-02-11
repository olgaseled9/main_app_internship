package com.seledtsova.java.service;

import com.seledtsova.java.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {

    List<DepartmentDTO> findAll();
}