package com.example.apibankhours.repositories;

import com.example.apibankhours.models.WorkerFullTimeModel;
import com.example.apibankhours.models.WorkerHalfTimeModel;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.UUID;

public interface WorkerHalfTimeRepository extends MongoRepository<WorkerHalfTimeModel, String> {
    @Query(value="{'email' : ?0}")
    List<WorkerHalfTimeModel> findByEmail(String email);
}
