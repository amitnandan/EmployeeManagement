package net.microservice.departmentservice.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.microservice.departmentservice.dto.DepartmentDto;
import net.microservice.departmentservice.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/department")

@Tag(name = "Department Service - Department Controller"
    ,description = "Department Controller exposes REST APIs for Department Service"
)
public class DepartmentController {

    private DepartmentService departmentService;


    @Operation(
            summary = "Save Department REST API",
            description = "Save Department REST API is used to save department object in a database"
    )
    @ApiResponse(
            responseCode = "201"
        ,description = "HTTP STATUS 201 CREATED"
    )
    @PostMapping("create")
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto)
    {

        DepartmentDto saveDepartment = departmentService.saveDepartment(departmentDto);
        return  new ResponseEntity<>(saveDepartment, HttpStatus.CREATED);
    }



    @Operation(
            summary = "GET Department REST API",
            description = "GET Department REST API is used to get department object from a database"
    )
    @ApiResponse(
            responseCode = "200"
            ,description = "HTTP STATUS 200 SUCCESS"
    )

    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode)
    {
        DepartmentDto departmentDto = departmentService.getDepartment(departmentCode);
        return  new ResponseEntity<>(departmentDto,HttpStatus.OK);
    }

}
