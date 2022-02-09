package com.seledtsova.java.dto;

import com.seledtsova.java.entity.DepartmentType;
import com.seledtsova.java.entity.GenderType;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class EmployeeDTO {


    private Long id;
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    @NotNull
    private DepartmentType department;
    @NotNull
    private String jobTitle;
    @NotNull
    private GenderType gender;
    @NotNull
    private LocalDate dateOfBirth;

}
