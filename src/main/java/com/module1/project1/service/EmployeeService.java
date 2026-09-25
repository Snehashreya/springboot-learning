package com.module1.project1.service;

import com.module1.project1.dto.EmployeeDTO;
import com.module1.project1.entity.Employee;
import com.module1.project1.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getEmployeeById(Long id){
        Employee employee = employeeRepository.findById(id).orElse(null);
        return modelMapper.map(employee,EmployeeDTO.class);
    }
    public List<EmployeeDTO> getEmployees(){
        List<Employee> employees = employeeRepository.findAll();
        return employees
                .stream()
                .map(emp->modelMapper.map(emp,EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeeDTO createEmployee(EmployeeDTO inputEmployee) {
        Employee toSaveEntity = modelMapper.map(inputEmployee,Employee.class);
        Employee savedEmployee = employeeRepository.save(toSaveEntity);
        return modelMapper.map(savedEmployee, EmployeeDTO.class);
    }
}
