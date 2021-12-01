package com.example.apibankhours.models;

import lombok.Builder;
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
public class WorkerHalfTimeModel extends Worker {

    @Id
    private String id;
    private String course;

    @Builder
    public WorkerHalfTimeModel(String course, String name, String cpf, String jobName, String email,float totalHoursWorked, String level) {
        super(name, cpf, jobName, email,totalHoursWorked, level);
        this.setCourse(course);
        this.setId(id);
    }
}
