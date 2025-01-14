package com.behzad.hasani.springboot.toolkit.aerospike.controllers;


import com.behzad.hasani.springboot.toolkit.aerospike.entities.EmployeeEntity;
import com.behzad.hasani.springboot.toolkit.aerospike.services.EmployeeService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees/{id}")
    public EmployeeEntity readTokenById(@PathVariable("id") String id) {
        return employeeService.getEmployeeById(id);
    }
    @GetMapping("/employees/name/{name}")
    public List<EmployeeEntity> getByFirstName(@PathParam("name") String name) {
        return employeeService.getEmployeesByFirstName(name);
    }

    @GetMapping("/employees/name/{last}")
    public List<EmployeeEntity> getByLastName(@PathParam("last") String last) {
        return employeeService.getEmployeesByLastName(last);
    }

    @PostMapping("/employees")
    public EmployeeEntity addEmployee(@RequestBody EmployeeEntity employeeEntity) {

        return employeeService.addEmployee(employeeEntity);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteTokenById(@PathVariable("id") String id) {
        employeeService.removeEmployee(id);
    }
}
