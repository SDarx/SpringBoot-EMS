package com.springboot.ems.services;

import com.springboot.ems.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    List<Employee> GetAllEmployees();

    Employee getEmployeeById(Long Id);
}
