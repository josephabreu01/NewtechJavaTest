package com.API.Newtech.service;

import com.API.Newtech.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona,Long> {


}
