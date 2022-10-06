package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;
import java.util.ArrayList;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public ReportingStructure read(String employeeId) {
        /*
         * 1. Create report object. 
         * 2. Initialize employee object by searching the employee repo for the provided id. 
         * 3. Assign direct reports to employeeReports List object
         * 4. Check if currEmployee is null 
         * 5. Return reports if there are any. 
         * Note: may need to switch steps 3 and 4. 
         */
        ReportingStructure report = new ReportingStructure();
        Employee currEmployee = employeeRepository.findByEmployeeId(employeeId);
        List<Employee> employeeReports = currEmployee.getDirectReports();

        LOG.debug("Creating reading report of employee [{}]", employeeId);

        System.out.println(" This is the list: " + employeeReports);

        if (currEmployee == null) {
            throw new RuntimeException("Invalid employeeId: " + employeeId);
        } else {
            report.setEmployee(currEmployee);
            if(employeeReports == null) {
                report.setNumberOfReports(0);
            } else {
                report.setNumberOfReports(employeeReports.size());
            }
            
            return report;
        }
    }

}
