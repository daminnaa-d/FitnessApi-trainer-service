package com.example.trainer.service;

import com.example.trainer.model.Trainer;

import java.util.List;
import java.util.Optional;

public interface TrainerService {
    List<Trainer> getAllTrainers();
    Optional<Trainer> getTrainerById(int id);
    void addTrainer(Trainer trainer);

}
