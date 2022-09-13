package com.Sakila.api.SakilaApp.Actor;

import com.Sakila.api.SakilaApp.Film.Film;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actors")
@AllArgsConstructor
public class ActorController {
    ActorService actorService;

    @PostMapping()
    public ResponseEntity<Actor> saveActor(@RequestBody Actor actor) {
        return new ResponseEntity<Actor>(actorService.saveActor(actor), HttpStatus.CREATED);
    }

    @GetMapping()
    public List<Actor> getAllActors() {
        return actorService.getAllActors();
    }

    @GetMapping("{id}")
    public ResponseEntity<Actor> getActorById(@PathVariable("id") Integer id) {
        return new ResponseEntity<Actor>(actorService.getActorById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Actor> updateActor(@PathVariable("id") Integer id, @RequestBody Actor actor) {
        return new ResponseEntity<Actor>(actorService.updateActor(actor, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteActor(@PathVariable("id") Integer id) {
        actorService.deleteActor(id);
        return new ResponseEntity<String>("Employee deleted successfully", HttpStatus.OK);
    }
}
