package com.iiitb.academia.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "organisations")
public class Organisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "organisation_id")
    private int organisationId;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "organisation")
    @JsonManagedReference
    List<OrganisationHR> hrList;

    public Organisation() {}

    public Organisation(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Organisation(int organisationId, String name, String address) {
        this.organisationId = organisationId;
        this.name = name;
        this.address = address;
    }

    public int getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(int organisationId) {
        this.organisationId = organisationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<OrganisationHR> getHrList() {
        return hrList;
    }

    public void setHrList(List<OrganisationHR> hrList) {
        this.hrList = hrList;
    }

    @Override
    public String toString() {
        return "Organisation{" +
                "organisationId=" + organisationId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
