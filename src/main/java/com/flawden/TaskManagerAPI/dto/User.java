package com.flawden.TaskManagerAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private Integer id;
    private String email;
    private String firstName;
    private String lastName;
    private String role;
}
