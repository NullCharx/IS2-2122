package es.unican.is2.gestionTienda;


/**
 * Vendedor de la tienda. 
 * Por cada vendedor se almacenan sus datos personales 
 * y sus datos sobre ventas y comisiones
 */

/**
 * 
 * Weighted Method For Class: (WMC) 6
 * Weighted Method For Class (normalzied): 6/6 =  1
 *
 */
public abstract class Vendedor {
	
	private String id;
	private String nombre;
	
	
	// Valor total de las ventas mensuales realizadas por el vendedor
	private double t;
	
	public Vendedor(String nombre, String id) {//Complejidad ciclomatica: 0 + 1 = 1
		this.nombre = nombre;
		this.id = id;
	}
	

	/**
	 * Retorna el nombre del vendedor
	 * @return nombre
	 */
	public String getNombre() {//Complejidad ciclomatica: 0 + 1 = 1
		return nombre;
	}
	
	/**
	 * Retorna el dni del vendedor
	 * @return dni
	 */
	public String getId() {//Complejidad ciclomatica: 0 + 1 = 1
		return id;
	}
	
	
	/**
	 * Retorna el total de ventas acumuladas por el vendedor
	 * @return Total de ventas
	 */
	public double getTotalVentas() {//Complejidad ciclomatica: 0 + 1 = 1
		return t;
	}
	
	/**
	 * Asigna el total de ventas acumuladas por el vendedor
	 * Se utiliza para poder cargar los datos desde fichero
	 * @param Total de ventas
	 */
	public void setT(double totalVentas) {//Complejidad ciclomatica: 0 + 1 = 1
		this.t = totalVentas;
	}
	
	/**
	 * Anhade una nueva venta al vendedor, actualizando su comision
	 * @param importe de la venta
	 */
	public void anhade(double importe){//Complejidad ciclomatica: 0 + 1 = 1
		t += importe;
	}
	
}
