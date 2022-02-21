package com.softtech.bootcamp.case2.repository;

import com.softtech.bootcamp.case2.model.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long> {

    @Query(value = "SELECT * FROM DISTRICT d INNER JOIN CITY c ON (d.CITY_ID = c.ID AND c.name = ?1) ", nativeQuery = true)
    List<District> findAllByCityName(String cityName);

    @Modifying
    @Query(value = "DELETE FROM DISTRICT d WHERE d.ID in ?1", nativeQuery = true)
    void deleteAll(@Param("idList") List<Long> idList);
}
