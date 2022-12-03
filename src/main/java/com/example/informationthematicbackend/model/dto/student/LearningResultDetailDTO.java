package com.example.informationthematicbackend.model.dto.student;

import com.example.informationthematicbackend.model.dto.common.SubjectDTO;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "set")
public class LearningResultDetailDTO implements Serializable {
    private LearningResultDTO learningResult;
    private List<StudyScore> studyScores;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder(setterPrefix = "set")
    public static class StudyScore {
        private SubjectDTO subject;
        private List<SemesterDetail> semesters;
        private Double averageScore;

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        @Builder(setterPrefix = "set")
        public static class SemesterDetail {
            private String semester;
            private List<Exam> exams;
            private Double averageScore;

            @Getter
            @Setter
            @NoArgsConstructor
            @AllArgsConstructor
            @Builder(setterPrefix = "set")
            public static class Exam {
                private String exam;
                private List<Double> scores;
            }
        }
    }

}
