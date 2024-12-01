package com.flawden.TaskManagerAPI.dto.task;

import com.flawden.TaskManagerAPI.dto.Comment;
import com.flawden.TaskManagerAPI.dto.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    private Long id;
    private String title;
    private String description;
    private String status;
    private String priority;
    private List<User> executors;
    private List<Comment> commentEntities;

}
