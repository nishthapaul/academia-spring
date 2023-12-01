package com.iiitb.academia.rest;

import com.iiitb.academia.entity.OrganisationHR;
import com.iiitb.academia.exceptions.model.DuplicateEmailException;
import com.iiitb.academia.exceptions.OrganisationNotFoundException;
import com.iiitb.academia.service.OrganisationHRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrganisationHRController {
    private final OrganisationHRService organisationHRService;

    @Autowired
    public OrganisationHRController(OrganisationHRService organisationHRService) {
        this.organisationHRService = organisationHRService;
    }

    @GetMapping("/organisation-hrs")
    public List<OrganisationHR> getOrganisations() {
        return organisationHRService.findAll();
    }

    @GetMapping("/organisation-hrs/organisation/{organisationId}")
    public List<OrganisationHR> getOrganisationHRByOrganisationId(@PathVariable int organisationId) {
        return organisationHRService.findByOrganisationId(organisationId);
    }

    @GetMapping("/organisation-hrs/organisationHR/{organisationHRId}")
    public OrganisationHR getOrganisationHRByOrganisationHRId(@PathVariable int organisationHRId) {
        OrganisationHR organisationHR = organisationHRService.findById(organisationHRId);
        if ( organisationHR == null ) {
            throw new OrganisationNotFoundException("Organisation with Organisation HR Id : " + organisationHRId + " not found");
        }
        return organisationHR;
    }

    @PostMapping("/organisation-hrs")
    public ResponseEntity<OrganisationHR> addOrganisationHR(@RequestBody OrganisationHR organisationHR) {
        organisationHR.setOrganisationHRId(0);
        try {
            OrganisationHR dbOrganisationHR = organisationHRService.save(organisationHR);
            return new ResponseEntity<>(dbOrganisationHR, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException ex) {
            throw new DuplicateEmailException("Email is already in use", ex);
        }
    }

    @DeleteMapping("/organisation-hrs/{organisationHRId}")
    public void deleteOrganisationHR(@PathVariable int organisationHRId) {
        organisationHRService.deleteById(organisationHRId);
    }
}
