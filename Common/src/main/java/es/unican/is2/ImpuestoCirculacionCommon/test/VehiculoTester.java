package es.unican.is2.ImpuestoCirculacionCommon.test;

import org.junit.Assert.*;

import es.unican.is2.ImpuestoCirculacionCommon.Turismo;
import es.unican.is2.ImpuestoCirculacionCommon.Vehiculo;

import java.time.LocalDate;

import org.junit.*;

public class VehiculoTester {
	
	private Vehiculo v;
	
	
	@Test
	void vehiculoConstructorTest() {
		// Caso de prueba valido (Turismo)
		Vehiculo v = new Turismo("0000-AAA",LocalDate.now(),1.0);
	}
}
