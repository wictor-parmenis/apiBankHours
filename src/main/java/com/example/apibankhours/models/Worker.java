package com.example.apibankhours.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
abstract class Worker {
    private String name;
    private String cpf;
    private String jobName;
    private String email;
    private float totalHoursWorked;
    private String level;
}
