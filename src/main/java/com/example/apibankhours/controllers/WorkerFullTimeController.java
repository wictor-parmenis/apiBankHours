package com.example.apibankhours.controllers;

import com.example.apibankhours.Exception.ApiExceptionError;
import com.example.apibankhours.Exception.ApiRequestError;
import com.example.apibankhours.models.Response;
import com.example.apibankhours.models.WorkerFullTimeModel;
import com.example.apibankhours.models.WorkerHalfTimeModel;
import com.example.apibankhours.repositories.WorkerFullTimeRepository;
import com.example.apibankhours.repositories.WorkerHalfTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/worker/fulltime")
public class WorkerFullTimeController {

    @Autowired
    private WorkerFullTimeRepository repository;

    @PostMapping("/")
    public ResponseEntity<Response> save(@RequestBody WorkerFullTimeModel worker) {
        repository.save(worker);
        return new ResponseEntity<>(new Response("User sucessfully created.", true, 201), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<WorkerFullTimeModel>> index() {
        List<WorkerFullTimeModel> listWorkers = repository.findAll();
        return new ResponseEntity<>(listWorkers, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<WorkerFullTimeModel>> get(@PathVariable String id) {
        Optional<WorkerFullTimeModel> worker = repository.findById(id);
        if (worker.isEmpty()) {
            return new ResponseEntity<>(worker, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(worker, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable String id) {
        Optional<WorkerFullTimeModel> worker = repository.findById(id);
        if (worker.isEmpty()) {
            return new ResponseEntity<>(new Response("User not found.", true, 400), HttpStatus.BAD_REQUEST);
        } else {
            repository.deleteById(id);
            return new ResponseEntity<>(new Response("User sucessfully deleted.", true, 201), HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> update(@PathVariable String id, @RequestBody WorkerFullTimeModel workerRequest) {

        Optional<WorkerFullTimeModel> workerExist = repository.findById(id);

        if (workerExist.isEmpty()) {
            return new ResponseEntity<>(new Response("User not found.", true, 400), HttpStatus.BAD_REQUEST);
        }

        WorkerFullTimeModel currentWorker = workerExist.get();
        if (workerRequest.getEmail().length() > 0) {
            currentWorker.setEmail(workerRequest.getEmail());
        }
        if (workerRequest.getExtraHoursWorked() != currentWorker.getExtraHoursWorked()) {
            currentWorker.setExtraHoursWorked(workerRequest.getExtraHoursWorked());
        }
        if (workerRequest.getCpf().length() > 0) {
            currentWorker.setCpf(workerRequest.getCpf());
        }
        if (workerRequest.getLevel().length() > 0) {
            currentWorker.setLevel(workerRequest.getLevel());
        }
        if (workerRequest.getJobName().length() > 0) {
            currentWorker.setJobName(workerRequest.getJobName());
        }
        if (workerRequest.getName().length() > 0) {
            currentWorker.setName(workerRequest.getName());
        }
        if (workerRequest.getTotalHoursWorked() !=  currentWorker.getTotalHoursWorked()) {
            currentWorker.setTotalHoursWorked(workerRequest.getTotalHoursWorked());
        }

        repository.save(currentWorker);
        return new ResponseEntity<>(new Response("User sucessfully updated.", true, 201), HttpStatus.OK);
    }
}

