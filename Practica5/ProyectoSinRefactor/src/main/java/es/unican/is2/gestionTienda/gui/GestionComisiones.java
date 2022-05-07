package es.unican.is2.gestionTienda.gui;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import es.unican.is2.gestionTienda.Tienda;
import es.unican.is2.gestionTienda.Vendedor;
import fundamentos.Menu;
import fundamentos.Lectura;
import fundamentos.Mensaje;

/**
 * Gesti�n de las comisiones de vendedores de una tienda
 */

//WMC: 15
//WMCn: 15/3 = 5
//AFF: 1 (ComparadorVendedorVentas)
//EFF: 3 (Vendedor, Tienda, ComparadorVendedorVentas)
//CBO (AFF U EFF): 0
//DIT: 0
//NOC: 0
//Ccog: 23
public class GestionComisiones {


	/**
	 * Programa principal basado en menu
	 */
	//Complejidad ciclomatica:1+3+1+1+1+1+1+1 = 10
	//Complejidad cognitiva: 21
	public static void main(String[] args) {
		// opciones del menu
		final int NUEVA_VENTA = 0, VENDEDOR_DEL_MES = 1, VENDEDORES = 2;

		// variables auxiliares
		String dni;
		Lectura lect;

		List<Vendedor> vendedores;
		List<Vendedor> resultado;
		String msj;

		// crea la tienda
		Tienda tienda = new Tienda("C:\\Users\\carlo\\Documents\\3carrera\\Ingenieria de Software II\\practicas\\ProyectoGIT\\IS2-2122\\Practica5\\datosTienda.txt");

		// crea la ventana de menu
		Menu menu = new Menu("Comisiones tienda");
		menu.insertaOpcion("A�adir venta", NUEVA_VENTA);
		menu.insertaOpcion("Vendedor del mes", VENDEDOR_DEL_MES);
		menu.insertaOpcion("Vendedores por ventas", VENDEDORES);
		int opcion;

		// lazo de espera de comandos del usuario
		while (true) {//CC 1 Ccog 1
			opcion = menu.leeOpcion();

			// realiza las acciones dependiendo de la opcion elegida
			switch (opcion) {//CC 1 + 1 + 1 = 3, Ccog 1 (switch) +  1 (nivel de anidacion 1)
			case NUEVA_VENTA:
				lect = new Lectura("Datos Venta");
				lect.creaEntrada("Id Vendedor", "");
				lect.creaEntrada("Importe", "");
				lect.esperaYCierra();
				dni = lect.leeString("Id Vendedor");
				double importe = lect.leeDouble("Importe");
				try {//Ccog 1
					if (!tienda.anhadeVenta(dni, importe)) {//CC 1, Ccog 1 + 2 (Nivel de anidacion 2)
						mensaje("ERROR", "El vendedor no existe");
					}
				} catch (IOException e) {
					mensaje("ERROR", "No se pudo guardar el cambio");
				}
				break;

			case VENDEDOR_DEL_MES:

				vendedores = tienda.vendedores();
				resultado = new LinkedList<Vendedor>();
				double maxVentas = 0.0;
				for (Vendedor v : vendedores) {//CC 1 Ccog 1 + 2 (nivel de anidacion 2)
					if (v.getTotalVentas() > maxVentas) {//CC 1 Ccog 1 +  3 (Nivel de anidacion 3)
						maxVentas = v.getTotalVentas();
						resultado.clear();
						resultado.add(v);
					} else if (v.getTotalVentas() == maxVentas) {//CC 1, Ccog 1
						resultado.add(v);
					}
				}

				msj = "";
				for (Vendedor vn : resultado) {//CC 1 Ccog 1 + 2 (Nivel de anidacion 2)
					msj += vn.getNombre() + "\n";
				}
				mensaje("VENDEDORES DEL MES", msj);
				break;

			
			case VENDEDORES:
	
				vendedores = tienda.vendedores();
				System.out.println(vendedores.size());
				Collections.sort(vendedores, new ComparadorVendedorVentas());			
				msj = "";
				for (Vendedor vn : vendedores) {//C 1, Ccog 1 + 2 (Nivel de anidacion 2)
					msj += vn.getNombre() + " " + vn.getTotalVentas() + "\n";
				}
				mensaje("VENDEDORES", msj);
				break;
			}
		}
	}

	/**
	 * Metodo auxiliar que muestra un ventana de mensaje
	 * @param titulo Titulo de la ventana
	 * @param txt Texto contenido en la ventana
	 */
	// Complejidad Cicloamtica 0 + 1 = 1
	//Complejidad cognitiva: 0
	private static void mensaje(String titulo, String txt) {
		Mensaje msj = new Mensaje(titulo);
		msj.escribe(txt);

	}
	
	

	//WMC: 3
	//WMCn: 3/1 = 3
	//AFF: 1 (GestionComisiones)
	//EFF: 1 (Vendedor)
	//CBO (AFF U EFF): 1
	//DIT: 0
	//NOC: 0
	//Ccog: 2
	public static class ComparadorVendedorVentas implements Comparator<Vendedor>  {

		// Complejidad Cicloamtica 1 + 1 + 1 = 3
		//Complejidad cognitiva: 2
		public int compare(Vendedor o1, Vendedor o2) {
			if (o1.getTotalVentas()>o2.getTotalVentas())//CC 1, Ccog 1
				return -1;
			else if (o1.getTotalVentas()<o2.getTotalVentas())//CC1, Ccog 1
				return 1;
			return 0;
		}
		
	}
	
	
}
