package com.example.apibankhours.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@ToString
@Setter
@Getter
@Document(collection = "WorkerHalfTime")
public class WorkerHalfTimeModel {
    @Id
    private UUID id;

    private String name;
    private String cpf;
    private String jobName;
    private String email;
    private float extraHoursWorked;
    private float totalHoursWorked;
    private String level;
}
