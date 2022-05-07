package es.unican.is2.gestionTienda;


//WMC: 4
//WMCn: 4/3 = 1,33
//AFF: 0
//EFF: 1 (TipoVendedor)
//CBO (AFF U EFF): 0s
//DIT: 1
//NOC: 0
//Ccog: 1
public class VendedorEnPlantilla extends Vendedor {

	private TipoVendedor tipoVendedor;//Refactorizado desde "tipo"
	/**
	 * Retorna un nuevo vendedor en plantilla del tipo que se indica
	 * @param nombre
	 * @param dni
	 * @param tipo
	 */
	
	//Complejidad ciclomatica: 0 + 1 = 1
	//Complejidad cognitiva: 0
	public VendedorEnPlantilla(String nombre, String id, String dni, TipoVendedor tipo) {
		super(nombre, id, dni);
		this.tipoVendedor = tipo;
	}
	
	//Complejidad ciclomatica: 0 + 1 = 1
	//Complejidad cognitiva: 0
	public TipoVendedor tipo() { 
		return tipoVendedor;
	}
	
	//Complejidad ciclomatica: 1 + 1 = 2
	//Complejidad cognitiva: 1
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof VendedorEnPlantilla)) //CC 1, CCog 1
			return false;
		Vendedor v = (Vendedor) obj;
		return (v.getId().equals(getId()) && v.getDni().equals(getDni()));
	}
}
