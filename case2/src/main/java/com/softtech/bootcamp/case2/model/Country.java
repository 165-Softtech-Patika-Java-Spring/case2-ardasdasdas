package com.softtech.bootcamp.case2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "COUNTRY", uniqueConstraints = {@UniqueConstraint(name = "UK_COUNTRY_CODE", columnNames = {"CODE"})})
@Data
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CODE", length = 9)
    private String code;

    @Column(name = "NAME", length = 21)
    private String name;

}
