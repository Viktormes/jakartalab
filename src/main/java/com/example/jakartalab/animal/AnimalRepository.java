package com.example.jakartalab.animal;

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

    public void addAnimal(Animal animal){
        entityManager.persist(animal);

    }
    public void removeAnimal(Long id){
        var animal = findOne(id);
        animal.ifPresent((a)-> entityManager.remove(a));

    }

    public List<Animal> findAllByName(String name) {
        var query = entityManager.createQuery("select a from Animal a where a.name like :name");
        query.setParameter("Name", name);
        return(List<Animal>) query.getResultList();
    }
    public Animal update(Long id, Animal animal){
        var entity = entityManager.find(Animal.class, id);
        entity.setSpecies(animal.getSpecies());
        entity.setName(animal.getName());
        entity.setColor(animal.getColor());
        return entity;


    }
}
