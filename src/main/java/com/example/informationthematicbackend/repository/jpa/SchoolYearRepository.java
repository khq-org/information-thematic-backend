package com.example.informationthematicbackend.repository.jpa;

import com.example.informationthematicbackend.model.entity.SchoolYearEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SchoolYearRepository extends JpaRepository<SchoolYearEntity, Long> {
    @Query("SELECT sy FROM SchoolYearEntity sy" +
            " WHERE sy.schoolYear = :schoolYearName" +
            " AND :schoolYearId IS NULL OR (:schoolYearId IS NOT NULL AND sy.schoolYearId <> :schoolYearId)")
    List<SchoolYearEntity> findBySchoolYear(@Param("schoolYearId") Long schoolYearId, @Param("schoolYearName") String schoolYearName);

    @Query("SELECT sy FROM SchoolYearEntity sy" +
            " WHERE sy.schoolYear = :schoolYearName")
    Optional<SchoolYearEntity> findByName(@Param("schoolYearName") String schoolYearName);
}