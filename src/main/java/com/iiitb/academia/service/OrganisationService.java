package com.iiitb.academia.service;

import com.iiitb.academia.entity.Organisation;

import java.util.List;

public interface OrganisationService {

    List<Organisation> findAll();

    Organisation save(Organisation organisation);

    Organisation findById(int organisationId);

    void deleteById(int organisationId);
}
