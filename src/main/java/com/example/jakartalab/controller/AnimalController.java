package com.example.jakartalab.controller;

import com.example.jakartalab.mapper.Mapper;
import com.example.jakartalab.repository.AnimalRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;

//@Path("/animals")
public class AnimalController {
    @Inject
    AnimalRepository animalRepository;

    @Inject
    Mapper mapper;


}
