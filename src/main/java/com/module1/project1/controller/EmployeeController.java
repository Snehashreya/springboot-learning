package com.module1.project1.controller;

import com.module1.project1.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {

//    @GetMapping(path ="/")
//    public String getMessage(){
//        return "Super message !! Learning springboot";
//    }

    @GetMapping(path="/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name="employeeId")long id){
        return new EmployeeDTO(id,"sneha","sneha@gmail.com",25, LocalDate.of(2026,9,21),true);
    }

    @GetMapping
    public String getAllEmployeeById(@RequestParam(required = false, name="inputAge") Integer age,
                                          @RequestParam String sortBy){
        return "My age is:" +age + " " +sortBy;
    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO employee){
        employee.setId(100L);
        return employee;
    }
    @PutMapping
    public String updateEmployee(){
        return "Update new employee";
    }

}
