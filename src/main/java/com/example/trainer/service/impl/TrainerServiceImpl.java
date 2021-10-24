package com.example.trainer.service.impl;

import com.example.trainer.model.Trainer;
import com.example.trainer.repository.TrainerRepository;
import com.example.trainer.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerServiceImpl implements TrainerService {
    @Autowired
    private TrainerRepository trainerRepository;

    @Override
    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    @Override
    public Optional<Trainer> getTrainerById(int id) {
        return trainerRepository.findAll().stream().filter(user -> user.getId() == id).findFirst();

    }

    @Override
    public void addTrainer(Trainer trainer) {
        trainerRepository.save(trainer);
    }
}
