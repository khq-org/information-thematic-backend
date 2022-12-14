package com.example.informationthematicbackend.request.user;

import com.example.informationthematicbackend.request.PageRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListSchoolAdminRequest extends PageRequest {
    private String firstName;
    private String lastName;
    private String email;
    private Long schoolId;
    private String search;
}
