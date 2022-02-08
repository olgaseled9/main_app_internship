package com.seledtsova.java.dto;

import com.seledtsova.java.entity.DepartmentType;
import com.seledtsova.java.entity.GenderType;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class EmployeeDTO {

    private Long id;
    private String firstname;
    private String lastname;
    private DepartmentType department;
    private String jobTitle;
    private GenderType gender;
    private LocalDate dateOfBirth;

}
