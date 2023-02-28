package com.example.jakartalab.dto;

import com.example.jakartalab.entity.Animal;

public class AnimalDto {
    private Long id;

    String race;

    String name;

    String color;

    public AnimalDto(){

    }
    public AnimalDto(Animal animal){
        this.id = animal.getId();
        this.race = animal.getRace();
        this.name = animal.getName();
        this.color = animal.getColor();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
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

