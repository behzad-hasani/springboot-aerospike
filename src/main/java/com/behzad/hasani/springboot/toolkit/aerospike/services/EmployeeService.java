package com.behzad.hasani.springboot.toolkit.aerospike.services;

import com.behzad.hasani.springboot.toolkit.aerospike.entities.EmployeeEntity;
import com.behzad.hasani.springboot.toolkit.aerospike.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {

    @Autowired
   private EmployeeRepository employeeRepository;

    public List<EmployeeEntity> getEmployeesByLastName(String lastName) {
            return employeeRepository.findByLastName(lastName).orElse(null);
    }
    public List<EmployeeEntity> getEmployeesByFirstName(String firstName) {
        return employeeRepository.findByFirstName(firstName).orElse(null);
    }

    public EmployeeEntity getEmployeeById(String id) {
        return employeeRepository.findById(id).orElse(null);
    }
    public EmployeeEntity addEmployee(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }
    public void removeEmployee(String id) {
         employeeRepository.deleteById(id);
    }

}
