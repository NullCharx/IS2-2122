package es.unican.is2.ImpuestoCirculacionCommon;

import es.unican.is2.ImpuestoCirculacionCommon.Furgoneta;
import es.unican.is2.ImpuestoCirculacionCommon.Turismo;
import es.unican.is2.ImpuestoCirculacionCommon.Furgoneta;
import es.unican.is2.ImpuestoCirculacionCommon.Furgoneta;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.*;
public class FurgonetaTester {

	@Test
	public void furgonetaConstructorTest() {
		
		// Casos de prueba validos
		try {
			Furgoneta f = new Furgoneta("0000-AAA",LocalDate.now(),95.86,true);
			Furgoneta f2 = new Furgoneta("9999-ZZZ",LocalDate.of(1900,10,31),79.00,false);
		} catch (Exception e) {
			System.out.println(e);
			fail();
		}
		
		// Casos de prueba NO validos (dada la naturaleza del boolean y la deteccion de errores de java, no hay casos posibles,
		// mas alla de los que habia en la clase Furgoneta)
		
		// Matricula vacia
		try {
			Furgoneta t = new Furgoneta("",LocalDate.now(),456.00,false);
			fail();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// Matricula null
		try {
			Furgoneta t = new Furgoneta(null,LocalDate.now(),456.00,false);
			fail();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// Fecha matriculacion 1 dia mayor que ahora
		try {
			Furgoneta t = new Furgoneta("0000-AAA",LocalDate.now().plusDays(1),456.00,false);
			fail();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		// Fecha matriculacion < 30/10/1930
		try {
			Furgoneta t = new Furgoneta("0000-AAA",LocalDate.of(1900, 10, 29),456.00,false);
			fail();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// Fecha null
		try {
			Furgoneta t = new Furgoneta("0000-AAA",null,456.00,false);
			fail();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// Potencia negativa
		try {
			Furgoneta t = new Furgoneta("0000-AAA",LocalDate.now(),-456.00,false);
			fail();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// Potencia 0
		try {
			Furgoneta t = new Furgoneta("0000-AAA",LocalDate.now(), 0,false);
			fail();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Test
	public void furgonetaImpuestosEnBaseAPotencia() {
		
		// Casos de prueba validos
		try {
			
			// Vehiculo con potencia menor que 8)
			Furgoneta f = new Furgoneta("0000-AAA",LocalDate.now(),7.99,true);
			Turismo t = new Turismo("9999-ZZZ",LocalDate.now(),7.99);
			assertTrue(t.precioImpuesto() - 0.2 * t.precioImpuesto() == f.precioImpuesto());
			
			
			Furgoneta f2 = new Furgoneta("9999-ZZZ",LocalDate.now(),7.99,false);
			Turismo t2 = new Turismo("9999-ZZZ",LocalDate.now(),7.99);
			assertTrue(f2.precioImpuesto() == t2.precioImpuesto());
			
			Furgoneta f3 = new Furgoneta("0000-AAA",LocalDate.now(),0.01,true);
			Turismo t3 = new Turismo("9999-ZZZ",LocalDate.now(),0.01);
			assertTrue(t3.precioImpuesto() - 0.2 * t3.precioImpuesto() == f3.precioImpuesto());
			
			
			Furgoneta f4 = new Furgoneta("9999-ZZZ",LocalDate.now(),0.01,false);
			Turismo t4 = new Turismo("9999-ZZZ",LocalDate.now(),0.01);
			assertTrue(f4.precioImpuesto() == t4.precioImpuesto());
			
			
			// Vehiculo con potencia entre [8 y 12)
			Furgoneta f5 = new Furgoneta("0000-AAA",LocalDate.now(),8,true);
			Turismo t5 = new Turismo("9999-ZZZ",LocalDate.now(),8);
			assertTrue(t5.precioImpuesto() - 0.2 * t5.precioImpuesto() == f5.precioImpuesto());
			
			Furgoneta f6 = new Furgoneta("9999-ZZZ",LocalDate.now(),8,false);
			Turismo t6 = new Turismo("9999-ZZZ",LocalDate.now(),8);
			assertTrue(f6.precioImpuesto() == t6.precioImpuesto());
			
			Furgoneta f7 = new Furgoneta("0000-AAA",LocalDate.now(),11.99,true);
			Turismo t7 = new Turismo("9999-ZZZ",LocalDate.now(),11.99);
			assertTrue(t7.precioImpuesto() - 0.2 * t7.precioImpuesto() == f7.precioImpuesto());
			
			
			Furgoneta f8 = new Furgoneta("9999-ZZZ",LocalDate.now(),11.99,false);
			Turismo t8 = new Turismo("9999-ZZZ",LocalDate.now(),11.99);
			assertTrue(f8.precioImpuesto() == t8.precioImpuesto());
			
			// Vehiculo con potencia entre [12 y 16)
			Furgoneta f9 = new Furgoneta("0000-AAA",LocalDate.now(),12,true);
			Turismo t9 = new Turismo("9999-ZZZ",LocalDate.now(),12);
			assertTrue(t9.precioImpuesto() - 0.2 * t9.precioImpuesto() == f9.precioImpuesto());
			
			Furgoneta f10 = new Furgoneta("9999-ZZZ",LocalDate.now(),12,false);
			Turismo t10 = new Turismo("9999-ZZZ",LocalDate.now(),12);
			assertTrue(f10.precioImpuesto() == t10.precioImpuesto());
			
			Furgoneta f11 = new Furgoneta("0000-AAA",LocalDate.now(),15.99,true);
			Turismo t11 = new Turismo("9999-ZZZ",LocalDate.now(),15.99);
			assertTrue(t11.precioImpuesto() - 0.2 * t11.precioImpuesto() == f11.precioImpuesto());
			
			
			Furgoneta f12 = new Furgoneta("9999-ZZZ",LocalDate.now(),15.99,false);
			Turismo t12 = new Turismo("9999-ZZZ",LocalDate.now(),15.99);
			assertTrue(f12.precioImpuesto() == t12.precioImpuesto());
			
			
			// Vehiculo con potencia entre [16 y 20)
			Furgoneta f13 = new Furgoneta("0000-AAA",LocalDate.now(),16,true);
			Turismo t13 = new Turismo("9999-ZZZ",LocalDate.now(),16);
			assertTrue(t13.precioImpuesto() - 0.2 * t13.precioImpuesto() == f13.precioImpuesto());
			
			Furgoneta f14 = new Furgoneta("9999-ZZZ",LocalDate.now(),16,false);
			Turismo t14 = new Turismo("9999-ZZZ",LocalDate.now(),16);
			assertTrue(f14.precioImpuesto() == t14.precioImpuesto());
			
			Furgoneta f15 = new Furgoneta("0000-AAA",LocalDate.now(),19.99,true);
			Turismo t15 = new Turismo("9999-ZZZ",LocalDate.now(),19.99);
			assertTrue(t15.precioImpuesto() - 0.2 * t15.precioImpuesto() == f15.precioImpuesto());
			
			
			Furgoneta f16 = new Furgoneta("9999-ZZZ",LocalDate.now(),19.99,false);
			Turismo t16 = new Turismo("9999-ZZZ",LocalDate.now(),19.99);
			assertTrue(f16.precioImpuesto() == t16.precioImpuesto());
			
			
			// Vehiculo con potencia mayor que [20
			Furgoneta f17 = new Furgoneta("0000-AAA",LocalDate.now(),20,true);
			Turismo t17 = new Turismo("9999-ZZZ",LocalDate.now(),20);
			assertTrue(t17.precioImpuesto() - 0.2 * t17.precioImpuesto() == f17.precioImpuesto());
			
			Furgoneta f18 = new Furgoneta("9999-ZZZ",LocalDate.now(),20,false);
			Turismo t18 = new Turismo("9999-ZZZ",LocalDate.now(),20);
			assertTrue(f18.precioImpuesto() == t18.precioImpuesto());
			
			Furgoneta f19 = new Furgoneta("0000-AAA",LocalDate.now(),500,true);
			Turismo t19 = new Turismo("9999-ZZZ",LocalDate.now(),500);
			assertTrue(t19.precioImpuesto() - 0.2 * t19.precioImpuesto() == f19.precioImpuesto());
			
			
			Furgoneta f20 = new Furgoneta("9999-ZZZ",LocalDate.now(),500,false);
			Turismo t20 = new Turismo("9999-ZZZ",LocalDate.now(),500);
			assertTrue(f20.precioImpuesto() == t20.precioImpuesto());
			
		} catch (Exception e) {
			System.out.println(e);
			fail();
		}
	}
}
