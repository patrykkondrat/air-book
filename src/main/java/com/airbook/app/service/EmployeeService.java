package com.airbook.app.service;

import com.airbook.app.model.Employee;
import com.airbook.app.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public Optional<Employee> findEmployeeById(Long Id) {
        return employeeRepo.findById(Id);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public void addEmployee(Employee employee) {
        employeeRepo.save(employee);
    }

    public void delEmployee(Long Id) {
        employeeRepo.deleteById(Id);
    }

    public void updateEmployee(Long Id, Employee employee){
            if (employeeRepo.findById(Id).isPresent()) {
                Employee existingEmployee = employeeRepo.findById(Id).get();
                employeeRepo.deleteById(Id);
                employeeRepo.saveAndFlush(employee);
            }
        }
    }
