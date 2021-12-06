package com.example.apibankhours.controllers;

import com.example.apibankhours.exceptions.CustomErrorException;
import com.example.apibankhours.models.Response;
import com.example.apibankhours.models.WorkerFullTimeModel;
import com.example.apibankhours.repositories.WorkerFullTimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/worker/fulltime")
public class WorkerFullTimeController {

    @Autowired
    private WorkerFullTimeRepository repository;

    @PostMapping("/")
    public ResponseEntity<Response> save(@RequestBody WorkerFullTimeModel worker) {
        List<WorkerFullTimeModel> userExist = repository.findByEmail(worker.getEmail());
        System.out.println(userExist);
        if (!userExist.isEmpty()) {
            throw new CustomErrorException(
                    HttpStatus.BAD_REQUEST,
                    "User already exist."
            );
        }

        repository.save(worker);
        return new ResponseEntity<>(new Response("User successfully created.", true, 201), HttpStatus.OK);
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
            throw new NullPointerException("User not found");
        } else {
             return new ResponseEntity<>(worker, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable String id) {
        Optional<WorkerFullTimeModel> worker = repository.findById(id);
        if (worker.isEmpty()) {
            throw new NullPointerException("User not found");
        } else {
            repository.deleteById(id);
            return new ResponseEntity<>(new Response("User successfully deleted.", true, 201), HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> update(@PathVariable String id, @RequestBody WorkerFullTimeModel workerRequest) {

        Optional<WorkerFullTimeModel> workerExist = repository.findById(id);

        if (workerExist.isEmpty()) {
            throw new NullPointerException("User not found");
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
        return new ResponseEntity<>(new Response("User successfully updated.", true, 201), HttpStatus.OK);
    }
}

