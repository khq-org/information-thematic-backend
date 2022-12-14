package com.example.informationthematicbackend.model.dto.common;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SemesterDTO implements Serializable {
    private Long semesterId;
    private String semester;
}
