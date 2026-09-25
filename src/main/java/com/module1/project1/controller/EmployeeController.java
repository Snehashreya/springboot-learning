package com.module1.project1.controller;

import com.module1.project1.dto.EmployeeDTO;
import com.module1.project1.entity.Employee;
import com.module1.project1.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
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
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name="employeeId")long id){
        Optional<EmployeeDTO> employeeDTO = employeeService.getEmployeeById(id);
        return employeeDTO
                .map(employeeDTO1 ->
                        ResponseEntity.ok(employeeDTO1))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployeeById(@RequestParam(required = false, name="inputAge") Integer age,
                                             @RequestParam(required = false) String sortBy){
        return ResponseEntity.ok(employeeService.getEmployees());
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody @Valid EmployeeDTO inputEmployee){
        EmployeeDTO savedEmployeeDTO = employeeService.createEmployee(inputEmployee);
        return new ResponseEntity<>(savedEmployeeDTO, HttpStatus.CREATED);
    }

    @PutMapping(path ="/{employeeId}")
    public ResponseEntity<EmployeeDTO>  updateEmployee(@RequestBody EmployeeDTO updateEmployee, @PathVariable Long employeeId){
        return ResponseEntity.ok(employeeService.updateEmployee(updateEmployee,employeeId));
    }

    @DeleteMapping(path ="{employeeId}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable Long employeeId) {
        boolean gotDeleted = employeeService.deleteEmployeeById(employeeId);
        return ResponseEntity.notFound().build();
    }

//    @PatchMapping(path ="/{employeeId}")
//    public EmployeeDTO updatepartialEmployeeById(@RequestBody Map<String,Object> updates,
//                                                 @PathVariable Long employeeId){
//        return employeeService.updatePartialEmployee(updates,employeeId);
//    }
}
