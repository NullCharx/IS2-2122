package ImpuestoCirculacionCommon;

import java.io.Serializable;
import java.time.LocalDate;
@SuppressWarnings("serial")
public class Furgoneta
    extends Turismo implements Serializable
{
    
    private double potencia;
    private boolean comercial;
    
   public Furgoneta(String matricula, LocalDate fechaMatriculacion, double potencia, boolean comercial) {
		super(matricula,fechaMatriculacion,potencia);
		this.comercial = comercial;
	}

/**
    * Retorna el valor del atributo comercial
    * @return true si la furgoneta es de uso comercial
    *         false si no es de uso comercial
    */
    public boolean getComercial() {
    	return comercial;
    }
    
    /**
	 * Retorna la potencia de la furgoneta
	 * @return potencia en caballos fiscales
	 */
    public double getPotencia() {
        return potencia;
    }
    
  
	@Override
    public double precioImpuesto() {
    	double precio = super.precioImpuesto();
    	if (comercial) {
    		precio -= precio*0.2;
    	}
		return precio;
    }
}
