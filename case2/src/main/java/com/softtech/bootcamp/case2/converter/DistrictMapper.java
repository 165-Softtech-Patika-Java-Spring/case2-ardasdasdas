package com.softtech.bootcamp.case2.converter;

import com.softtech.bootcamp.case2.dto.DistrictDTO;
import com.softtech.bootcamp.case2.model.District;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DistrictMapper {

    DistrictMapper INSTANCE = Mappers.getMapper(DistrictMapper.class);

    District toDistrict(DistrictDTO districtDTO);

    DistrictDTO fromDistrict(District district);

    List<District> toDistrictList(List<DistrictDTO> districtDTOList);

    List<DistrictDTO> fromDistrictList(List<District> districtList);
}
