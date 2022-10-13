//package com.airbook.app.model;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//import java.util.UUID;
//
//@Entity
//@Table(name = "employees")
//public class Employee {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "emp-id")
//    private Long Id;
//    @Column(name = "uniq-id")
//    private UUID uniqId;
////    @OneToOne
////    @PrimaryKeyJoinColumn(name = "emp-id")
//    @Column(name = "captain-name")
//    private String name;
//    @Column(name = "position")
//    private String position;
//    @Column(name = "birthday")
//    private LocalDate birthday;
//    @Column(name = "date-of-employment")
//    private LocalDate dateOfEmployment;
//    @Column(name = "salary")
//    private Integer salary;
//
//    public Employee(String name, String position, LocalDate birthday, LocalDate dateOfEmployment, Integer salary) {
//        this.name = name;
//        this.uniqId = UUID.randomUUID();
//        this.position = position;
//        this.birthday = birthday;
//        this.dateOfEmployment = dateOfEmployment;
//        this.salary = salary;
//    }
//
//    public Employee() {
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getPosition() {
//        return position;
//    }
//
//    public void setPosition(String position) {
//        this.position = position;
//    }
//
//    public LocalDate getBirthday() {
//        return birthday;
//    }
//
//    public void setBirthday(LocalDate birthday) {
//        this.birthday = birthday;
//    }
//
//    public LocalDate getDateOfEmployment() {
//        return dateOfEmployment;
//    }
//
//    public void setDateOfEmployment(LocalDate dateOfEmployment) {
//        this.dateOfEmployment = dateOfEmployment;
//    }
//
//    public Integer getSalary() {
//        return salary;
//    }
//
//    public void setSalary(Integer salary) {
//        this.salary = salary;
//    }
//
//    public UUID getUniqId() {
//        return uniqId;
//    }
//}
