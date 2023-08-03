package net.microservice.employeeservice.dto;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class EmployeeDto {
    private Long id ;
    private String firstName ;
    private String lastName ;
    private String email ;
    private String departmentCode ;
    private String organizationCode;
}
