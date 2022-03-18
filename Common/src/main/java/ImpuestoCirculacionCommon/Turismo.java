package ImpuestoCirculacionCommon;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Turismo
    extends Vehiculo implements Serializable
{

	private double potencia;
	
	/**
	 * Retorna la potencia del turismo
	 * @return potencia en caballos fiscales
	 */
    public double getPotencia() {
        return potencia;
    }
       
    
    /**
     * Retorna el precio del impuesto a pagar
     *  @return precio
     */
	@Override
    public double precioImpuesto() {
		double precio = 0;
		if (this.getFechaMatriculacion().compareTo(LocalDate.now().minusYears(25)) < 0) {
			System.out.println("El vehículo tiene más de 25 años, no se requiere pagar impuestos");
		} else if (potencia < 8.00) {
			precio = 25.24;
			System.out.println("Menos de 8 CF, el precio a pagar es de: "+ precio);
		} else if (8.0 <= potencia && potencia < 12.0) {
			precio = 68.16;
			System.out.println("Entre 8 y 11.99 CF, el precio a pagar es de: "+ precio);
		} else if (12.0 <= potencia && potencia < 16.0) {
			precio = 143.88;
			System.out.println("Entre 12 y 15.99 CF, el precio a pagar es de: "+ precio);
		} else if (16.0 <= potencia && potencia < 19.99) {
			precio = 179.22;
			System.out.println("Entre 16 y 19.99 CF, el precio a pagar es de: "+ precio);
		} else {
			precio = 224.00;
			System.out.println("Más de 20 CF, el precio a pagar es de: "+ precio);
		}
    	return precio;
    }
    
}
