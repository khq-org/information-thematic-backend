package com.example.informationthematicbackend.model.dto.common;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "set")
public class GradeDTO implements Serializable {
    private Long gradeId;
    private String grade;
}
