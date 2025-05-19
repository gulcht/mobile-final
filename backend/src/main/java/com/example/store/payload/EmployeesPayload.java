package com.example.store.payload;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeesPayload {
    private String firstName;
    private String lastName;
    private String user;
    private String password;
    private LocalDateTime createdAt;
}
