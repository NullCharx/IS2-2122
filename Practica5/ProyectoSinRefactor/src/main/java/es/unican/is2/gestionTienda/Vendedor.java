package es.unican.is2.gestionTienda;


/**
 * Vendedor de la tienda. 
 * Por cada vendedor se almacenan sus datos personales 
 * y sus datos sobre ventas y comisiones
 */

//WMC: 6
//WMCn: 6/6 = 1
//AFF: 2 (Tienda, GestionComisiones)
//EFF: 0
//CBO (AFF U EFF): 2
//DIT: 0
//NOC: 1
//CCog: 0
public abstract class Vendedor {

	private String id;
	private String nombre;
	
	
	// Valor total de las ventas mensuales realizadas por el vendedor
	private double t;
	
	//Complejidad ciclomatica: 0 + 1 = 1
	//Complejidad cognitiva: 0
	public Vendedor(String nombre, String id) {
		this.nombre = nombre;
		this.id = id;
	}
	

	/**
	 * Retorna el nombre del vendedor
	 * @return nombre
	 */
	//Complejidad ciclomatica: 0 + 1 = 1
	//Complejidad cognitiva: 0
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Retorna el dni del vendedor
	 * @return dni
	 */
	//Complejidad ciclomatica: 0 + 1 = 1
	//Complejidad cognitiva: 0
	public String getId() {
		return id;
	}
	
	
	/**
	 * Retorna el total de ventas acumuladas por el vendedor
	 * @return Total de ventas
	 */
	//Complejidad ciclomatica: 0 + 1 = 1
	//Complejidad cognitiva: 0
	public double getTotalVentas() {
		return t;
	}
	
	/**
	 * Asigna el total de ventas acumuladas por el vendedor
	 * Se utiliza para poder cargar los datos desde fichero
	 * @param Total de ventas
	 */
	//Complejidad ciclomatica: 0 + 1 = 1
	//Complejidad cognitiva: 0
	public void setT(double totalVentas) {
		this.t = totalVentas;
	}
	
	/**
	 * Anhade una nueva venta al vendedor, actualizando su comision
	 * @param importe de la venta
	 */
	//Complejidad ciclomatica: 0 + 1 = 1
	//Complejidad cognitiva: 0
	public void anhade(double importe) {
		t += importe;
	}
	
}
