package com.Sakila.api.SakilaApp.Actor;

import com.Sakila.api.SakilaApp.Exceptions.ResourceNotFoundException;
import com.Sakila.api.SakilaApp.Film.Film;
import com.Sakila.api.SakilaApp.Film.FilmRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ActorService {
    private ActorRepository actorRepository;

    public Actor saveActor(Actor actor) {
        return actorRepository.save(actor);
    }

    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    public Actor getActorById(Integer id) {
        return actorRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Actor", "Id", id));
    }

    public Actor updateActor(Actor actor, Integer id) {
        Actor existingActor = actorRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Actor",
                "Id", id));
        existingActor.setFirstName(actor.getFirstName());
        existingActor.setLastName(actor.getLastName());
        actorRepository.save(existingActor);
        return existingActor;
    }

    public void deleteActor(Integer id) {
        actorRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Actor", "Id", id));
        actorRepository.deleteById(id);
    }
}
