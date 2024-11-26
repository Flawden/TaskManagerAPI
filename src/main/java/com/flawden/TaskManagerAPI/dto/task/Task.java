package com.flawden.TaskManagerAPI.dto.task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    private String title;
    private String description;
    private String status;
    private String priority;

}
