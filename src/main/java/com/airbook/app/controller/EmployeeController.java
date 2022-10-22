package com.airbook.app.controller;


import com.airbook.app.model.Employee;
import com.airbook.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // select employee
    @GetMapping // WORKS
    public List<Employee> getFlights() {
        if (employeeService.findAllEmployees().isEmpty()) {
            return null;
        } else {
            return employeeService.findAllEmployees();
        }
    }

    @GetMapping("/{Id}") // WORKS
    public Optional<Employee> getFlightById(@PathVariable Long Id) {
        return employeeService.findEmployeeById(Id);
    }

    // add employee

    // delate employee

    // update employee

}
