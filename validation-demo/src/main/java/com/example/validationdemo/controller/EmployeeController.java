package com.example.validationdemo.controller;

import com.example.validationdemo.dto.CreateEmployeeRequest;
import com.example.validationdemo.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public void createEmployee(@RequestBody @Valid CreateEmployeeRequest createEmployeeDto) {
        employeeService.createEmployee(createEmployeeDto.toEmployee());
    }
}
