package com.example.trainer.service.impl;

import com.example.trainer.db.Database;
import com.example.trainer.model.Trainer;
import com.example.trainer.service.TrainerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {

    @Override
    public List<Trainer> getAllTrainers() {
        return Database.getDatabase().getTrainers();
    }

    @Override
    public Trainer getTrainerById(int id) {
        for (Trainer trainer:Database.getDatabase().getTrainers()) {
            if(trainer.getId() == id){
                return trainer;
            }
        }
        return null;
    }

    @Override
    public void selectTrainer() {
        List<Trainer> trainers = Database.getDatabase().getTrainers();

    }
}
