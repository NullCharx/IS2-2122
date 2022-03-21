package es.unican.is2.ImpuestoCirculacionBusiness;

import es.unican.is2.ImpuestoCirculacionIDAOs.*;
import es.unican.is2.ImpuestoCirculacionIntf.*;
import es.unican.is2.ImpuestoCirculacionCommon.Contribuyente;
import es.unican.is2.ImpuestoCirculacionCommon.OperacionNoValida;
import es.unican.is2.ImpuestoCirculacionCommon.Vehiculo;

/**
 * Clase que implementa la capa de negocio de la aplicacion
 */
public class GestionImpuestoCirculacion implements IGestionContribuyentes, IGestionVehiculos, IInfoImpuestoCirculacion {
	
	private IContribuyentesDAO contribuyentes;
	private IVehiculosDAO vehiculos;
	
	public GestionImpuestoCirculacion(IContribuyentesDAO contribuyentes, IVehiculosDAO vehiculos) {
		this.contribuyentes = contribuyentes;
		this.vehiculos = vehiculos;
	}
	
	/* Metodo auxiliar para buscar contribuyentes */
	private Contribuyente buscaContribuyente (String dni) {
		for (Contribuyente c: contribuyentes.contribuyentes()) {
			if (c.getDni().equals(dni)) {
				return c;
			}
		}
		return null;
	}
	
	/* Metodo auxiliar para buscar contribuyentes */
	private Vehiculo buscaVehiculo (String matricula) {
		for (Vehiculo v: vehiculos.vehiculos()) {
			if (v.getMatricula().equals(matricula)) {
				return v;
			}
		}
		return null;
	}
	
	public Contribuyente altaContribuyente(Contribuyente c) {
		Contribuyente cont = buscaContribuyente(c.getDni());
		if (cont != null) {
			contribuyentes.creaContribuyente(c);
			return c;
		}
		return null;
	}

	
	public Contribuyente bajaContribuyente(String dni) throws OperacionNoValida {
		Contribuyente c = buscaContribuyente(dni);
		
		if (c == null) {
			return c;
		} else {
			if (!c.getVehiculos().isEmpty()) {
				throw new OperacionNoValida("El contribuyente tiene vehiculos a su nombre");
			}
		}
		contribuyentes.eliminaContribuyente(c.getDni());
		return c;		
	 }
	
	public Contribuyente contribuyente(String dni) {
		return buscaContribuyente(dni);
	}

	public Vehiculo altaVehiculo(Vehiculo v, String dni) throws OperacionNoValida {
		Contribuyente c = buscaContribuyente(dni);
		Vehiculo veh = buscaVehiculo(v.getMatricula());
		if (c == null) {
			return null;
		}
		if (veh != null) {
			throw new OperacionNoValida("Este vehiculo ya existe");
		}
		vehiculos.creaVehiculo(v);
		c.getVehiculos().add(v);
		return v;
	}

	public Vehiculo bajaVehiculo(String matricula, String dni) throws OperacionNoValida {
		Contribuyente c = buscaContribuyente(dni);
		Vehiculo veh = buscaVehiculo(matricula);
		if (c == null || veh == null) {
			return null;
		}
		if (!c.getVehiculos().contains(veh)) {
			throw new OperacionNoValida("Este vehiculo no pertenece al contribuyente especificado");
		}
		vehiculos.eliminaVehiculo(matricula);
		c.getVehiculos().remove(veh);
		return veh;
	}

	public Vehiculo vehiculo(String matricula) {
		return buscaVehiculo(matricula);
	}	
}

