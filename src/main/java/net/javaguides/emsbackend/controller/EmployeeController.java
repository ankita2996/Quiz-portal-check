package net.javaguides.emsbackend.controller;

import lombok.AllArgsConstructor;
import net.javaguides.emsbackend.dto.EmployeeDto;
import net.javaguides.emsbackend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*") // for CORS policy both are on different ports
@RestController
@AllArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;


    // Add employee
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody  EmployeeDto employeeDto){
        EmployeeDto employeeSaved = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(employeeSaved, HttpStatus.CREATED);
    }
    //Find employee by id method
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> findById(@PathVariable Long id){
        EmployeeDto employeeSaved  = employeeService.findById(id);
//        return new ResponseEntity<>(employeeSaved, HttpStatus.OK);
        return  ResponseEntity.ok(employeeSaved);
    }
// Get All employees rest API

    @GetMapping
    public  ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    //update method
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,
                                                      @RequestBody EmployeeDto employeeDto){
       EmployeeDto employee = employeeService.updateEmployee(employeeId, employeeDto);
        return ResponseEntity.ok(employee);
    }


    //delete employee
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }


}

