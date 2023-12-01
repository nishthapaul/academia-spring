package com.iiitb.academia.dao;

import com.iiitb.academia.entity.OrganisationHR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganisationHRRepository extends JpaRepository<OrganisationHR, Integer> {
    @Query(value = "SELECT * FROM organisation_hr WHERE organisation_id = :organisationId", nativeQuery = true)
    List<OrganisationHR> findByOrganisationId(@Param("organisationId") int organisationId);
}
