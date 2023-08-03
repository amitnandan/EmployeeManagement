package net.microservice.employeeservice.service.impl;


import net.microservice.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient( name = "DEPARTMENT-SERVICE")
public interface APIClient {

    //http://localhost:8080/api/department/EC001
    @GetMapping("api/department/{department-code}")
    DepartmentDto getDepartment(@PathVariable("department-code") String departmentCode);

}
