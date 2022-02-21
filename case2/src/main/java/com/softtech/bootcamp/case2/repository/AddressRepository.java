package com.softtech.bootcamp.case2.repository;

import com.softtech.bootcamp.case2.dto.AddressResultDTO;
import com.softtech.bootcamp.case2.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query(value = "SELECT COUNTRY.NAME as countryName,"
            + " CITY.NAME as cityName,"
            + " DISTRICT.NAME as districtName,"
            + " NEIGHBORHOOD.NAME as neighborhoodName,"
            + " STREET.NAME as streetName,"
            + " ADDRESS.DOOR_NO as doorNo,"
            + " ADDRESS.APARTMENT_NO as apartmentNo"
            + " FROM ADDRESS address"
            + " INNER JOIN COUNTRY country ON (country.ID = address.COUNTRY_ID) "
            + " INNER JOIN CITY city ON (city.ID = address.CITY_ID)"
            + " INNER JOIN DISTRICT district ON (district.ID = address.DISTRICT_ID)"
            + " INNER JOIN NEIGHBORHOOD neighborhood ON (neighborhood.ID = address.NEIGHBORHOOD_ID)"
            + " INNER JOIN STREET street ON (street.ID = address.STREET_ID)"
            + " WHERE address.ID = ?1", nativeQuery = true)
    AddressResultDTO findAddressById(@Param("id") Long id);

    @Modifying
    @Query(value = "DELETE FROM ADDRESS a WHERE a.ID in ?1", nativeQuery = true)
    void deleteAll(@Param("idList") List<Long> idList);
}
