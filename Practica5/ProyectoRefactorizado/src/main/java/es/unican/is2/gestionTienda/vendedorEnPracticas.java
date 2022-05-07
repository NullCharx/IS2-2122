package es.unican.is2.gestionTienda;

//WMC: 4
//WMCn: 4/3 = 1,3
//AFF: 0
//EFF:0
//CBO (AFF U EFF): 0
//DIT: 1
//NOC: 0
//CCog: 1
public class vendedorEnPracticas extends Vendedor {

	
	private String dni;
	
	/**
	 * Retorna un nuevo vendedor en prácticas
	 * @param nombre
	 * @param dni
	 */
	
	//Complejidad ciclomatica: 0 + 1 = 1
	//Complejidad cognitiva: 0
	public vendedorEnPracticas(String nombre, String id, String dni) {
		super(nombre, id);
		this.dni= dni;
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
		if (!(obj instanceof vendedorEnPracticas)) //CC 1, Ccog 1
			return false;
		vendedorEnPracticas v = (vendedorEnPracticas) obj;
		return (v.getId().equals(getId()) && v.getDni().equals(getDni()));
	}
}
