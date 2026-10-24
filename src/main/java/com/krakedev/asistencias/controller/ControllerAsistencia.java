package com.krakedev.asistencias.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.asistencias.entidades.Asistencia;
import com.krakedev.asistencias.entidades.RegistroAsistencia;
import com.krakedev.asistencias.servicios.ServicioAsistncia;

@RestController

@RequestMapping("/asistencia")
public class ControllerAsistencia {

	private final ServicioAsistncia servicioAsistencia;

	public ControllerAsistencia(ServicioAsistncia servicioAsistencia) {
		this.servicioAsistencia = servicioAsistencia;
	}

	@PostMapping("/{cedula}")
	public RegistroAsistencia registro(@PathVariable String cedula) {
		return servicioAsistencia.registrarAsistencia(cedula);
	}

	@GetMapping("/{cedula}")
	public ArrayList<Asistencia> consultar(@PathVariable String cedula) {
		return servicioAsistencia.consultarAsistencia(cedula);
	}
}
