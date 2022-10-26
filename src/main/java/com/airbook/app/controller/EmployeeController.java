package com.airbook.app.controller;


import com.airbook.app.model.Employee;
import com.airbook.app.repo.EmployeeRepo;
import com.airbook.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepo employeeRepo;

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
    @PostMapping("/add") // WORKS
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    // delate employee
    @DeleteMapping("/del/{id}") // WORKS
    public void delEmployee(@PathVariable Long id) {
        employeeService.delEmployee(id);
    }

    // update employee
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee, @PathVariable Long id) {
        Optional<Employee> employeeOptional = employeeService.findEmployeeById(id);

        if (employeeOptional.isEmpty())
            return ResponseEntity.notFound().build();

        employee.setId(id);

        employeeRepo.save(employee);

        return ResponseEntity.noContent().build();
    }
}
