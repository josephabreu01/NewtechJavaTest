package com.API.Newtech.controller;

import com.API.Newtech.model.Direcctions;
import com.API.Newtech.model.Film;
import com.API.Newtech.model.Persona;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class PersonaControllerTest {

@Mock
private PersonaController personaController = new PersonaController();

private Persona persona;

private Film film;

Gson gson = new Gson();

    @Test
    void getAllPersonas() throws Exception {

        when(personaController.getAllPersonas()).thenReturn(String.valueOf(ResponseEntity.ok(persona)));
        assertNotNull(personaController.getAllPersonas());



    }

    @Before
    void setUpSave(){
        MockitoAnnotations.initMocks(this);

        Direcctions direcctions = new Direcctions();
        direcctions.setId(2L);
        direcctions.setCity("prueba");
        direcctions.setStreet("prueba");

        List<Direcctions> direcctionsList = null;
        direcctionsList.add(direcctions);



        persona = new Persona(2L,"juan","perez","13456",direcctionsList);

    }
    @Test
    void save() throws URISyntaxException {

    when(personaController.save(any(Persona.class))).thenReturn(String.valueOf(ResponseEntity.ok(persona)));
        assertNotNull(personaController.save(new Persona()));
    }

    @Test
    void getExternalApi() throws  URISyntaxException{

        when(personaController.getAllFilmsComplete()).thenReturn(String.valueOf(ResponseEntity.ok(film)));
        assertNotNull(personaController.getAllFilmsComplete());
    }






}