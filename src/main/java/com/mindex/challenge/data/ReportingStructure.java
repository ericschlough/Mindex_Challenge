package com.mindex.challenge.data;

import java.util.List;
import com.mindex.challenge.data.Employee;

public class ReportingStructure {
    private Employee employee;
    private Integer numberOfReports;

    public ReportingStructure() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    public Integer getNumberOfReports() {
        return numberOfReports;
    }

    public void setNumberOfReports(Integer number) {
        this.numberOfReports = number;
    }


}
