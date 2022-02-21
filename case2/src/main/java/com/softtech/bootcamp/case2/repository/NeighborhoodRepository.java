package com.softtech.bootcamp.case2.repository;

import com.softtech.bootcamp.case2.model.Neighborhood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NeighborhoodRepository extends JpaRepository<Neighborhood, Long> {

    @Query(value = "SELECT * FROM NEIGBORHOOD n INNER JOIN DISTRICT d ON (n.DISTRICT_ID = d.ID AND d.name = ?1) ", nativeQuery = true)
    List<Neighborhood> findAllByDistrictName(String cityName);

    @Modifying
    @Query(value = "DELETE FROM NEIGBORHOOD n WHERE n.ID in ?1", nativeQuery = true)
    void deleteAll(@Param("idList") List<Long> idList);
}
