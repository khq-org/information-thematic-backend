package com.example.informationthematicbackend.model.dto.common;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SchoolYearDTO implements Serializable {
    private Long schoolYearId;
    private String schoolYear;
}
