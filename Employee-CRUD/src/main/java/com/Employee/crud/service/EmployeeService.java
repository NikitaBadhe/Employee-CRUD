package com.Employee.crud.service;
import java.util.List;
import java.util.Optional;

import com.Employee.crud.entity.Employee;
import com.Employee.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService  {
    @Autowired
    EmployeeRepository empRepo;
    public List<Employee> getAll(){
        return empRepo.findAll();
    }

    public Optional<Employee> getById(int id){
        return empRepo.findById(id);
    }

    public String insertEmployee(Employee emp){
        empRepo.save(emp);
        return "Successfully added";
    }
     public String updateEmployee(int id,Employee emp){
        Employee emp1=empRepo.findById(id).orElseThrow(()-> new RuntimeException("id not found"));
        emp1.setId(emp.getId());
        emp1.setName(emp.getName());
        emp1.setRole(emp.getRole());
        emp1.setSalary(emp.getSalary());
        empRepo.save(emp1);
        return "successfully updated";
    }

    public String deleteEmployee(int id){
        empRepo.deleteById(id);
        return "deleted Successfully";
    }


}
