package net.microservices.organizationservice.service.Impl;

import lombok.AllArgsConstructor;
import net.microservices.organizationservice.dto.OrganizationDto;
import net.microservices.organizationservice.entity.Organization;
import net.microservices.organizationservice.mapper.OrganizationMapper;
import net.microservices.organizationservice.repository.OrganizationRepository;
import net.microservices.organizationservice.service.OrganizationService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class OrganizationServiceImpl implements OrganizationService {



    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {

        Organization organization = OrganizationMapper.maptoOrganization(organizationDto);
        Organization savedOrganization = organizationRepository.save(organization);
        OrganizationDto organizationDto1 = OrganizationMapper.maptoOrganizationDto(savedOrganization);

        return organizationDto1;
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
        return OrganizationMapper.maptoOrganizationDto(organization);
    }

}
