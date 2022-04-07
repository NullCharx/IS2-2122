package es.unican.is2.ImpuestoCirculacionCommon;

import java.io.Serializable;
import java.time.LocalDate;


@SuppressWarnings("serial")
public abstract class Vehiculo implements Serializable{
  
    private String matricula;
	private LocalDate fechaMatriculacion;	
	public class DatoInvalido extends RuntimeException {
		public DatoInvalido(String mensaje) {
			super(mensaje);
		}
	}
	
	
	public Vehiculo (String matricula, LocalDate fechaMatriculacion) throws DatoInvalido, NullPointerException {
		if (matricula == null || fechaMatriculacion == null) {
			throw new NullPointerException();
		}
		if (matricula.equals("")) {
			throw new DatoInvalido("Esta matricula es un string vacio");
		}
		if (fechaMatriculacion.isAfter(LocalDate.now()) || fechaMatriculacion.isBefore(LocalDate.of(1900, 10, 30))) {
			throw new DatoInvalido("La fecha esta fuera del intervalo valido");
		}
		this.matricula = matricula;
		
		this.fechaMatriculacion = fechaMatriculacion;
	}

	/**
     * Retorna el valor del impuesto de circulacion
     *  @return valor del impuesto circulacion
     */
	public abstract double precioImpuesto (); 


	/**
	 * Retorna la matricula del vehiculo
	 * @return matricula
	 */
    public String getMatricula() {
		return matricula;
	}

    /**
     * Retorna la fecha de matriculacion del vehiculo
     * @return fecha de matriculacion
     */
	public LocalDate getFechaMatriculacion() {
		return fechaMatriculacion;
	}

}
