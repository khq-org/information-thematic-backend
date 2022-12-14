package com.example.informationthematicbackend.request.student;

import com.example.informationthematicbackend.request.PageRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListStudentRequest extends PageRequest {
    private String firstName;
    private String lastName;
    private String district;
    private String city;
    private Long classId;
    private Long gradeId;
    private Long schoolYearId;
    private String search;
}
