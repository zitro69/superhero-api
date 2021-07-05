package com.jortizc.superheroapi.utils;

import com.jortizc.superheroapi.model.Superhero;
import com.jortizc.superheroapi.model.repository.SuperheroRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger LOG = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    public CommandLineRunner initDatabase (SuperheroRepository repository) {
        return args -> {
            LOG.info("Database preloading data: " + repository.save(new Superhero("Superman")).getName());
            LOG.info("Database preloading data: " + repository.save(new Superhero("Spider-man")).getName());
            LOG.info("Database preloading data: " + repository.save(new Superhero("Lobezno")).getName());
            LOG.info("Database preloading data: " + repository.save(new Superhero("Manolito")).getName());
            LOG.info("Database preloading data: " + repository.save(new Superhero("Super López")).getName());
        };
    }
}
