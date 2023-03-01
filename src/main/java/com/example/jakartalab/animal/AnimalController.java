package com.example.jakartalab.animal;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;

@Path("/animals")
public class AnimalController {
    @Inject
    AnimalRepository animalRepository;

    @Inject
    Mapper mapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AnimalDto> getAll(@QueryParam("name") String name) {
        if (name == null)
            return mapper.map(animalRepository.findAll());

        return mapper.map(animalRepository.findAllByName(name));
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOne(@PathParam("id") long id) {
        var animal = animalRepository.findOne(id);
        return Response.ok().entity(animal.get()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(@Valid Animal animal){
        animalRepository.addAnimal(animal);
        return Response.created(URI.create("animals/" + animal.getId())).build();
    }
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        animalRepository.removeAnimal(id);
        return Response.ok().build();
    }
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response upDate(@PathParam("id") Long id, AnimalDto animal) {
        return Response.ok().entity(mapper.map(animalRepository.update(id, mapper.map(animal)))).build();
    }

}
