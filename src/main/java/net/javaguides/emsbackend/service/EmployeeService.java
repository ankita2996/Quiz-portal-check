package net.javaguides.emsbackend.service;

import net.javaguides.emsbackend.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto findById(Long ID);
    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long id,EmployeeDto updatedEmployee);

    void deleteEmployee(Long id);
}
