package com.seledtsova.java.dto;

import com.seledtsova.java.entity.DepartmentType;
import com.seledtsova.java.entity.GenderType;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Data
@RequiredArgsConstructor
public class EmployeeDTO {

    private Long id;
    @NotNull(message = "firstname cannot be null")
    @NotEmpty
    @Size(max = 20)
    @Pattern(regexp = "^[A-Za-z]*$", message = "Should be only latin characters")
    private String firstname;
    @NotNull(message = "lastname cannot be null")
    @NotEmpty
    @Size(max = 40)
    @Pattern(regexp = "^[A-Za-z]*$", message = "Should be only latin characters")
    private String lastname;
    @NotNull
    private DepartmentType department;
    @NotEmpty
    @Size(max = 40)
    @NotNull(message = "Job title cannot be null")
    private String jobTitle;
    @NotNull
    private GenderType gender;
    @NotNull
    private String dateOfBirth;

}
