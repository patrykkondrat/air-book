package com.airbook.app.controller;


import com.airbook.app.model.Employee;
import com.airbook.app.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String getEmployee(Model model) {
        List<Employee> employees = employeeService.findAllEmployees();
        model.addAttribute("employees", employees);
        return "employee/employeelist";
    }

    @GetMapping("/add")
    public String showAddEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee/employeeadd";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute("employee") Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("Error " + bindingResult.getAllErrors());
            return "employee/employeeadd";
        }

        employee.setBirthday(LocalDate.parse(employee.getBirthday().toString()));
        employee.setDateOfEmployment(LocalDate.parse(employee.getDateOfEmployment().toString()));
        System.out.println("Employee " + employee);
        employeeService.addEmployee(employee);
        return "redirect:/employee";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        employeeService.delEmployee(id);
        return "redirect:/employee";
    }

    @GetMapping("/update")
    public String showUpdateEmployee(@RequestParam("id") Long id, Model model) {
        Employee employee = employeeService.findEmployeeById(id).orElseGet(() -> new Employee());
        model.addAttribute("employee", employee);
        return "employee/employeeupdate";
    }

    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable("id") Long id, Employee employee, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("Error " + bindingResult.getAllErrors());
            return "redirect:/update/{id}";
        }
        employeeService.updateEmployee(id, employee);
        return "redirect:/employee";
    }
}
