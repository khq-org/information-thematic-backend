package com.example.informationthematicbackend.model.dto.common;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "set")
public class SubjectDTO implements Serializable {
    private Long subjectId;
    private String subject;
    private String code;
    private String description;
}
