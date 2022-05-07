package es.unican.is2.gestionTienda;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Clase que representa una tienda con un conjunto de vendedores.
 * Gestiona las ventas realizadas y las comisiones asignadas a cada
 * vendedor. Los datos de la tienda se almacenan en un fichero de texto
 * que se pasa como parámetro al crear la tienda
 */

//WMC: 35
//WMCn: 37/11 = 3,18 (approx)
//AFF: 1 (GestionComisiones)
//EFF: 2  (Vendedor, tipoVendedor)
//CBO (AFF U EFF): 3
//DIT: 0
//NOC: 0
//CCog: 30
public class Tienda {


	private LinkedList<Vendedor> lista = new LinkedList<Vendedor>();
	private String direccion;
	private String nombre;

	private String datos;

	/**
	 * Crea la tienda cargando los datos desde el fichero indicado
	 * 
	 * @param datos Path absoluto del fichero de datos
	 */
	//Complejidad ciclomatica: 0 + 1 = 1
	//Complejidad cognitiva: 0
	public Tienda(String datos) { 
		this.datos = datos;
	}

	/**
	 * Retorna la dirección de la tienda
	 * @return Dirección de la tienda
	 */
	//Complejidad ciclomatica: 0 + 1 = 1
	//Complejidad cognitiva: 0
	public String direccion() { 
		return direccion;
	}

	/**
	 * Retorna el nombre de la tienda
	 * @return Nombre de la tienda
	 */
	//Complejidad ciclomatica: 0 + 1 = 1
	//Complejidad cognitiva: 0
	public String nombre() { 
		return nombre;
	}

	/**
	 * Añade un nuevo vendedor a la tienda
	 * 
	 * @param nuevoVendedor
	 * @return true si el vendedor se ha anhadido 
	 *         false si ya había un vendedor con el mismo id
	 */
	//Complejidad ciclomatica: 1 + 1 = 2
	//Complejidad cognitiva: 1 
	public boolean anhadeVendedor(Vendedor nuevoVendedor) throws IOException { //Nombre metodo refactorizado desde "anhade"
		Vendedor vendedor = buscaVendedor(nuevoVendedor.getId());
		if (vendedor != null) {//CC 1, CCog 1
			return false;
		}
		lista.add(nuevoVendedor);
		vuelcaDatos();
		return true;
	}

	/**
	 * Elimina el vendedor cuyo dni se pasa como parámetro
	 * 
	 * @param id
	 * @return true si se elimina el vendedor 
	 *         false si no existe ningún vendedor con el id indicado
	 */
	//Complejidad ciclomatica: 1 + 1 = 2
	//Complejidad cognitiva: 1
	public boolean eliminaVendedor(String id) throws IOException {
		Vendedor vendedor = buscaVendedor(id);
		if (vendedor == null) {//CC1, CCOg 1
			return false;
		}
		lista.remove(vendedor);
		vuelcaDatos();
		return true;
	}

	/**
	 * Añade una venta a un vendedor
	 * @param id Id del vendedor
	 * @param importe Importe de la venta
	 * @return true si se añade la venta 
	 *         false si no se encuentra el vendedor
	 */
	//Complejidad ciclomatica:2 + 1 + 1 + 1 = 5
	//Complejidad cognitiva: 1 + 1 + 2 = 4
	public boolean anhadeVenta(String id, double importe) throws IOException { 
		Vendedor vendedor = buscaVendedor(id);
		if (vendedor == null) {//CC 1, CCog 1
			return false;
		}
		double importeFinal = importe;
		if (vendedor instanceof VendedorEnPlantilla) {//CC 1 CCog 
			switch (((VendedorEnPlantilla) vendedor).tipo()) { //CC 2, CCog 1 + 1 (Anidación de nivel 1)
			case JUNIOR:
				importeFinal += importeFinal * 0.005;
				break;
			case SENIOR:
				importeFinal += importeFinal * 0.01;
				break;
			}
		}
		vendedor.anhadeVentaVendedor(importeFinal);
		vuelcaDatos();
		return true;
	}

	/**
	 * Retorna el vendedor con el id indicado
	 * 
	 * @param id Id del vendedor
	 * @return vendedor con ese id o null si no existe ninguno
	 */
	//Complejidad ciclomatica: 2 + 1+1+1 = 5
	//Complejidad cognitiva: 5
	public Vendedor buscaVendedor(String id) {

		lista = new LinkedList<Vendedor>();
		Scanner in = null;
		try {//CCog 1 (catch) + 1 (finally)
			// abre el fichero
			in = new Scanner(new FileReader(datos));
			// configura el formato de números
			in.useLocale(Locale.ENGLISH);
			nombre = in.nextLine();
			direccion = in.nextLine();
			in.next();
			leerVendedores(in);
		} catch (FileNotFoundException e) {
		} finally {
			if (in != null) {//CC 1, Ccog 1
				in.close();
			}
		} // try

		for (Vendedor v : lista) {// CC 1, Ccog 1
			if (v.getId().equals(id)) { //CC 1, CCog 1
				return v;
			}
		}
		return null;
	}

