package com.seledtsova.java.controllers.web;

import com.seledtsova.java.dto.EmployeeDTO;
import com.seledtsova.java.service.DepartmentService;
import com.seledtsova.java.service.EmployeeService;
import com.seledtsova.java.service.GenderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Log4j2
@Controller
@RequiredArgsConstructor
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private GenderService genderService;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String getAll(Model model) {
        List<EmployeeDTO> employees = employeeService.getEmployees();
        model.addAttribute("employees", employees);
        return "employees";
    }

    @GetMapping("/add")
    public String addEmployeePage(EmployeeDTO employeeDTO, Model model) {
        model.addAttribute("departments", departmentService.findAll());
        model.addAttribute("genders", genderService.findAll());
        return "add_employee";
    }

    @PostMapping("/add")
    public String addEmployee(@Valid EmployeeDTO employeeDTO, BindingResult bindingResult, Model model) {
        model.addAttribute("departments", departmentService.findAll());
        model.addAttribute("genders", genderService.findAll());
        if (!bindingResult.hasErrors()) {
            employeeService.addEmployee(employeeDTO);
            log.info("New employee add successfully");
            return "redirect:/";
        } else {
            log.error("Employee not added");
            return "error";
        }
    }

    @GetMapping("/remove")
    public String removeEmployeeById(@RequestParam("id") Long id) {
        if (id != null) {
            employeeService.removeEmployeeById(id);
            log.info("Employee removed successfully");
        }
        return "redirect:/";
    }

    @GetMapping("/get-by-id")
    public String getEmployeesById(@RequestParam("id") Long id, Model model) {
        EmployeeDTO employee = employeeService.findEmployeeById(id);
        model.addAttribute("employee", employee);
        return "get_employee_by_id";
    }

    @GetMapping("/update")
    public String getUpdateEmployeesPage(@RequestParam("id") Long id, Model model, EmployeeDTO employeeDTO) {
        employeeDTO = employeeService.getById(id);
        model.addAttribute("employeeDTO", employeeDTO);
        model.addAttribute("departments", departmentService.findAll());
        model.addAttribute("genders", genderService.findAll());
        return "update_employee";
    }

    @PostMapping("/update")
    public String updateEmployeePage(@Valid EmployeeDTO employeeDTO, BindingResult bindingResult, Model model) {
        model.addAttribute("departments", departmentService.findAll());
        model.addAttribute("genders", genderService.findAll());
        if (!bindingResult.hasErrors()) {
            employeeService.updateEmployee(employeeDTO);
            log.info("Employee update successfully");
            return "redirect:/";
        } else {
            log.error("Employee not updated");
            return "error";
        }
    }
}


