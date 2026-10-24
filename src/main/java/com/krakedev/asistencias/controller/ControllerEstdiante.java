package com.krakedev.asistencias.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.asistencias.entidades.Estudiante;
import com.krakedev.asistencias.servicios.ServicioEstudiante;

@RestController

@RequestMapping("/estudiante")
public class ControllerEstdiante {
	private final ServicioEstudiante servicioEstudiante;

	public ControllerEstdiante(ServicioEstudiante servicioEstudiante) {
	        this.servicioEstudiante = servicioEstudiante;
	    }

	@PostMapping
	public Estudiante crear(@RequestBody Estudiante estudiante) {
		return servicioEstudiante.agregar(estudiante);
	}

	@GetMapping("/{cedula}")
	public Estudiante buscar(@PathVariable String cedula) {
		return servicioEstudiante.buscarPorCedula(cedula);
	}

	@DeleteMapping("/{cedula}")
	public boolean eliminar(@PathVariable String cedula) {
		return servicioEstudiante.eliminar(cedula);
	}

	@PutMapping("/{cedula}")
	public Estudiante actualizar(@PathVariable String cedula, @RequestBody Estudiante estudianteActualizado) {
		return servicioEstudiante.actualizar(cedula, estudianteActualizado);
	}

	@GetMapping
	public List<Estudiante> listar() {
		return servicioEstudiante.listar();
	}

}
