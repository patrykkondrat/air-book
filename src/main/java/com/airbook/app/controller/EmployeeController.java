package com.airbook.app.controller;


import com.airbook.app.model.Employee;
import com.airbook.app.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;
    // select employee
    @GetMapping
    public List<Employee> getFlights() {
        if (employeeService.findAllEmployees().isEmpty()) {
            return null;
        } else {
            return employeeService.findAllEmployees();
        }
    }

    @GetMapping("/{id}")
    public Optional<Employee> getFlightById(Long Id) {
        return employeeService.findEmployeeById(String.valueOf(Id));
    }

    // add employee

    // delate employee

    // update employee

}
