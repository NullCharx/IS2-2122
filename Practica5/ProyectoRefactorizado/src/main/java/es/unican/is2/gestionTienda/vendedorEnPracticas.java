package es.unican.is2.gestionTienda;

//WMC: 3
//WMCn: 3/2 = 1,5
//AFF: 0
//EFF:0
//CBO (AFF U EFF): 0
//DIT: 1
//NOC: 0
//CCog: 1
public class vendedorEnPracticas extends Vendedor {

	
	/**
	 * Retorna un nuevo vendedor en prácticas
	 * @param nombre
	 * @param dni
	 */
	
	//Complejidad ciclomatica: 0 + 1 = 1
	//Complejidad cognitiva: 0
	public vendedorEnPracticas(String nombre, String id, String dni) {
		super(nombre, id, dni);
	}
	
	//Complejidad ciclomatica: 1 + 1 = 2
	//Complejidad cognitiva: 1
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof vendedorEnPracticas)) //CC 1, Ccog 1
			return false;
		Vendedor v = (Vendedor) obj;
		return (v.getId().equals(getId()) && v.getDni().equals(getDni()));
	}
}
