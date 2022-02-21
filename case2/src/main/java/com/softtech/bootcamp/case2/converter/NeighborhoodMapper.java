package com.softtech.bootcamp.case2.converter;

import com.softtech.bootcamp.case2.dto.NeighborhoodDTO;
import com.softtech.bootcamp.case2.model.Neighborhood;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface NeighborhoodMapper {

    NeighborhoodMapper INSTANCE = Mappers.getMapper(NeighborhoodMapper.class);

    Neighborhood toNeighborhood(NeighborhoodDTO neighborhoodDTO);

    NeighborhoodDTO fromNeighborhood(Neighborhood neighborhood);

    List<Neighborhood> toNeighborhoodList(List<NeighborhoodDTO> neighborhoodTOList);

    List<NeighborhoodDTO> fromNeighborhoodList(List<Neighborhood> neighborhoodList);
}
