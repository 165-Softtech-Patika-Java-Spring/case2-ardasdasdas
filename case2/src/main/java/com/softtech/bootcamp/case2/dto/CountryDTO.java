package com.softtech.bootcamp.case2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CountryDTO {

    private Long id;
    private String code;
    private String name;
}