	/**
	 * Retorna la lista de vendedores actuales de la tienda 
	 * @return La lista de vendedores
	 */
	//Complejidad ciclomatica: 1 + 1 = 2
	//Complejidad cognitiva: 3
	public List<Vendedor> vendedores() {
		lista = new LinkedList<Vendedor>();

		Scanner in = null;
		try {//CCog 1 (catch) + 1 (finally)
			// abre el fichero
			in = new Scanner(new FileReader(datos));
			// configura el formato de números
			in.useLocale(Locale.ENGLISH);
			nombre = in.nextLine();
			direccion = in.nextLine();
			in.next();
			// lee los vendedores
			leerVendedores(in);
		} catch (FileNotFoundException e) {

		} finally {
			if (in != null) {//CC 1 Ccog 1
				in.close();
			}
		} // try

		return lista;

	}

	//Complejidad ciclomatica: 2 + 1 + 1 + 1 +1 = 6
	//Complejidad cognitiva: 3
	private void leerVendedores(Scanner in) {
		Vendedor ven;
		while (in.hasNext() && !in.next().equals("Junior")) { //CC 2, Ccog 1

			String nombre = in.next();
			in.next();
			String idIn = in.next();
			in.next();
			String dni= in.next();
			in.next();
			double totalVentas = in.nextDouble();
			ven = new VendedorEnPlantilla(nombre, idIn, dni, TipoVendedor.SENIOR);
			ven.setVentasVendedor(totalVentas);
			lista.add(ven);
		}
		// lee los vendedores junior
		while (in.hasNext() && !in.next().equals("Prácticas")) { //CC 2 Ccog 1
			String nombre = in.next();
			in.next();
			String idIn = in.next();
			in.next();
			String dni= in.next();
			in.next();
			double totalVentas = in.nextDouble();
			ven = new VendedorEnPlantilla(nombre, idIn, dni, TipoVendedor.JUNIOR);
			ven.setVentasVendedor(totalVentas);
			lista.add(ven);
		}
		while (in.hasNext()) { //CC 1 Ccog 1
			in.next();
			String nombre = in.next();
			in.next();
			String idIn = in.next();
			in.next();
			String dni= in.next();
			in.next();
			double totalVentas = in.nextDouble();
			ven = new vendedorEnPracticas(nombre, idIn, dni);
			ven.setVentasVendedor(totalVentas);
			lista.add(ven);
		}
	}

	/**
	 * Método que actualiza el fichero datosTienda.txt 
	 * con los datos actualizados de los vendedores
	 */
	//Complejidad ciclomatica: 1+1+1+1+1= 5
	//Complejidad cognitiva: 5
	private void vuelcaDatos() throws IOException { 
		PrintWriter out = null;
		List<Vendedor> senior = new LinkedList<Vendedor>();
		List<Vendedor> junior = new LinkedList<Vendedor>();
		List<Vendedor> practicas = new LinkedList<Vendedor>();

		clasificaVendedores(senior, junior, practicas);//Refactorizacion metodo

		try { //Ccog 1 (finally)

			out = new PrintWriter(new FileWriter(datos));

			out.println(nombre);
			out.println(direccion);
			out.println();
			out.println("Senior");
			for (Vendedor v : senior) {//CC 1 Ccog 1
				Vendedor v1 = (Vendedor) v;
				out.println("  Nombre: " + v1.getNombre() + " Id: " + v1.getId() + " DNI: "+ v1.getDni()+" TotalVentasMes: "
						+ v1.getTotalVentas());
			}
			out.println();
			out.println("Junior");
			for (Vendedor v : junior) {//CC 1 Ccog 1
				Vendedor v2 = (Vendedor) v;
				out.println("  Nombre: " + v2.getNombre() + " Id: " + v2.getId() + " DNI: "+ v2.getDni()+" TotalVentasMes: "
						+ v2.getTotalVentas());
			}
			out.println();
			out.println("Prácticas");
			for (Vendedor v : practicas) {//CC 1 Ccog 1
				Vendedor v3 = (Vendedor) v;
				out.println("  Nombre: " + v3.getNombre() + " Id: " + v3.getId() + " DNI: "+ v3.getDni()+" TotalVentasMes: "
						+ v3.getTotalVentas());
			}

		} finally {
			if (out != null)//CC 1 Ccog 1
				out.close();
		}
	}

	//Complejidad ciclomatica: 1 + 1 + 1 + 1 +1   = 5
	//Complejidad cognitiva: 8
	private void clasificaVendedores(List<Vendedor> senior, List<Vendedor> junior, List<Vendedor> practicas) {
		for (Vendedor v : lista) {//CC 1 Ccog 1
			if (v instanceof vendedorEnPracticas) {//CC 1 Ccog 1 + 1 (primer nivel de anidacion
				practicas.add(v);
			} else if (v instanceof VendedorEnPlantilla) {//CC 1 Ccog 1
				VendedorEnPlantilla vp = (VendedorEnPlantilla) v;
				if (vp.tipo().equals(TipoVendedor.JUNIOR)) //CC 1 Ccog 1 + 2 (segundo nivel de anidacion)
					junior.add(vp);
				else //Ccog 1
					senior.add(vp);
			}
		}
	}

}
