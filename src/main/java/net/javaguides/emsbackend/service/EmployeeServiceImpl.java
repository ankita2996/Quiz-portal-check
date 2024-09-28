package net.javaguides.emsbackend.service;

import lombok.AllArgsConstructor;
import net.javaguides.emsbackend.dto.EmployeeDto;
import net.javaguides.emsbackend.entity.Employee;
import net.javaguides.emsbackend.exception.ResourceNotFind;
import net.javaguides.emsbackend.mapper.EmployeeMapper;
import net.javaguides.emsbackend.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements  EmployeeService{

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee =   employeeRepository.save(employee);


        return EmployeeMapper.mapToEmployeeDto(savedEmployee );
    }

    @Override
    public EmployeeDto findById(Long id) {
       Employee employee = employeeRepository.findById(id).orElseThrow( () -> new  ResourceNotFind("Record does not exist with id " + id));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                        .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto updatedEmployee) {
       Employee employee =  employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFind("Employees does not exist with given id" + id));
       employee.setFirstName(updatedEmployee.getFirstName());
       employee.setLastName(updatedEmployee.getLastName());
       employee.setEmail(updatedEmployee.getEmail());
       Employee employee1 =employeeRepository.save(employee);//if employee object contains id it internally performs save operation
        // if employee object doest not contain id then it will perform insert operation
        return EmployeeMapper.mapToEmployeeDto(employee1);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee =  employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFind("Employees does not exist with given id" + id));
        employeeRepository.deleteById(id);
    }
}
