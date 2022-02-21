package com.softtech.bootcamp.case2.converter;

import com.softtech.bootcamp.case2.dto.StreetDTO;
import com.softtech.bootcamp.case2.model.Street;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface StreetMapper {

    StreetMapper INSTANCE = Mappers.getMapper(StreetMapper.class);

    Street toStreet(StreetDTO neighborhoodDTO);

    StreetDTO fromStreet(Street neighborhood);

    List<Street> toStreetList(List<StreetDTO> neighborhoodTOList);

    List<StreetDTO> fromStreetList(List<Street> neighborhoodList);
}
