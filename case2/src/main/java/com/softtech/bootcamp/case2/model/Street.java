package com.softtech.bootcamp.case2.model;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;

@Entity
@Table(name = "STREET")
@Data
public class Street {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", length = 21)
    private String name;

    @Column(name = "NEIGHBORHOOD_ID")
    private Long neighborhoodId;
}
