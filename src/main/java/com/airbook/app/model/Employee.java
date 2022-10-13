package com.airbook.app.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    private Long Id;
    @Column(name = "uniq_id")
    private UUID uniqId;
    @Column(name = "captain_name")
    private String name;
    @Column(name = "position")
    private String position;
    @Column(name = "birthday")
    private String birthday;
    @Column(name = "date_of_employment")
    private String dateOfEmployment;
    @Column(name = "salary")
    private Integer salary;

    public Employee(String name, String position, String birthday, String dateOfEmployment, Integer salary) {
        this.name = name;
        this.uniqId = UUID.randomUUID();
        this.position = position;
        this.birthday = birthday;
        this.dateOfEmployment = dateOfEmployment;
        this.salary = salary;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(String dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public UUID getUniqId() {
        return uniqId;
    }
}
