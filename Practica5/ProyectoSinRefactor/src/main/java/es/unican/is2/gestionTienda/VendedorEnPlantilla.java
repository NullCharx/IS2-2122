package es.unican.is2.gestionTienda;


//WMC: 5
//WMCn: 5/4 = 1,25
//AFF: 0
//EFF: 1 (TipoVendedor)
//CBO (AFF U EFF): 1
//DIT: 1
//NOC: 10
//Ccog: 1
public class VendedorEnPlantilla extends Vendedor {

	private TipoVendedor tipo;
	private String dni;
	
	/**
	 * Retorna un nuevo vendedor en plantilla del tipo que se indica
	 * @param nombre
	 * @param dni
	 * @param tipo
	 */
	
	//Complejidad ciclomatica: 0 + 1 = 1
	//Complejidad cognitiva: 0
	public VendedorEnPlantilla(String nombre, String id, String dni, TipoVendedor tipo) {
		super(nombre, id);
		this.tipo = tipo;
		this.dni=dni;
	}
	
	//Complejidad ciclomatica: 0 + 1 = 1
	//Complejidad cognitiva: 0
	public TipoVendedor tipo() {
		return tipo;
	}
	
	//Complejidad ciclomatica: 0 + 1 = 1
	//Complejidad cognitiva: 0
	public String getDni() {
		return dni;
	}
	
	//Complejidad ciclomatica: 1 + 1 = 2
	//Complejidad cognitiva: 1
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof VendedorEnPlantilla)) //CC 1, CCog 1
			return false;
		VendedorEnPlantilla v = (VendedorEnPlantilla) obj;
		return (v.getId().equals(getId()) && v.getDni().equals(getDni()));
	}
}
