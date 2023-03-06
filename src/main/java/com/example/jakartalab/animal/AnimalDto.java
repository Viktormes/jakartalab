package com.example.jakartalab.animal;

public class AnimalDto {
    private Long id;

    String species;

    String name;

    String color;

    public AnimalDto(){

    }
    public AnimalDto(Animal animal){
        this.id = animal.getId();
        this.species = animal.getSpecies();
        this.name = animal.getName();
        this.color = animal.getColor();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

