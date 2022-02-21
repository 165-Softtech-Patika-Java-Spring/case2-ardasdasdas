package com.softtech.bootcamp.case2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StreetDTO {

    private Long id;
    private String name;
    private Long neighborhoodId;
}
