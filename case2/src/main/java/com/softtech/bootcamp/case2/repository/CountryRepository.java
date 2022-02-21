package com.softtech.bootcamp.case2.repository;

import com.softtech.bootcamp.case2.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    boolean existsByCode(String code);

    Optional<Country> findByCode(String code);

    @Modifying
    @Query(value = "DELETE FROM COUNTRY c WHERE c.ID in ?1", nativeQuery = true)
    void deleteAll(@Param("idList") List<Long> idList);
}
