package es.unican.is2.gestionTienda;

/**
 * 
 * Weighted Method For Class: (WMC) 4
 * Weighted Method For Class (normalzied): 4/3 =  1.3
 *
 */

public class vendedorEnPracticas extends Vendedor {
	
	private String dni;
	
	/**
	 * Retorna un nuevo vendedor en prácticas
	 * @param nombre
	 * @param dni
	 */
	public vendedorEnPracticas(String nombre, String id, String dni) {//Complejidad ciclomatica: 0 + 1 = 1
		super(nombre, id);
		this.dni= dni;
	}
	
	public String getDni() {//Complejidad ciclomatica: 0 + 1 = 1
		return dni;
	}

	@Override
	public boolean equals(Object obj) {//Complejidad ciclomatica: 1 + 1 = 2
		if (!(obj instanceof vendedorEnPracticas)) //CC 1
			return false;
		vendedorEnPracticas v = (vendedorEnPracticas) obj;
		return (v.getId().equals(getId()) && v.getDni().equals(getDni()));
	}
}
