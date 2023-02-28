package com.example.jakartalab.animal;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AnimalValidator {
    public boolean validate(Animal animal){

        return animal.getName() != null && !animal.getName().isEmpty();

    }
}
