package com.backend.project_1_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.project_1_backend.model.Employee;
import com.backend.project_1_backend.repository.EmployeeRepo;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    //GETTING ALL EMPLOYEES
    public List<Employee> getEmployees()
    {
        return employeeRepo.findAll();
    }

    //GETTING A SINGLE EMPLOYEE BY EMPLOYEE ID
    public Optional<Employee> getAnEmployee(int em_id)
    {
        return employeeRepo.findById(em_id);
    }

    //ADDING AN EMPLOYEE
    public Employee addAnEmployee(Employee employee)
    {
        return employeeRepo.save(employee);
    }

    //UPDATING AN EXISTING EMPLOYEE BY EMPLOYEE ID
    public Employee updateAnEmployee(Employee employee)
    {
        return employeeRepo.save(employee);
    }

    //DELETING AN EXISTING EMPLOYEE BY EMPLOYEE ID
    public String deleteAnEmployee(int em_id)
    {
        employeeRepo.deleteById(em_id);
        return "Employee is deleted";
    }
}
