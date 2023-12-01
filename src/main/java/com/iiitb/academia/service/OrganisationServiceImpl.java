package com.iiitb.academia.service;

import com.iiitb.academia.dao.OrganisationRepository;
import com.iiitb.academia.entity.Organisation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganisationServiceImpl implements OrganisationService {
    private OrganisationRepository organisationRepository;

    @Autowired
    public OrganisationServiceImpl(OrganisationRepository organisationRepository) {
        this.organisationRepository = organisationRepository;
    }

    @Override
    public List<Organisation> findAll() {
        return organisationRepository.findAll();
    }

    @Override
    public Organisation save(Organisation organisation) {
        return organisationRepository.save(organisation);
    }

    @Override
    public Organisation findById(int organisationId) {
        Optional<Organisation> result = organisationRepository.findById(organisationId);
        Organisation organisation = null;
        if ( result.isPresent() ) {
            organisation = result.get();
        } else {
            throw new RuntimeException("Did not find organisation id - " + organisationId);
        }
        return organisation;
    }

    @Override
    public void deleteById(int organisationId) {
        organisationRepository.deleteById(organisationId);
    }


}
