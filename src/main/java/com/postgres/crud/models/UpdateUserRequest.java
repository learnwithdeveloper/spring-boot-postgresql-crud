package com.postgres.crud.models;

import lombok.Data;

@Data
public class UpdateUserRequest {

    private String name;
    private String email;
}
