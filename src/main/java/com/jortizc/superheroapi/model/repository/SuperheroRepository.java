package com.jortizc.superheroapi.model.repository;

import com.jortizc.superheroapi.model.Superhero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuperheroRepository extends JpaRepository<Superhero, Long> {
}
