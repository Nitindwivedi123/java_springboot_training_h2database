package com.consultadd.controller;

import com.consultadd.model.Employee;
import com.consultadd.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EployeeController {
    @Autowired
    EmployeeService employeeservice;

    @GetMapping("/employee")
    public List<Employee> getemployee(){
        return employeeservice.employeedetails();
    }

    @PostMapping("/addemployee")
    public String addemployee(@RequestBody Employee employee){
        return employeeservice.addemployee(employee);
    }

    @DeleteMapping("/deleteemployee")
    public String deleteemployee(@RequestBody Employee employee){
        return employeeservice.deleteemployee(employee);
    }

    @PutMapping("/updateemployee")
    public String updateemployee(@RequestBody Employee employee){
        return employeeservice.updateeemployee(employee);
    }
    @GetMapping("employee/{city}")
    public ResponseEntity findcity(@PathVariable("city") String city){
        return ResponseEntity.ok(employeeservice.findcity(city));

    }


}
