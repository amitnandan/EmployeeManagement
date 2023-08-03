package net.microservice.departmentservice.service;

import net.microservice.departmentservice.dto.DepartmentDto;
import net.microservice.departmentservice.entity.Department;
import org.springframework.stereotype.Service;

public interface DepartmentService {

    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartment(String departmentCode);
}
