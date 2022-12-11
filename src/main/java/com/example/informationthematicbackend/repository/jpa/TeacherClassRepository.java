package com.example.informationthematicbackend.repository.jpa;

import com.example.informationthematicbackend.model.entity.TeacherClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherClassRepository extends JpaRepository<TeacherClassEntity, Long> {
    @Query("SELECT tc FROM TeacherClassEntity tc" +
            " LEFT JOIN FETCH tc.clazz c" +
            " LEFT JOIN FETCH tc.schoolYear sy" +
            " LEFT JOIN FETCH tc.semester s" +
            " WHERE tc.teacher.userId = :teacherId")
    List<TeacherClassEntity> findByTeacher(@Param("teacherId") Long teacherId);

//    @Query("SELECT tc FROM TeacherClassEntity tc" +
//            " LEFT JOIN FETCH tc.schoolYear" +
//            " WHERE tc.clazz.classId = :classId" +
//            " AND tc.teacher.teacherId = :teacherId")
//    TeacherClassEntity findByTeacherAndClass(@Param("teacherId") Long teacherId, @Param("classId") Long classId);
}