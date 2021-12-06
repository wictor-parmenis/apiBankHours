package com.example.apibankhours.repositories;

import com.example.apibankhours.models.WorkerFullTimeModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface WorkerFullTimeRepository extends MongoRepository<WorkerFullTimeModel, String> {
    @Query(value="{'email' : ?0}")
    List<WorkerFullTimeModel> findByEmail(String email);
}
