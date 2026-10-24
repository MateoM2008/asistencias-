package com.krakedev.asistencias.servicios;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.krakedev.asistencias.entidades.Asistencia;
import com.krakedev.asistencias.entidades.Estudiante;
import com.krakedev.asistencias.entidades.RegistroAsistencia;

@Service
public class ServicioAsistncia {
	private ArrayList<RegistroAsistencia> registros = new ArrayList<RegistroAsistencia>();

	private final ServicioEstudiante servicioEstudiantes;

	public ServicioAsistncia(ServicioEstudiante servicioEstudiantes) {
		this.servicioEstudiantes = servicioEstudiantes;
	}

	public RegistroAsistencia registrarAsistencia(String cedula) {
		// Buscar estudiante por cédula en servicioEstudiantes
		Estudiante estudiante = servicioEstudiantes.buscarPorCedula(cedula);

		// si no existe el estudiante retorna null
		if (estudiante == null) {
			return null;
		}

		// crea la asistencia con la fecha y hora actuales
		Asistencia asistencia = new Asistencia(LocalDate.now(), LocalDateTime.now(), "P");

		// crea el registro, lo agrega a la lista y lo retorna
		RegistroAsistencia registro = new RegistroAsistencia(estudiante, asistencia);
		registros.add(registro);
		return registro;
	}

	public ArrayList<Asistencia> consultarAsistencia(String cedula) {
        ArrayList<Asistencia> resultado = new ArrayList<Asistencia>();
        for (RegistroAsistencia r : registros) {
            if (r.getEstudiante().getCedula().equals(cedula)) {
                resultado.add(r.getAsistencia());
            }
        }
        return resultado;
    }
}
