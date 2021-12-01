package com.example.apibankhours.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Response {

    private String message;
    private boolean type;
    private int status;
}
