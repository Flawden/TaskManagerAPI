package com.flawden.TaskManagerAPI.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateUser {
    private String firstName;
    private String lastName;
}
