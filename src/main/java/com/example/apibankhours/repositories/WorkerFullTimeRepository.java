package com.example.apibankhours.repositories;

import com.example.apibankhours.models.WorkerFullTimeModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WorkerFullTimeRepository extends MongoRepository<WorkerFullTimeModel, String> {
}
