package com.example.trainer.db;

import com.example.trainer.model.Trainer;
import com.sun.tracing.dtrace.ArgsAttributes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Database {
    private static Database database;
    private List<Trainer> trainers = new ArrayList<>();

    public static Database getDatabase(){
        if(database == null){
            database = new Database();
        }
        return database;
    }

}
