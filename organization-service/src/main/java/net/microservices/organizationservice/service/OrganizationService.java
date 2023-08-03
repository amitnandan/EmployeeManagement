package net.microservices.organizationservice.service;

import net.microservices.organizationservice.dto.OrganizationDto;
import net.microservices.organizationservice.entity.Organization;

public interface OrganizationService {
    OrganizationDto saveOrganization(OrganizationDto organizationDto);

    OrganizationDto getOrganizationByCode( String organizationCode);
}
