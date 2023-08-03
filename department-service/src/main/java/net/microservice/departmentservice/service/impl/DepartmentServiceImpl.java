package net.microservice.departmentservice.service.impl;

import lombok.AllArgsConstructor;
import net.microservice.departmentservice.dto.DepartmentDto;
import net.microservice.departmentservice.entity.Department;
import net.microservice.departmentservice.exception.ResourceNotFoundException;
import net.microservice.departmentservice.repository.DepartmentRepository;
import net.microservice.departmentservice.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    private ModelMapper modelMapper;



    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        //Converting Department DTO to Department JPA entity
//        Department department = new Department(
//          departmentDto.getId(),
//          departmentDto.getDepartmentName(),
//          departmentDto.getDepartmentDescription(),
//          departmentDto.getDepartmentCode()
//        );

        Department department = modelMapper.map(departmentDto,Department.class);

        Department savedDepartment =  departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = modelMapper.map(savedDepartment,DepartmentDto.class);
//                new DepartmentDto(
//                savedDepartment.getId(),
//                savedDepartment.getDepartmentName(),
//                savedDepartment.getDepartmentDescription(),
//                savedDepartment.getDepartmentCode()
//        );
        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartment(String departmentCode) {



        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        if(department == null)
        {
            throw new ResourceNotFoundException("Department","DepartmentCode",departmentCode);
        }


        DepartmentDto departmentDto = modelMapper.map(department,DepartmentDto.class);
//                new DepartmentDto(
//                department.getId(),
//                department.getDepartmentName(),
//                department.getDepartmentDescription(),
//                department.getDepartmentCode()
//        );

        return departmentDto;

    }
}
