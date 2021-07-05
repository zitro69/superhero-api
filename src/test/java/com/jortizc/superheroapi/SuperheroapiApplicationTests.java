package com.jortizc.superheroapi;

import com.jortizc.superheroapi.model.Superhero;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.util.UriComponentsBuilder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SuperheroapiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SuperheroapiApplicationTests {
    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:"+port;
    }

    @Test
    public void contextLoads(){}

    @Test
    public void testGetAllSuperheroes() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.
                exchange(getRootUrl() + "/superhero",
                        HttpMethod.GET,
                        entity,
                        String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testCreateSuperhero() {
        Superhero superhero = new Superhero("Ironman");
        ResponseEntity<Superhero> response = restTemplate.
                postForEntity(getRootUrl() + "/superhero",
                        superhero,
                        Superhero.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
    }

    @Test
    public void testSearchSuperhero() {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(getRootUrl() + "/superhero/search")
                .queryParam("name", "man");
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);


        ResponseEntity<String> response = restTemplate
                .exchange(
                        builder.build().encode().toUri(),
                        HttpMethod.GET,
                        entity,
                        String.class
                );
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetSuperheroesById() {
        int id = 1;
        Superhero superhero = restTemplate.getForObject(getRootUrl() + "/superhero/" + id, Superhero.class);
        System.out.println(superhero.getName());
        assertNotNull(superhero);
    }

    @Test
    public void testUpdateSuperhero() {
        int id = 1;
        Superhero superhero = restTemplate.getForObject(getRootUrl() + "/superhero/" + id, Superhero.class);
        superhero.setName("Ironman");
        restTemplate.put(getRootUrl() + "/superhero/" + id, superhero);
        Superhero updateSuperhero = restTemplate.getForObject(getRootUrl() + "/superhero/" + id, Superhero.class);
        assertNotNull(updateSuperhero);
    }

    @Test
    public void testDeleteSuperhero() {
        int id = 1;
        Superhero superhero = restTemplate.getForObject(getRootUrl() + "/superhero/" + id, Superhero.class);
        assertNotNull(superhero);
        restTemplate.delete(getRootUrl() + "/superhero/" + id);
        try {
            superhero = restTemplate.getForObject(getRootUrl() + "/superhero/" + id, Superhero.class);
        } catch (HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}

