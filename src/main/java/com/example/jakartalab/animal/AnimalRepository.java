package com.example.jakartalab.animal;

import com.example.jakartalab.animal.Animal;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Transactional
public class AnimalRepository {

    @PersistenceContext
    EntityManager entityManager;


    List<Animal> findAll(){
        var query = entityManager.createQuery("SELECT a FROM Animal a");
        return (List<Animal>)query.getResultList();

    }

    Optional<Animal> findOne(Long id){
        return Optional.ofNullable(entityManager.find(Animal.class, id));

    }

    public void insertFood(Animal animal){
        entityManager.persist(animal);

    }
    public void deleteFood(Long id){
        var food = findOne(id);
        food.ifPresent((f)-> entityManager.remove(f));

    }
}
