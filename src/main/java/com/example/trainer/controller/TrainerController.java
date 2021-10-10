package com.example.trainer.controller;

import com.example.trainer.model.Trainer;
import com.example.trainer.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name="/trainers")
public class TrainerController {
    @Autowired
    private TrainerService trainerService;

    @GetMapping("")
    public ResponseEntity<?> getAllTrainers(){
        return ResponseEntity.ok(trainerService.getAllTrainers());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getTrainerById(@PathVariable int id){
        return ResponseEntity.ok(trainerService.getTrainerById(id));
    }

    @PostMapping("")
    public void addTrainer (@RequestBody Trainer trainer){
        trainerService.addTrainer(trainer);
    }
}
