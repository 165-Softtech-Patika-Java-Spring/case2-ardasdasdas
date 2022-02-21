package com.softtech.bootcamp.case2.converter;

import com.softtech.bootcamp.case2.dto.CountryDTO;
import com.softtech.bootcamp.case2.model.Country;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CountryMapper {

    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    Country toCountry(CountryDTO countryDTO);

    CountryDTO fromCountry(Country country);

    List<Country> toCountryList(List<CountryDTO> countryDTOList);

    List<CountryDTO> fromCountryList(List<Country> countryList);
}
