package com.flawden.TaskManagerAPI.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Register {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String role;
}
