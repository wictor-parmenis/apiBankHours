package com.example.apibankhours.models;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "WorkerFullTime")
public class WorkerFullTimeModel extends Worker {

    @Id
    private String id;
    private float extraHoursWorked;

    @Builder
    public WorkerFullTimeModel(float extraHoursWorked, String name, String cpf, String jobName, String email,float totalHoursWorked, String level) {
        super(name, cpf, jobName, email,totalHoursWorked, level);
        this.setExtraHoursWorked(extraHoursWorked);

    }
}



