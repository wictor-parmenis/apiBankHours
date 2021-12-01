package com.example.apibankhours.repositories;

import com.example.apibankhours.models.WorkerHalfTimeModel;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface WorkerHalfTimeRepository extends MongoRepository<WorkerHalfTimeModel, String> {


}
