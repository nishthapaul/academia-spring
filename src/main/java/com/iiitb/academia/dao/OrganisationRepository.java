package com.iiitb.academia.dao;

import com.iiitb.academia.entity.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//@RepositoryRestResource(path = "orgs")
public interface OrganisationRepository extends JpaRepository<Organisation, Integer> {}
