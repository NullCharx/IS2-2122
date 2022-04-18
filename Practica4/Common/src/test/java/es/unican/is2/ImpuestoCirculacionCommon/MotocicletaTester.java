package es.unican.is2.ImpuestoCirculacionCommon;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.LocalDate;

import org.junit.Test;

import es.unican.is2.ImpuestoCirculacionCommon.Motocicleta;

public class MotocicletaTester {

	@Test
	public void MotocicletaConstructorTest() {
		// Casos de prueba validos
		try {
			Motocicleta t = new Motocicleta("0000-AAA",LocalDate.now(),95);
			Motocicleta t2 = new Motocicleta("9999-ZZZ",LocalDate.of(1900,10,31),79);
			Motocicleta t3 = new Motocicleta("6670-JDB",LocalDate.of(2001,12,27),1);
		} catch (Exception e) {
			System.out.println(e);
			fail();
		}
		
		// Casos de prueba NO validos
		
		// Matricula vacia
		try {
			Motocicleta t = new Motocicleta("",LocalDate.now(),456);
			fail();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// Matricula null
		try {
			Motocicleta t = new Motocicleta(null,LocalDate.now(),456);
			fail();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// Fecha matriculacion 1 dia mayor que ahora
		try {
			Motocicleta t = new Motocicleta("0000-AAA",LocalDate.now().plusDays(1),456);
			fail();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		// Fecha matriculacion < 30/10/1930
		try {
			Motocicleta t = new Motocicleta("0000-AAA",LocalDate.of(1900, 10, 29),456);
			fail();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// Fecha null
		try {
			Motocicleta t = new Motocicleta("0000-AAA",null,456);
			fail();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// Cilindrada negativa
		try {
			Motocicleta t = new Motocicleta("0000-AAA",LocalDate.now(),-456);
			fail();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// Cilindrada 0
		try {
			Motocicleta t = new Motocicleta("0000-AAA",LocalDate.now(), 0);
			fail();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Test
	public void MotocicletaImpuestosEnBaseACilindrada() {
		
		// Casos de prueba validos
		try {
			// Vehiculo con mas de 25 años
			Motocicleta t = new Motocicleta("0000-AAA",LocalDate.of(1955,10,30),1);
			assertTrue(t.precioImpuesto() == 0);
			
			// Vehiculo con cilindrada menor que 8)
			Motocicleta t2 = new Motocicleta("9999-ZZZ",LocalDate.now(),124);
			Motocicleta t3 = new Motocicleta("6670-JDB",LocalDate.now(),1);
			assertTrue(t2.precioImpuesto() == 8.84);
			assertTrue(t3.precioImpuesto() == 8.84);
			
			// Vehiculo con cilindrada entre [8 y 12)
			Motocicleta t4 = new Motocicleta("9999-ZZZ",LocalDate.now(),125);
			Motocicleta t5 = new Motocicleta("6670-JDB",LocalDate.now(),249);
			assertTrue(t4.precioImpuesto() == 15.14);
			assertTrue(t5.precioImpuesto() == 15.14);
			
			// Vehiculo con cilindrada entre [12 y 16)
			Motocicleta t6 = new Motocicleta("9999-ZZZ",LocalDate.now(),250);
			Motocicleta t7 = new Motocicleta("6670-JDB",LocalDate.now(),499);
			assertTrue(t6.precioImpuesto() == 30.30);
			assertTrue(t7.precioImpuesto() == 30.30);
			
			// Vehiculo con cilindrada entre [16 y 20)
			Motocicleta t8 = new Motocicleta("9999-ZZZ",LocalDate.now(),500);
			Motocicleta t9 = new Motocicleta("6670-JDB",LocalDate.now(),999);
			assertTrue(t8.precioImpuesto() == 60.58);
			assertTrue(t9.precioImpuesto() == 60.58);
			
			// Vehiculo con cilindrada mayor que [20
			Motocicleta t10 = new Motocicleta("9999-ZZZ",LocalDate.now(),1000);
			Motocicleta t11 = new Motocicleta("6670-JDB",LocalDate.now(),5000);
			assertTrue(t10.precioImpuesto() == 121.16);
			assertTrue(t11.precioImpuesto() == 121.16);
		} catch (Exception e) {
			System.out.println(e);
			fail();
		}
	}
}
