package com.krakedev.asistencias.servicios;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.krakedev.asistencias.entidades.Estudiante;

@Service
public class ServicioEstudiante {

	private ArrayList<Estudiante> estudiantes = new ArrayList<>();

	// no permite duplicados
	public Estudiante agregar(Estudiante estudiante) {
		Estudiante encontrado = buscarPorCedula(estudiante.getCedula());
		if (encontrado == null) {
			estudiantes.add(estudiante);
			return estudiante;
		} else {
			return null;
		}
	}

	public Estudiante buscarPorCedula(String cedula) {
		for (Estudiante e : estudiantes) {
			if (e.getCedula().equals(cedula)) {
				return e;
			}
		}
		return null;
	}

	public boolean eliminar(String cedula) {
		Estudiante encontrado = buscarPorCedula(cedula);
		if (encontrado != null) {
			estudiantes.remove(encontrado);
			return true;
		} else {
			return false;
		}
	}

	public Estudiante actualizar(String cedula, Estudiante nuevo) {
		Estudiante encontrado = buscarPorCedula(cedula);
		if (encontrado != null) {
			encontrado.setApellido(nuevo.getApellido());
			encontrado.setNombre(nuevo.getNombre());
			return encontrado;
		} else {
			return null;
		}
	}

	public ArrayList<Estudiante> listar() {
		return estudiantes;
	}
}
