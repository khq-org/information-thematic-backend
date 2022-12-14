package com.example.informationthematicbackend.request.user;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "set")
public class UpdateUserRequest {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String street;
    private String district;
    private String city;
    private String dateOfBirth;
    private String placeOfBirth;
    private String nationality;
    private Boolean gender;
    private Long roleId;
    // for teacher
    private String workingPosition;
    private Long subjectId;
}
