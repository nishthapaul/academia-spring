package com.iiitb.academia.rest;

import com.iiitb.academia.entity.Organisation;
import com.iiitb.academia.exceptions.OrganisationNotFoundException;
import com.iiitb.academia.service.OrganisationService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrganisationController {
    private final OrganisationService organisationService;

    @Autowired
    public OrganisationController(OrganisationService organisationService) {
        this.organisationService = organisationService;
    }

    @GetMapping("/organisations")
    public List<Organisation> getOrganisations() {
        return organisationService.findAll();
    }

    @GetMapping("/organisations/{organisationId}")
    public Organisation getOrganisation(@PathVariable int organisationId) {
        Organisation organisation = organisationService.findById(organisationId);
        if ( organisation == null ) {
            throw new OrganisationNotFoundException("Organisation with Organisation Id : " + organisationId + " not found");
        }
        return organisation;
    }

    @PostMapping("/organisations")
    public Organisation addOrganisation(@RequestBody Organisation organisation) {
        organisation.setOrganisationId(0);
        return organisationService.save(organisation);
    }

    @PutMapping("/organisations/{organisationId}")
    public Organisation editOrganisation(@PathVariable int organisationId, @RequestBody Organisation organisation) {
        organisation.setOrganisationId(organisationId);
        return organisationService.save(organisation);
    }

    @DeleteMapping("/organisations/{organisationId}")
    public void deleteOrganisation(@PathVariable int organisationId) {
        organisationService.deleteById(organisationId);
    }
}
