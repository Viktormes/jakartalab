package com.example.jakartalab.animal;

import jakarta.inject.Inject;

//@Path("/animals")
public class AnimalController {
    @Inject
    AnimalRepository animalRepository;

    @Inject
    Mapper mapper;
//

}
