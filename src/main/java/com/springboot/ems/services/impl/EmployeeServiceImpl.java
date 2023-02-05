package com.springboot.ems.services.impl;

import com.springboot.ems.customException.ResourceNotFoundException;
import com.springboot.ems.model.Employee;
import com.springboot.ems.repository.EmployeeRepository;
import com.springboot.ems.services.EmployeeService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository _employeeRepository;
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        _employeeRepository = employeeRepository;
    }

    public Employee createEmployee(Employee employee){
      return  _employeeRepository.save(employee);
   }

   public List<Employee> GetAllEmployees(){
        return _employeeRepository.findAll();
   }

   public Employee getEmployeeById(Long Id){
        return _employeeRepository.findById(Id).orElseThrow(() -> {
            return new ResourceNotFoundException("Employee","Id",Id);
        });
   }

}
