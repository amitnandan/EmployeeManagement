package net.microservice.employeeservice.service.impl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import net.microservice.employeeservice.dto.APIResponseDto;
import net.microservice.employeeservice.dto.DepartmentDto;
import net.microservice.employeeservice.dto.EmployeeDto;
import net.microservice.employeeservice.dto.OrganizationDto;
import net.microservice.employeeservice.entity.Employee;
import net.microservice.employeeservice.exception.ResourceNotFoundException;
import net.microservice.employeeservice.repository.EmployeeRepository;
import net.microservice.employeeservice.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {


    private  APIClient apiClient;
    private WebClient webClient;
    //private RestTemplate restTemplate;
    private ModelMapper modelMapper ;

    private EmployeeRepository employeeRepository;

    private static Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);


    @Override

    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {


        Employee employee = modelMapper.map(employeeDto,Employee.class);
//                new Employee(
//                employeeDto.getId(),
//                employeeDto.getFirstName(),
//                employeeDto.getLastName(),
//                employeeDto.getEmail()
//        );

        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = modelMapper.map(savedEmployee , EmployeeDto.class);
//                new EmployeeDto(
//                savedEmployee.getId(),
//                savedEmployee.getFirstName(),
//                savedEmployee.getLastName(),
//                savedEmployee.getEmail()
//        );

        return savedEmployeeDto;


    }


    //@CircuitBreaker(name = "${spring.application.name}",fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}",fallbackMethod = "getDefaultDepartment")
    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {


        LOGGER.info("inside getEmployeeByID() method");

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                ()-> {
                    return new ResourceNotFoundException("Employee", "EmployeeID", employeeId);
                }
        );

//       ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/department/"+employee.getDepartmentCode(), DepartmentDto.class);
//
//       DepartmentDto departmentDto = responseEntity.getBody();



//        DepartmentDto departmentDto = webClient.get().uri("http://localhost:8080/api/department/"+employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class).block();






       DepartmentDto departmentDto =  apiClient.getDepartment(employee.getDepartmentCode());


        OrganizationDto organizationDto = webClient.get().uri("http://localhost:8083/api/organizations/"+employee.getOrganizationCOde())
                .retrieve().bodyToMono(OrganizationDto.class).block();


       EmployeeDto employeeDto = modelMapper.map(employee , EmployeeDto.class);
//                new EmployeeDto(
//            employee.getId(),
//            employee.getFirstName(),
//            employee.getLastName(),
//            employee.getEmail()
//        );

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        apiResponseDto.setOrganizationDto(organizationDto);
         return apiResponseDto;
    }

    public APIResponseDto getDefaultDepartment(Long employeeId , Exception exception){


        LOGGER.info("inside getDefaultDepartment() method");

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                ()-> {
                    return new ResourceNotFoundException("Employee", "EmployeeID", employeeId);
                }
        );
        DepartmentDto departmentDto =  new DepartmentDto();
        departmentDto.setDepartmentName("R&D Department");
        departmentDto.setDepartmentCode("RD001");
        departmentDto.setDepartmentDescription("Research and Development Department");



        EmployeeDto employeeDto = modelMapper.map(employee , EmployeeDto.class);
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        return apiResponseDto;

    }

}
