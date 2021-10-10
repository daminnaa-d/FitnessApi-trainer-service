package com.example.trainer.service.impl;

import com.example.trainer.db.Database;
import com.example.trainer.model.Trainer;
import com.example.trainer.repository.TrainerRepository;
import com.example.trainer.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {
    @Autowired
    private TrainerRepository trainerRepository;

    @Override
    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    @Override
    public Trainer getTrainerById(int id) {
        return trainerRepository.getById(id);
    }


    @Override
    public void addTrainer(Trainer trainer) {
        trainerRepository.save(trainer);
    }
}
