package com.Sakila.api.SakilaApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("/Home")
@CrossOrigin
public class SakilaAppApplication {

	@Autowired
	private ActorRepository actorRepository;

	public SakilaAppApplication(ActorRepository actorRepository) {
		this.actorRepository = actorRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SakilaAppApplication.class, args);
	}

	@GetMapping("/actors")
	@ResponseBody
	public Iterable<Actor> getAllActors() {
		return actorRepository.findAll();
	}

	@GetMapping("actors/{id}")
	@ResponseBody
	public Optional<Actor> getActor(@PathVariable Integer id) {
		return actorRepository.findById(id);
	}

	@PostMapping("actors/add")
	@ResponseBody
	public String addActor(@RequestParam String firstName, @RequestParam String lastName) {
		final Actor actor = new Actor(firstName, lastName);
		actorRepository.save(actor);
		return "actor successfully added";
	}
}
