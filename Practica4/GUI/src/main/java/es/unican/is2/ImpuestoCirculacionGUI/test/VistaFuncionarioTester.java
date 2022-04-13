package es.unican.is2.ImpuestoCirculacionGUI.test;

import static org.junit.Assert.*;

import org.junit.*;
import org.fest.swing.fixture.FrameFixture;

import es.unican.is2.ImpuestoCirculacionBusiness.GestionImpuestoCirculacion;
import es.unican.is2.ImpuestoCirculacionDAO.ContribuyentesDAO;
import es.unican.is2.ImpuestoCirculacionDAO.VehiculosDAO;
import es.unican.is2.ImpuestoCirculacionGUI.VistaFuncionario;

public class VistaFuncionarioTester {
	
	private FrameFixture demo;

	@Before
	public void setUp() {
		ContribuyentesDAO contribuyentesDAO = new ContribuyentesDAO();
		VehiculosDAO vehiculosDAO = new VehiculosDAO();
		
		// Componentes capa negocio
		GestionImpuestoCirculacion negocio = new GestionImpuestoCirculacion(contribuyentesDAO, vehiculosDAO);
		
		// Componentes casa presentacion
		VistaFuncionario vista = new VistaFuncionario(negocio, negocio, negocio);
		demo = new FrameFixture(vista);
		vista.setVisible(true);
	}
	
	@After
	public void tearDown() {
		demo.cleanUp();
	}
	
	@Test
	public void rellenaDatosValidosTest() {
		// Caso 1
		demo.textBox("txtDniContribuyente").enterText("11111111A");
		demo.button("btnBuscar").click();
		demo.textBox("txtNombreContribuyente").requireText("Pepe López Martínez");
		demo.list("txtLista").requireItemCount(2);
		assertTrue(demo.list("txtLista").valueAt(0).equals("1111-AAA"));
		assertTrue(demo.list("txtLista").valueAt(1).equals("1111-BBB"));
		demo.textBox("txtTotalContribuyente").requireText("403.2");
		
		demo.textBox("txtDniContribuyente").deleteText();
		
		// Caso 2
		demo.textBox("txtDniContribuyente").enterText("22222222B");
		demo.button("btnBuscar").click();
		demo.textBox("txtNombreContribuyente").requireText("Ana Pérez López");
		demo.list("txtLista").requireItemCount(2);
		assertTrue(demo.list("txtLista").valueAt(0).equals("2222-AAA"));
		assertTrue(demo.list("txtLista").valueAt(1).equals("2222-BBB"));
		demo.textBox("txtTotalContribuyente").requireText("0.0");
		
		demo.textBox("txtDniContribuyente").deleteText();
		
		// Caso 3
		demo.textBox("txtDniContribuyente").enterText("33333333C");
		demo.button("btnBuscar").click();
		demo.textBox("txtNombreContribuyente").requireText("Luis Toca Pérez");
		demo.list("txtLista").requireItemCount(2);
		assertTrue(demo.list("txtLista").valueAt(0).equals("3333-AAA"));
		assertTrue(demo.list("txtLista").valueAt(1).equals("3333-BBB"));
		demo.textBox("txtTotalContribuyente").requireText("249.24");
	}
	
	@Test
	public void rellenaDatosNoValidosTest() {
		demo.textBox("txtDniContribuyente").enterText("dninovalido");
		demo.button("btnBuscar").click();
		demo.textBox("txtNombreContribuyente").requireText("DNI No Válido");
		demo.list("txtLista").requireItemCount(0);
		demo.textBox("txtTotalContribuyente").requireText("0");
	}
}
