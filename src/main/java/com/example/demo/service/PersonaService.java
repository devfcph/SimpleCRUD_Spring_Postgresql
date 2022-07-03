package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Persona;
import com.example.demo.repository.PersonaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

	@Autowired
	private PersonaRepository personaRepository;
	
	public Persona Crear(Persona persona)
	{
		return personaRepository.save(persona);
		
	}
	
	public List<Persona> obtenerPersonaTodo() {
		return personaRepository.findAll();
	}
	
	
	public Persona Actualizar(Persona persona)
	{
		return personaRepository.saveAndFlush(persona);
	}
	
	public void Eliminar(Persona persona)
	{
		personaRepository.delete(persona);
	}
	
	public Optional<Persona> obtenerPersonaPorId(Long id)
	{
		return personaRepository.findById(id);	
	}
	
}
