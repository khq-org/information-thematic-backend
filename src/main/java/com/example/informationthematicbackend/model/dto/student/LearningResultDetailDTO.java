package com.example.informationthematicbackend.model.dto.student;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder(setterPrefix = "set")
public class LearningResultDetailDTO implements Serializable {
    private LearningResultDTO learningResult;
    private List<StudyScore> studyScores;
    private Double avgScore;

    @Getter
    @Setter
    @Builder(setterPrefix = "set")
    public static class StudyScore {
        private Subject subject;
        private List<SemesterScore> semesterScores;
        private Double avgScore;

        @Getter
        @Setter
        @Builder(setterPrefix = "set")
        public static class Subject {
            private Long subjectId;
            private String subjectName;
        }

        @Getter
        @Setter
        @Builder(setterPrefix = "set")
        public static class SemesterScore {
            private String semester;
            private List<Score> scores;
            private Double avgScore;

            @Getter
            @Setter
            @Builder(setterPrefix = "set")
            public static class Score {
                private Double score;
                private String type;
            }
        }
    }
}
