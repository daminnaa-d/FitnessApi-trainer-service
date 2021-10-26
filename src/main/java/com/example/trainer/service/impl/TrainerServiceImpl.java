package com.example.trainer.service.impl;

import com.example.trainer.model.Trainer;
import com.example.trainer.repository.TrainerRepository;
import com.example.trainer.service.TrainerService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerServiceImpl implements TrainerService {
    @Autowired
    private TrainerRepository trainerRepository;

    @Override
    @HystrixCommand(
            fallbackMethod = "getAllTrainersFallback",
            threadPoolKey = "getAllTrainers",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
            })
    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    public List<Trainer> getAllTrainersFallback() {
        return null;
    }

    @Override
    @HystrixCommand(
            fallbackMethod = "getTrainerByIdFallback",
            threadPoolKey = "getTrainerById",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
            })
    public Optional<Trainer> getTrainerById(int id) {
        return trainerRepository.findAll().stream().filter(user -> user.getId() == id).findFirst();
    }

    public Trainer getTrainerByIdFallback(int id) {
        Trainer trainer = new Trainer();
        trainer.setId(0);
        trainer.setFullName("Name is not available: Service unavailable!");
        trainer.setPhoneNumber("Phone number is not available: Service unavailable!");
        trainer.setSpecialization("Specialization is not available: Service unavailable!");
        return trainer;
    }
    @Override
    @HystrixCommand(
            fallbackMethod = "addTrainerFallback",
            threadPoolKey = "addTrainer",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
            })
    public void addTrainer(Trainer trainer) {
        trainerRepository.save(trainer);
    }

    public void addTrainerFallback(Trainer trainer) {
        System.out.println("Cannot add trainer: Service unavailable!");
    }
}
