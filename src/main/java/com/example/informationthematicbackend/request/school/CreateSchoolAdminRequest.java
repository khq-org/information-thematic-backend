package com.example.informationthematicbackend.request.school;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateSchoolAdminRequest {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private Long schoolId;
}
