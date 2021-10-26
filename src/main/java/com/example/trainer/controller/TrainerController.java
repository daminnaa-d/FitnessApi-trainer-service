package com.example.trainer.controller;

import com.example.trainer.model.Trainer;
import com.example.trainer.service.TrainerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainers")
@Api(value = "Trainer Controller class", description = "This class allows to interact with Trainer object")
public class TrainerController {
    @Autowired
    private TrainerService trainerService;

    @GetMapping("")
    @ApiOperation(value = "Method to get list of trainers", response = List.class)
    public ResponseEntity<?> getAllTrainers(){
        return ResponseEntity.ok(trainerService.getAllTrainers());
    }

    @GetMapping("{id}")
    @ApiOperation(value = "Method to get a trainer by ID", response = List.class)
    public ResponseEntity<?> getTrainerById(@PathVariable int id){
        return ResponseEntity.ok(trainerService.getTrainerById(id));
    }

    @PostMapping("")
    @ApiOperation(value = "Method to add a new trainer", response = List.class)
    public void addTrainer (@RequestBody Trainer trainer){
        trainerService.addTrainer(trainer);
    }

}
