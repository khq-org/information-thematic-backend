package com.example.informationthematicbackend.request.clazz;

import com.example.informationthematicbackend.request.PageRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListClassRequest extends PageRequest {
    private String clazzName;
    private Long schoolYearId;
    private Long gradeId;
    private Long schoolId;
}
