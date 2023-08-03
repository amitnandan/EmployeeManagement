package net.microservices.organizationservice.controller;

import lombok.AllArgsConstructor;
import net.microservices.organizationservice.dto.OrganizationDto;
import net.microservices.organizationservice.service.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping("api/organizations")
@RestController
public class OrganizationController {

    private OrganizationService organizationService;

    @PostMapping("create")
    public ResponseEntity<OrganizationDto> saveOrganization( @RequestBody OrganizationDto organizationDto)
    {

       OrganizationDto savedOrganizationDto = organizationService.saveOrganization(organizationDto);
        return new ResponseEntity<>(savedOrganizationDto , HttpStatus.CREATED);
    }

    @GetMapping("{organization-code}")
    public ResponseEntity<OrganizationDto> getOrganizationByOrganizationCode( @PathVariable("organization-code") String organizationCode )
    {
     OrganizationDto organizationDto =   organizationService.getOrganizationByCode(organizationCode);

        return  new ResponseEntity<>(organizationDto,HttpStatus.OK);
    }

}
