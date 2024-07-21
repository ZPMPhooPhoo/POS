package com.lumina.pos.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class User {
    private String employeeId;
    private String name;
    private String fatherName;
    private String email;
    private String password;
    private String phone;
    private String nrc;
    private String gender;
    private String dob;
    private Integer age;
    private Address address;
    private String role;
    private LocalDate createdDate = LocalDate.now();
    private Integer updatedStatus;
    private boolean delFlag;
}
