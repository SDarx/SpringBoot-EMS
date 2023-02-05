package com.springboot.ems.controller;

import com.springboot.ems.model.Employee;
import com.springboot.ems.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/employees"})
public class EmployeeController {
    private EmployeeService _employeeService;

    public EmployeeController(EmployeeService _employeeService) {
        this._employeeService = _employeeService;
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee (@RequestBody Employee employee){
        return new ResponseEntity(_employeeService.createEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return _employeeService.GetAllEmployees();
    }

    @GetMapping({"{Id}"})
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("Id") Long Id){
        return new ResponseEntity(_employeeService.getEmployeeById(Id), HttpStatus.FOUND);
    }
}
