package com.consultadd.service;

import com.consultadd.model.Employee;
import com.consultadd.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeerepository;

    public List<Employee> employeedetails(){
        List<Employee> employeedetails= employeerepository.findAll();
        return employeedetails;
    }

    public String addemployee(Employee employee){
        if (employeerepository.existsById(employee.getId())){
            return "Employee already exist.";
        }else{
            employeerepository.save(employee);
            return "Employee added sucessfully";
        }
    }

    public String deleteemployee(Employee employee){
        if (employeerepository.existsById(employee.getId())){
            employeerepository.delete(employee);
            return "Employee deleted successfully.";
        }else{
            return "Employee does not exist.";
        }
    }

    public String updateeemployee(Employee employee){
        if (employeerepository.existsById(employee.getId())){
            employeerepository.save(employee);
            return "Employee details updated successfully.";
        }else{
            return "Employee does not exist.";
        }
    }

    public List<Employee> findcity(String city){
        return employeerepository.findAllByCity(city);

    }

}
