package com.API.Newtech.controller;

import com.API.Newtech.model.Persona;
import com.API.Newtech.service.DirecctionsRepository;
import com.API.Newtech.service.FilmService;
import com.API.Newtech.service.PersonaRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PersonaController{

    @Autowired
    PersonaRepository personaRepository;
    @Autowired
    DirecctionsRepository direcctionsRepository;


    Gson gson = new Gson();
    @GetMapping("/persona")
   public String getAllPersonas(){


        return gson.toJson(ResponseEntity.ok(personaRepository.findAll())) ;
    }

    @PostMapping("/persona")
    public String save(@Validated @RequestBody Persona persona) throws URISyntaxException {
        try {
            Persona createdPersona = personaRepository.save(persona);
            if (createdPersona == null) {
                return gson.toJson(ResponseEntity.notFound().build());
            }

            return gson.toJson(ResponseEntity.ok(createdPersona));

        }catch (Exception ex){
            return gson.toJson(ex.getMessage());
        }

        }


    @PutMapping("/persona/{id}")
    public String update(@RequestBody Persona newPersona , @PathVariable Long id){
        try {
            Optional<Persona> updatePersona = personaRepository.findById(id).map(persona -> {
                persona = newPersona;
                persona.setDirections(newPersona.getDirections());
                return personaRepository.save(persona);
            });

            if (updatePersona == null) {
                return gson.toJson(ResponseEntity.notFound().build());
            }

            return gson.toJson(ResponseEntity.ok(updatePersona));
        }catch (Exception ex){
            return gson.toJson(ex.getMessage());
        }

    }

    @DeleteMapping("/persona/{id}")
    public String delete(@PathVariable Long id){
        try {
            personaRepository.deleteById(id);

            return gson.toJson(ResponseEntity.notFound().build());
        }catch (Exception ex){
            return gson.toJson(ex.getMessage());
        }
    }

    @Autowired
    private FilmService filmService;

    @GetMapping("/external/movies")
    public String getAllFilmsComplete() {
        try {
            return gson.toJson( ResponseEntity.ok(filmService.findAllFilms()));
        }catch (Exception ex){
            return gson.toJson(ex.getMessage());
        }

    }

//
    @GetMapping("/external/movies/title")
    public String getFilmsByTitle(@RequestParam("q") String title) {

        try {
            return gson.toJson(ResponseEntity.ok(filmService.findFilmsByTitle(title))) ;
        }catch (Exception ex){
            return gson.toJson(ex.getMessage());
        }

    }

    }






