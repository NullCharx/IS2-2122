package es.unican.is2.gestionTienda;


/**
 * 
 * Weighted Method For Class: (WMC) 5
 * Weighted Method For Class (normalzied): 5/4 =  1,25
 *
 */

public class VendedorEnPlantilla extends Vendedor {
	
	private TipoVendedor tipo;
	private String dni;
	
	/**
	 * Retorna un nuevo vendedor en plantilla del tipo que se indica
	 * @param nombre
	 * @param dni
	 * @param tipo
	 */
	public VendedorEnPlantilla(String nombre, String id, String dni, TipoVendedor tipo) {//Complejidad ciclomatica: 0 + 1 = 1
		super(nombre, id);
		this.tipo = tipo;
		this.dni=dni;
	}
	
	public TipoVendedor tipo() {//Complejidad ciclomatica: 0 + 1 = 1
		return tipo;
	}
	
	public String getDni() {//Complejidad ciclomatica: 0 + 1 = 1
		return dni;
	}
	
	@Override
	public boolean equals(Object obj) {//Complejidad ciclomatica: 1 + 1 = 2
		if (!(obj instanceof VendedorEnPlantilla)) //CC 1
			return false;
		VendedorEnPlantilla v = (VendedorEnPlantilla) obj;
		return (v.getId().equals(getId()) && v.getDni().equals(getDni()));
	}
}
