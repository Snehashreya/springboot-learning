package com.module1.project1.controller;

import com.module1.project1.dto.EmployeeDTO;
import com.module1.project1.entity.Employee;
import com.module1.project1.repository.EmployeeRepository;
import com.module1.project1.service.EmployeeService;
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

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path="/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name="employeeId")long id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployeeById(@RequestParam(required = false, name="inputAge") Integer age,
                                             @RequestParam(required = false) String sortBy){
        return employeeService.getEmployees();
    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
        return employeeService.createEmployee(inputEmployee);
    }

    @PutMapping
    public String updateEmployee(){
        return "Update new employee";
    }

}
