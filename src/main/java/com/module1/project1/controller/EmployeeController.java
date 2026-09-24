package com.module1.project1.controller;

import com.module1.project1.dto.EmployeeDTO;
import com.module1.project1.entity.Employee;
import com.module1.project1.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {

//    @GetMapping(path ="/")
//    public String getMessage(){
//        return "Super message !! Learning springboot";
//    }

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping(path="/{employeeId}")
    public Optional<Employee> getEmployeeById(@PathVariable(name="employeeId")long id){
        return employeeRepository.findById(id);
    }

    @GetMapping
    public List<Employee> getAllEmployeeById(@RequestParam(required = false, name="inputAge") Integer age,
                                             @RequestParam(required = false) String sortBy){
        return employeeRepository.findAll();
    }

    @PostMapping
    public Employee createNewEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @PutMapping
    public String updateEmployee(){
        return "Update new employee";
    }

}
