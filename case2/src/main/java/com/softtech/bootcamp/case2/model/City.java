package com.softtech.bootcamp.case2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CITY", uniqueConstraints = {@UniqueConstraint(name = "UK_CITY_PLATE_NO", columnNames = {"PLATE_NO"})})
@Data
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", length = 21)
    private String name;

    @Column(name = "PLATE_NO", length = 21)
    private String plateNo;

    @Column(name = "COUNTRY_ID")
    private Long countryId;

}
