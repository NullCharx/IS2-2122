package es.unican.is2.gestionTienda;


/**
 * Vendedor de la tienda. 
 * Por cada vendedor se almacenan sus datos personales 
 * y sus datos sobre ventas y comisiones
 */

//WMC: 7
//WMCn: 7/7 = 1
//AFF: 2 (Tienda, GestionComisiones)
//EFF: 0
//CBO (AFF U EFF): 2
//DIT: 0
//NOC: 2
//CCog: 0
public abstract class Vendedor {

	private String id;
	private String nombre;
	
	
	// Valor total de las ventas mensuales realizadas por el vendedor
	private double totalVentasMensuales; //Atribuyo refactorizado de: "t"
	protected String dni;
	
	//Complejidad ciclomatica: 0 + 1 = 1
	//Complejidad cognitiva: 0
	public Vendedor(String nombre, String id, String dni) {
		this.nombre = nombre;
		this.id = id;
		this.dni = dni;
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
		return totalVentasMensuales;
	}
	
	/**
	 * Asigna el total de ventas acumuladas por el vendedor
	 * Se utiliza para poder cargar los datos desde fichero
	 * @param Total de ventas
	 */
	//Complejidad ciclomatica: 0 + 1 = 1
	//Complejidad cognitiva: 0
	public void setVentasVendedor(double totalVentas) {//Nombre metodo refactorizado desde "setT"
		this.totalVentasMensuales = totalVentas;
	}
	
	/**
	 * Anhade una nueva venta al vendedor, actualizando su comision
	 * @param importe de la venta
	 */
	//Complejidad ciclomatica: 0 + 1 = 1
	//Complejidad cognitiva: 0
	public void anhadeVentaVendedor(double importe) {//Nombre del metodo refactorizado desde "anhade"
		totalVentasMensuales += importe;
	}

	//Complejidad ciclomatica: 0 + 1 = 1
	//Complejidad cognitiva: 0
	public String getDni() {
		return dni;
	}

	
}
