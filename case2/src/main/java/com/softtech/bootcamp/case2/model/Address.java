package com.softtech.bootcamp.case2.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "COUNTRY_ID")
    private Long countryId;

    @Column(name = "CITY_ID")
    private Long cityId;

    @Column(name = "DISTRICT_ID")
    private Long districtId;

    @Column(name = "NEIGHBORHOOD_ID")
    private Long neighborhoodId;

    @Column(name = "STREET_ID")
    private Long streetId;

    @Column(name = "DOOR_NO", length = 9)
    private String doorNo;

    @Column(name = "APARTMENT_NO", length = 9)
    private String apartmentNo;
}
