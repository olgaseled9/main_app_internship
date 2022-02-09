package com.seledtsova.java.controllers.web;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.seledtsova.java.dto.EmployeeDTO;
import com.seledtsova.java.entity.DepartmentType;
import com.seledtsova.java.entity.GenderType;
import com.seledtsova.java.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private EmployeeService employeeService;

    @Test
    void shouldValidThatRequestCallEmployeeService() throws Exception {
        mockMvc.perform(
                get("/api/employees")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
        verify(employeeService, times(1)).getEmployees();
    }

    @Test
    void shouldReturnListOfEmployeesWhenDoGetRequestEmployees() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(1L);
        employeeDTO.setFirstname("TestFirstname");
        employeeDTO.setLastname("TestLastname");
        employeeDTO.setDepartment(DepartmentType.DEVELOPMENT_DEPARTMENT);
        employeeDTO.setJobTitle("Junior java developer");
        employeeDTO.setDateOfBirth("2021-11-10");
        List<EmployeeDTO> employeeDTOS = Collections.singletonList(employeeDTO);
        when(employeeService.getEmployees()).thenReturn(employeeDTOS);
        MvcResult mvcResult = mockMvc.perform(
                get("/api/employees")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        assertThat(result).isEqualToIgnoringCase(objectMapper.writeValueAsString(employeeDTOS));
    }

    @Test
    public void shouldValidThatDeleteRequestCallEmployeeService() throws Exception {
        Long id = 1L;
        mockMvc.perform(
                delete("/api/employees" + "/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
        verify(employeeService, times(1)).removeEmployeeById(id);
    }

    @Test
    void shouldAddEmployeeWithValidParametersAndReturnStatus201() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(1L);
        employeeDTO.setFirstname("TestFirstname");
        employeeDTO.setLastname("TestLastname");
        employeeDTO.setDepartment(DepartmentType.DEVELOPMENT_DEPARTMENT);
        employeeDTO.setJobTitle("Junior java developer");
        employeeDTO.setGender(GenderType.FEMALE);
        employeeDTO.setDateOfBirth("2011-11-12");
        mockMvc.perform(
                post("/api/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employeeDTO))
        ).andExpect(status().isCreated());
    }

    @Test
    void shouldReturnEmployeeWhenDoGetRequestById() throws Exception {
        Long id = 1L;
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(id);
        employeeDTO.setFirstname("TestFirstname");
        employeeDTO.setLastname("TestLastname");
        employeeDTO.setDepartment(DepartmentType.DEVELOPMENT_DEPARTMENT);
        employeeDTO.setJobTitle("Junior java developer");
        employeeDTO.setGender(GenderType.FEMALE);
        employeeDTO.setDateOfBirth("2011-11-12");
        when(employeeService.findEmployeeById(id)).thenReturn(employeeDTO);
        MvcResult result = mockMvc.perform(
                get("/api/employee" + "/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn();
        String resultString = result.getResponse().getContentAsString();
        assertThat(resultString).isEqualToIgnoringCase(objectMapper.writeValueAsString(employeeDTO));
    }

}