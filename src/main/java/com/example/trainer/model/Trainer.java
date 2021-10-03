package com.example.trainer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trainer {
    private int id;
    private String fullName;
    private String phoneNumber;
    private String specialization;

}
