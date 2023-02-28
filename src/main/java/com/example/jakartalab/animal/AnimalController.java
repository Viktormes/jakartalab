package com.example.jakartalab.animal;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

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

}
