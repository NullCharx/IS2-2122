package es.unican.is2.ImpuestoCirculacionCommon.test;

import es.unican.is2.ImpuestoCirculacionCommon.Turismo;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.*;

public class TurismoTester {
	
	
	
	@Test
	public void turismoConstructorTest() {
		// Casos de prueba validos
		try {
			Turismo t = new Turismo("0000-AAA",LocalDate.now(),95.86);
			Turismo t2 = new Turismo("9999-ZZZ",LocalDate.of(1900,10,31),79.00);
			Turismo t3 = new Turismo("6670-JDB",LocalDate.of(2001,12,27),1);
		} catch (Exception e) {
			System.out.println(e);
			fail();
		}
		
		// Casos de prueba NO validos
		
		// Matricula vacia
		try {
			Turismo t = new Turismo("",LocalDate.now(),456.00);
			fail();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// Matricula null
		try {
			Turismo t = new Turismo(null,LocalDate.now(),456.00);
			fail();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// Fecha matriculacion 1 dia mayor que ahora
		try {
			Turismo t = new Turismo("0000-AAA",LocalDate.now().plusDays(1),456.00);
			fail();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		// Fecha matriculacion < 30/10/1930
		try {
			Turismo t = new Turismo("0000-AAA",LocalDate.of(1900, 10, 29),456.00);
			fail();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// Fecha null
		try {
			Turismo t = new Turismo("0000-AAA",null,456.00);
			fail();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// Potencia negativa
		try {
			Turismo t = new Turismo("0000-AAA",LocalDate.now(),-456.00);
			fail();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// Potencia 0
		try {
			Turismo t = new Turismo("0000-AAA",LocalDate.now(), 0);
			fail();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Test
	public void turismoImpuestosEnBaseAPotencia() {
		
		// Casos de prueba validos
		try {
			// Vehiculo con mas de 25 años
			Turismo t = new Turismo("0000-AAA",LocalDate.of(1955,10,30),1);
			assertTrue(t.precioImpuesto() == 0);
			
			// Vehiculo con potencia menor que 8)
			Turismo t2 = new Turismo("9999-ZZZ",LocalDate.now(),7.99);
			Turismo t3 = new Turismo("6670-JDB",LocalDate.now(),0.01);
			assertTrue(t2.precioImpuesto() == 25.24);
			assertTrue(t3.precioImpuesto() == 25.24);
			
			// Vehiculo con potencia entre [8 y 12)
			Turismo t4 = new Turismo("9999-ZZZ",LocalDate.now(),8);
			Turismo t5 = new Turismo("6670-JDB",LocalDate.now(),11.99);
			assertTrue(t4.precioImpuesto() == 68.16);
			assertTrue(t5.precioImpuesto() == 68.16);
			
			// Vehiculo con potencia entre [12 y 16)
			Turismo t6 = new Turismo("9999-ZZZ",LocalDate.now(),12);
			Turismo t7 = new Turismo("6670-JDB",LocalDate.now(),15.99);
			assertTrue(t6.precioImpuesto() == 143.88);
			assertTrue(t7.precioImpuesto() == 143.88);
			
			// Vehiculo con potencia entre [16 y 20)
			Turismo t8 = new Turismo("9999-ZZZ",LocalDate.now(),16);
			Turismo t9 = new Turismo("6670-JDB",LocalDate.now(),19.99);
			assertTrue(t8.precioImpuesto() == 179.22);
			assertTrue(t9.precioImpuesto() == 179.22);
			
			// Vehiculo con potencia mayor que [20
			Turismo t10 = new Turismo("9999-ZZZ",LocalDate.now(),20);
			Turismo t11 = new Turismo("6670-JDB",LocalDate.now(),500);
			assertTrue(t10.precioImpuesto() == 224.00);
			assertTrue(t11.precioImpuesto() == 224.00);
		} catch (Exception e) {
			System.out.println(e);
			fail();
		}
	}
}
