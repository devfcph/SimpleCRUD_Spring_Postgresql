package com.example.demo.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Persona;
import com.example.demo.service.PersonaService;

@RestController
@RequestMapping ("/api/persona/")
public class PersonaREST {

	@Autowired
	private PersonaService personaService;
	
	@PostMapping ("guardar")
	private ResponseEntity<Persona> guardarPersona(@RequestBody Persona persona)
	{
		Persona _persona = personaService.Crear(persona);
		try {
			return ResponseEntity.created(new URI("/api/persona/guardar" + _persona.getId())).body(_persona);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping ("obtener")
	private ResponseEntity<List<Persona>> obtenerPersonas()
	{
		return ResponseEntity.ok(personaService.obtenerPersonaTodo());
		
	}
	
	
	@DeleteMapping ("eliminar")
	private ResponseEntity<Void> eliminarPersona(@RequestBody Persona persona)
	{
		personaService.Eliminar(persona);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping (value = "obtenerpersona/{id}")
	private ResponseEntity<Optional<Persona>> obtenerPersonaPorId(@PathVariable ("id") Long id)
	{
		return ResponseEntity.ok(personaService.obtenerPersonaPorId(id));
	}
	
}
