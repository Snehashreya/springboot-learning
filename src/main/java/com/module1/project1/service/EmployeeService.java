package com.module1.project1.service;

import com.module1.project1.dto.EmployeeDTO;
import com.module1.project1.entity.Employee;
import com.module1.project1.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<EmployeeDTO> getEmployeeById(Long id){
//        Optional<Employee> employee = employeeRepository.findById(id);
//        return employee.map(employee1 -> modelMapper.map(employee1,EmployeeDTO.class));

        return employeeRepository.findById(id).map(employee -> modelMapper.map(employee,EmployeeDTO.class));
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

    public EmployeeDTO updateEmployee(EmployeeDTO updateEmployee, Long employeeId) {
        Employee employee = modelMapper.map(updateEmployee,Employee.class);
        employee.setId(employeeId);
        Employee saveEmployee = employeeRepository.save(employee);
        return modelMapper.map(saveEmployee,EmployeeDTO.class) ;
    }

    public boolean isExistByEmployeeId(Long employeeId){
        boolean exists = isExistByEmployeeId(employeeId);
        if(!exists) return false;
        return employeeRepository.existsById(employeeId);
    }

    public boolean deleteEmployeeById(Long employeeId) {
        employeeRepository.deleteById(employeeId);
        return true;
    }

//    public EmployeeDTO updatePartialEmployee(Map<String, Object> updates, Long employeeId) {
//        Employee employee = employeeRepository.findById(employeeId).get();
//        updates.forEach((field,value)->{
//            Field fieldToBeUpdated = ReflectionUtils.findRequiredField(employee.class, field);
//            fieldToBeUpdated.setAccessible(true);
//            ReflectionUtils.setField(fieldToBeUpdated,employee,value);
//        });
//        return modelMapper.map(employeeRepository.save(employee),EmployeeDTO.class);
//    }
}
