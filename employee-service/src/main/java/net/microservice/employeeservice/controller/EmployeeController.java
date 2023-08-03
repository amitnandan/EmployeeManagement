package net.microservice.employeeservice.controller;


import lombok.AllArgsConstructor;
import net.microservice.employeeservice.dto.APIResponseDto;
import net.microservice.employeeservice.dto.EmployeeDto;
import net.microservice.employeeservice.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    private EmployeeService employeeService ;

    @PostMapping("create")
    public ResponseEntity<EmployeeDto> createEmployee( @RequestBody  EmployeeDto employeeDto)
    {

        EmployeeDto employeeDto1 = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(employeeDto1 , HttpStatus.CREATED);
    }

    @GetMapping("{employee-id}")
    public  ResponseEntity<APIResponseDto> getEmployee(@PathVariable("employee-id") Long employeeId)
    {

        APIResponseDto apiResponseDto = employeeService.getEmployeeById(employeeId);
        return  new ResponseEntity<>(apiResponseDto,HttpStatus.OK);
    }

}
