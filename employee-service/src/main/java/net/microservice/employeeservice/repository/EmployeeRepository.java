package net.microservice.employeeservice.repository;

import net.microservice.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
