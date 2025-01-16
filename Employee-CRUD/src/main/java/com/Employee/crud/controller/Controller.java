package com.Employee.crud.controller;

import com.Employee.crud.entity.Employee;
import com.Employee.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("crud/employees")
public class Controller {
    @Autowired
    EmployeeService empServ;

    @GetMapping
    public List<Employee> getAll(){
       return empServ.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getById(@PathVariable int id){
        return empServ.getById(id);
    }

    @PostMapping("/insert")
    public String insertEmployee(@RequestBody Employee emp){
        return empServ.insertEmployee(emp);
    }

    @PutMapping("/update/{id}")
    public String updateEmployee(@PathVariable int id,@RequestBody Employee emp){
        return empServ.updateEmployee(id,emp);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id){
        return empServ.deleteEmployee(id);
    }

}
