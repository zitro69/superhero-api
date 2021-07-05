package com.jortizc.superheroapi.model.repository;

import com.jortizc.superheroapi.model.Superhero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SuperheroRepository extends JpaRepository<Superhero, Long> {

    @Query("SELECT s FROM Superhero s WHERE UPPER(s.name) LIKE %:name%")
    List<Superhero> findByNameLike(String name);
}
