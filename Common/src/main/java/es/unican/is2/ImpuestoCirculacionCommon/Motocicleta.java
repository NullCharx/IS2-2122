package es.unican.is2.ImpuestoCirculacionCommon;

import java.time.LocalDate;

@SuppressWarnings("serial")
public class Motocicleta extends Vehiculo
{
	private int cilindrada;

    public Motocicleta(String matricula, LocalDate fechaMatriculacion, int cilindrada) throws DatoInvalido, NullPointerException {
		super(matricula,fechaMatriculacion);
		if (cilindrada <= 0) {
	    	throw new DatoInvalido("Cilindrada menor o igual que 0");
	    }
		this.cilindrada = cilindrada;
	}


	/**
     * Retorna la cilindrada de la motocicleta
     * @return cilindrada
     */
    public int getCilindrada() {
        return cilindrada;
    }
    
  
	@Override
    public double precioImpuesto() {
		double precio = 0;
		if (this.getFechaMatriculacion().compareTo(LocalDate.now().minusYears(25)) < 0) {
			System.out.println("El vehículo tiene más de 25 años, no se requiere pagar impuestos");
		} else if (cilindrada < 125) {
			precio = 8.84;
			System.out.println("Menos de 125 cc, el precio a pagar es de: "+ precio);
		} else if (cilindrada < 250) {
			precio = 15.14;
			System.out.println("Entre 125 y 250 cc, el precio a pagar es de: "+ precio);
		} else if (cilindrada < 500) {
			precio = 30.30;
			System.out.println("Entre 250 y 500 cc, el precio a pagar es de: "+ precio);
		} else if (cilindrada < 1000) {
			precio = 60.58;
			System.out.println("Entre 500 y 1000 cc, el precio a pagar es de: "+ precio);
		} else {
			precio = 121.16;
			System.out.println("Más de 20 CF, el precio a pagar es de: "+ precio);
		}
		return precio;
    }
}
