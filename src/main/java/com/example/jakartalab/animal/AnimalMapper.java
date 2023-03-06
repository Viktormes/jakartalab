package com.example.jakartalab.animal;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class AnimalMapper {

    public List<AnimalDto> map(List<Animal> all){
        return all.stream().map(AnimalDto::new).toList();
    }
    public Animal map(AnimalDto animal){
        var a = new Animal();
        a.setId(animal.getId());
        a.setSpecies(animal.getSpecies());
        a.setName(animal.getName());
        a.setColor(animal.getColor());

        return a;
    }
    public AnimalDto map (Animal animal) {
        return new AnimalDto(animal);
    }
}
