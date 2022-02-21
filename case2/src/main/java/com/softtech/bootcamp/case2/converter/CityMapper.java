package com.softtech.bootcamp.case2.converter;

import com.softtech.bootcamp.case2.dto.CityDTO;
import com.softtech.bootcamp.case2.model.City;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CityMapper {

    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    City toCity(CityDTO cityDTO);

    CityDTO fromCity(City city);

    List<City> toCityList(List<CityDTO> cityDTOList);

    List<CityDTO> fromCityList(List<City> cityList);
}
