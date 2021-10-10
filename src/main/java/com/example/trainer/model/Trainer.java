package com.example.trainer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="trainers")
public class Trainer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String fullName;
    private String phoneNumber;
    private String specialization;

}
