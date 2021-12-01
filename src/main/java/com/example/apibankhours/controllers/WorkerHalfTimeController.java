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
@RequestMapping("/api/v1/workers/halftime")
public class WorkerHalfTimeController {

    @Autowired
    private WorkerHalfTimeRepository repository;

    @PostMapping("/")
    public ResponseEntity<String> save(@RequestBody WorkerHalfTimeModel worker) {
        repository.save((worker));
        return new ResponseEntity<>("User sucessfully registered.", HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<WorkerHalfTimeModel>> index() {
        List<WorkerHalfTimeModel> listWorkers = repository.findAll();
        return new ResponseEntity<>(listWorkers, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<WorkerHalfTimeModel>> get(@PathVariable String id) {
        Optional<WorkerHalfTimeModel> worker = repository.findById(id);
        if (worker.isEmpty()) {
            return new ResponseEntity<>(worker, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(worker, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        Optional<WorkerHalfTimeModel> worker = repository.findById(id);
        if (worker.isEmpty()) {
            return new ResponseEntity<>("Worker not found.", HttpStatus.BAD_REQUEST);
        } else {
            repository.deleteById(id);
            return new ResponseEntity<>("User sucessfully deleted.", HttpStatus.OK);
        }
    }
}
