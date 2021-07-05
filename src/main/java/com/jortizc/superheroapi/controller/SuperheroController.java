package com.jortizc.superheroapi.controller;

import com.jortizc.superheroapi.exception.ResourceNotFoundException;
import com.jortizc.superheroapi.model.Superhero;
import com.jortizc.superheroapi.model.repository.SuperheroRepository;
import com.jortizc.superheroapi.utils.annotations.LogExecutionTime;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
public class SuperheroController {
    private final SuperheroRepository repository;

    public SuperheroController(SuperheroRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/superhero")
    @LogExecutionTime
    public List<Superhero> getAllSuperhero() {
        return repository.findAll();
    }

    @PostMapping("/superhero")
    @LogExecutionTime
    public Superhero postNewSuperhero(@RequestBody Superhero newSuperhero) {
        return repository.save(newSuperhero);
    }

    @GetMapping("/superhero/search")
    @LogExecutionTime
    public List<Superhero> getSuperherosByName (@RequestParam String name) {
        return repository.findByNameLike(name.toUpperCase(Locale.ROOT));
    }

    @GetMapping("/superhero/{id}")
    @LogExecutionTime
    public Superhero getSuperheroById(@PathVariable Long id)
            throws ResourceNotFoundException{
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Superhero not found for this id: " + id));
    }

    @PutMapping("/superhero/{id}")
    @LogExecutionTime
    public Superhero updateSuperhero(@RequestBody Superhero updatedSuperhero, @PathVariable Long id)
            throws ResourceNotFoundException{
        return repository.findById(id)
                .map(superhero -> {
                    superhero.setName(updatedSuperhero.getName());
                    return repository.save(superhero);
                }).orElseThrow(() -> new ResourceNotFoundException("Superhero not found for this id: " + id));
    }

    @DeleteMapping ("/superhero/{id}")
    @LogExecutionTime
    public void deleteSuperhero (@PathVariable Long id) {
        repository.deleteById(id);
    }

}
