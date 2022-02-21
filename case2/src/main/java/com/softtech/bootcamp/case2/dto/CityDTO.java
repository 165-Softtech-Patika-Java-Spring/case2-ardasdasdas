package com.softtech.bootcamp.case2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CityDTO {

    private Long id;
    private String name;
    private String plateNo;
    private Long countryId;
}
