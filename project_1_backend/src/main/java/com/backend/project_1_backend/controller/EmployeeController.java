package com.backend.project_1_backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.project_1_backend.model.Employee;
import com.backend.project_1_backend.service.EmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //GETTING ALL EMPLOYEES
    @GetMapping("/Employee/GetData")
    public List<Employee> getEmployeeData()
    {
        return employeeService.getEmployees();
    }

    //GETTING A SINGLE EMPLOYEE BY ID
    @GetMapping("/Employee/GetData/{id}")
    public Optional<Employee> getSingleEmployee(@PathVariable int id)
    {
        return employeeService.getAnEmployee(id);
    }

    //ADDING A SINGLE EMPLOYEE
    @PostMapping("/Employee/postData")
    public Employee postEmployee(@RequestBody Employee employee)
    {
        return employeeService.addAnEmployee(employee);
    }

    //UPDATING AN EXISTING EMPLOYEE BY EMPLOYEE ID
    @PutMapping("Employee/updateData/{id}")
    public Employee updatEmployee(@RequestBody Employee employee,@PathVariable int id)
    {
        return employeeService.updateAnEmployee(employee);
    }

    //DELETE AN EXISTING EMPLOYEE BY EMPLOYEE ID
    @DeleteMapping("Employee/deleteData/{id}")
    public String deleteEmployee(@PathVariable int id)
    {
        return employeeService.deleteAnEmployee(id);
    }
}

