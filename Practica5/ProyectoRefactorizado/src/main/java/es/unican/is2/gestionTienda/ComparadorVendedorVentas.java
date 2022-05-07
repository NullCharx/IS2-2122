package es.unican.is2.gestionTienda;

import java.util.Comparator;

//WMC: 3
//WMCn: 3/1 = 3
//AFF: 1 (GestionComisiones)
//EFF: 1 (Vendedor)
//CBO (AFF U EFF): 2
//DIT: 0
//NOC: 0
//Ccog: 2
public class ComparadorVendedorVentas implements Comparator<Vendedor>  {
	
	
	//No se puede reactorizar de manera facil debiodo a que
	// Complejidad Cicloamtica 1 + 1 + 1 = 3
	//Complejidad cognitiva: 
	public int compare(Vendedor o1, Vendedor o2) {
		if (o1.getTotalVentas()>o2.getTotalVentas())//CC 1, Ccog 1
			return -1;
		else if (o1.getTotalVentas()<o2.getTotalVentas())//CC1, Ccog 1
			return 1;
		return 0;
	}
	
}