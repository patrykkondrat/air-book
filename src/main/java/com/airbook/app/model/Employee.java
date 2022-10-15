package com.airbook.app.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    private Long id;
    private String name;
    private LocalDate birthday;
    private LocalDate dateOfEmployment;
    private Double salary;

    public Employee(Long id, String name, LocalDate birthday, LocalDate dateOfEmployment, Double salary) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.dateOfEmployment = dateOfEmployment;
        this.salary = salary;
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(LocalDate dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
