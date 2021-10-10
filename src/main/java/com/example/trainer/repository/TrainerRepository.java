package com.example.trainer.repository;

import com.example.trainer.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository <Trainer, Integer> {
}
