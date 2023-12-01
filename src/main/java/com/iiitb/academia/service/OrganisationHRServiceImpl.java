package com.iiitb.academia.service;

import com.iiitb.academia.dao.OrganisationHRRepository;
import com.iiitb.academia.entity.OrganisationHR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganisationHRServiceImpl implements OrganisationHRService {
    private OrganisationHRRepository organisationHRRepository;

    @Autowired
    public OrganisationHRServiceImpl(OrganisationHRRepository organisationHRRepository) {
        this.organisationHRRepository = organisationHRRepository;
    }

    @Override
    public List<OrganisationHR> findAll() {
        return organisationHRRepository.findAll();
    }

    @Override
    public OrganisationHR save(OrganisationHR organisationHR) {
        return organisationHRRepository.save(organisationHR);
    }

    @Override
    public OrganisationHR findById(int organisationHRId) {
        Optional<OrganisationHR> result = organisationHRRepository.findById(organisationHRId);
        OrganisationHR organisationHR = null;
        if ( result.isPresent() ) {
            organisationHR = result.get();
        } else {
            throw new RuntimeException("Did not find HR Id - " + organisationHRId);
        }
        return organisationHR;
    }

    @Override
    public void deleteById(int organisationHRId) {
        organisationHRRepository.deleteById(organisationHRId);
    }

    @Override
    public List<OrganisationHR> findByOrganisationId(int organisationId) {
        return organisationHRRepository.findByOrganisationOrganisationId(organisationId);
    }

}
