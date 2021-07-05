package com.jortizc.superheroapi.controller;

import com.jortizc.superheroapi.model.Superhero;
import com.jortizc.superheroapi.model.repository.SuperheroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
public class SuperheroController {
    private final SuperheroRepository repository;

    public SuperheroController(SuperheroRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/superhero")
    public List<Superhero> getAllSuperhero() {
        return repository.findAll();
    }

    @PostMapping("/superhero")
    public Superhero postNewSuperhero(@RequestBody Superhero newSuperhero) {
        return repository.save(newSuperhero);
    }

    @GetMapping("/superhero/search")
    public List<Superhero> getSuperherosByName (@RequestParam String name) {
        return repository.findByNameLike(name.toUpperCase(Locale.ROOT));
    }

    @GetMapping("/superhero/{id}")
    public Optional getSuperheroById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PutMapping("/superhero/{id}")
    public Optional updateSuperhero(@RequestBody Superhero updatedSuperhero, @PathVariable Long id) {
        return repository.findById(id)
                .map(superhero -> {
                    superhero.setName(updatedSuperhero.getName());
                    return repository.save(superhero);
                });
    }

    @DeleteMapping ("/superhero/{id}")
    public void deleteSuperhero (@PathVariable Long id) {
        repository.deleteById(id);
    }

}
