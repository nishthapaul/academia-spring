package com.iiitb.academia.service;

import com.iiitb.academia.entity.OrganisationHR;

import java.util.List;

public interface OrganisationHRService {

    List<OrganisationHR> findAll();

    OrganisationHR save(OrganisationHR organisationHR);

    OrganisationHR findById(int organisationHRId);

    void deleteById(int organisationHRId);

    List<OrganisationHR> findByOrganisationId(int organisationId);
}
