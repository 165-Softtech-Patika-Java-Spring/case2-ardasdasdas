package com.softtech.bootcamp.case2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NeighborhoodDTO {

    private Long id;
    private String name;
    private Long districtId;
}
