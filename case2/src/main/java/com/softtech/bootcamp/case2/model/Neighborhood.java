package com.softtech.bootcamp.case2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "NEIGHBORHOOD")
@Data
public class Neighborhood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", length = 21)
    private String name;

    @Column(name = "DISTRICT_ID")
    private Long districtId;

}
