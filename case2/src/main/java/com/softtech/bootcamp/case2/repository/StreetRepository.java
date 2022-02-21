package com.softtech.bootcamp.case2.repository;

import com.softtech.bootcamp.case2.model.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StreetRepository extends JpaRepository<Street, Long> {

    @Query(value = "SELECT * FROM STREET s INNER JOIN NEIGBORHOOD n ON (s.NEIGBORHOOD_ID = n.ID AND n.name = ?1) ", nativeQuery = true)
    List<Street> findAllByNeighborhoodName(String neighborhoodName);

    @Modifying
    @Query(value = "DELETE FROM STREET s WHERE s.ID in ?1", nativeQuery = true)
    void deleteAll(@Param("idList") List<Long> idList);
}
