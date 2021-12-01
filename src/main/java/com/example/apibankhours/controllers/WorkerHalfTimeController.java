package com.example.apibankhours.controllers;

import com.example.apibankhours.models.WorkerHalfTimeModel;
import com.example.apibankhours.repositories.WorkerHalfTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class WorkerHalfTimeController {

    @Autowired
    private WorkerHalfTimeRepository repository;

    @PostMapping("/workers/halftime")
    public ResponseEntity<String> save(@RequestBody WorkerHalfTimeModel worker) {
        repository.save((worker));
        return new ResponseEntity<>("User sucessfully registered.", HttpStatus.OK);
    }

    @GetMapping("/worker/halftime")
    public ResponseEntity<List<WorkerHalfTimeModel>> index() {
        List<WorkerHalfTimeModel> listWorkers = repository.findAll();
        return new ResponseEntity<>(listWorkers, HttpStatus.OK);
    }


    @GetMapping("/api/v1/worker/halftime/{id}")
    public ResponseEntity<String> get(@PathVariable UUID worker_id) {
        Optional<WorkerHalfTimeModel> worker = repository.findById(worker_id);
        if (worker.isEmpty()) {
            return new ResponseEntity<>("Worker not found.", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>("User sucessfully registered.", HttpStatus.OK);
        }
    }

    @DeleteMapping("/api/v1/worker/halftime/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID worker_id) {
        Optional<WorkerHalfTimeModel> worker = repository.findById(worker_id);
        if (worker.isEmpty()) {
            return new ResponseEntity<>("Worker not found.", HttpStatus.BAD_REQUEST);
        } else {
            repository.deleteById(worker_id);
            return new ResponseEntity<>("User sucessfully deleted.", HttpStatus.OK);
        }
    }
}
