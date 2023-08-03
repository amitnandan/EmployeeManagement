package net.microservices.organizationservice.mapper;

import net.microservices.organizationservice.dto.OrganizationDto;
import net.microservices.organizationservice.entity.Organization;

public class OrganizationMapper {



    public static Organization maptoOrganization(OrganizationDto organizationDto)
    {
        Organization organization = new Organization(
                organizationDto.getId(),
                organizationDto.getOrganizationName(),
                organizationDto.getOrganizationDescription(),
                organizationDto.getOrganizationCode(),
                organizationDto.getCreatedDate()
        );
        return
                organization;
    }
    public static OrganizationDto maptoOrganizationDto(Organization organization)
    {
        OrganizationDto organizationDto = new OrganizationDto(
                organization.getId(),
                organization.getOrganizationName(),
                organization.getOrganizationDescription(),
                organization.getOrganizationCode(),
                organization.getCreatedDate()
        );
        return
                organizationDto;
    }

}
