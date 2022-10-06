package com.mindex.challenge.data;

import java.util.List;
import java.util.Objects;
import java.time.Instant;

public class Compensation {
    /*
     * Id variable may not be needed. 
     * Standard getters and setters. 
     */

    private String id;
    private Employee employee;
    private Integer salary;
    private String effectiveDate;

    public Compensation() {
    }

    public String getCompId() {
        return id;
    }

    public void setCompId(String id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String date) {
        this.effectiveDate = date;
    }

}
