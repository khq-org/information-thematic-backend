package com.example.informationthematicbackend.model.dto.common;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {
    private Long userId;
    private String username;
    private String password;
    private String lastName;
    private String firstName;
    private String displayName;
    private String phone;
    private String email;
    private String avatar;
    private Boolean gender;
    private String dateOfBirth;
    private String placeOfBirth;
    private String nationality;
    private String street;
    private String district;
    private String city;
    private String job;
    private String recruitmentDay;
    private String workingPosition;
    private String teachSubject;
    private String role;
    private Long schoolId;
    private String schoolName;
    private String studentId; // only student
    private String teacherId; // only teacher
}
