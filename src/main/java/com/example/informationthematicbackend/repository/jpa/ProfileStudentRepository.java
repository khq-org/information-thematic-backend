package com.example.informationthematicbackend.repository.jpa;

import com.example.informationthematicbackend.model.entity.ProfileStudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfileStudentRepository extends JpaRepository<ProfileStudentEntity, Long> {
    @Query("SELECT ps FROM ProfileStudentEntity ps" +
            " LEFT JOIN FETCH ps.student s" +
            " WHERE s.userId = :studentId")
    Optional<ProfileStudentEntity> findByStudent(@Param("studentId") Long studentId);

    @Query("SELECT ps FROM ProfileStudentEntity ps" +
            " LEFT JOIN FETCH ps.student" +
            " WHERE ps.student.userId IN (:studentIds)")
    List<ProfileStudentEntity> findByStudentIds(@Param("studentIds") List<Long> studentIds);
}