package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;
import java.util.ArrayList;

@Service
public class CompensationServiceImpl implements CompensationService {

    private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CompensationRepository compensationRepository;

    @Override
    public Compensation create(Compensation comp) {
        /*
         * 1. Use the provided compensation variable to find the employee associated. 
         * 2. Set the employee id to the id variable in Compensation (may not be neccessary)
         * 3. Insert into Compensation Repo. 
         */

        Employee employee = comp.getEmployee();
        String id = employee.getEmployeeId();

        comp.setCompId(id);
        LOG.debug("Creating compensation [{}]", comp);

        compensationRepository.insert(comp);

        return comp;

        // throw new RuntimeException("Employee with this id does not exist: " + employeeId);
        
       
    }

    @Override
    public Compensation read(String employeeId) {
        /*
         * 1. Get the employee using the employee read service. 
         * 2. Find the compensation using the found employee. 
         * 3. If not null return compensation object. 
         */

        //Employee emp = new Employee();
        Employee emp = employeeService.read(employeeId);
        Compensation comp = compensationRepository.findByEmployee(emp);
        // Compensation comp = new Compensation();
        LOG.debug("Creating reading report of employee [{}]", employeeId);

        if (comp == null) {
            throw new RuntimeException("Invalid employeeId: " + employeeId);
        } 
        
        return comp;
        
    }

}
