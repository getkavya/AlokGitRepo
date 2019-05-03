package com.example.oauth2.resourceserver.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.oauth2.resourceserver.model.Employee;

@RestController
public class EmployeeController {

    @GetMapping(path = "/getEmployeesList")
    public List<Employee> getEmployeesList() {
        List<Employee> employees = new ArrayList<Employee>();
        Employee emp = new Employee();
        emp.setEmpId("10626680");
        emp.setEmpName("Alok");
        employees.add(emp);
        return employees;

    }

}
