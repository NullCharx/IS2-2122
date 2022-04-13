package es.unican.is2.ImpuestoCirculacionCommon;

import java.time.LocalDate;

@SuppressWarnings("serial")
public class Motocicleta extends Vehiculo
{
	private int cilindrada;

    public Motocicleta(String matricula, LocalDate fechaMatriculacion, int cilindrada) {
		super(matricula,fechaMatriculacion);
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
			System.out.println("Menos de 8 CF, el precio a pagar es de: "+ precio);
		} else if (125 <= cilindrada && cilindrada < 250) {
			precio = 15.14;
			System.out.println("Entre 8 y 11.99 CF, el precio a pagar es de: "+ precio);
		} else if (250 <= cilindrada && cilindrada < 500) {
			precio = 30.30;
			System.out.println("Entre 12 y 15.99 CF, el precio a pagar es de: "+ precio);
		} else if (500 <= cilindrada && cilindrada < 1000) {
			precio = 60.58;
			System.out.println("Entre 16 y 19.99 CF, el precio a pagar es de: "+ precio);
		} else {
			precio = 121.16;
			System.out.println("Más de 20 CF, el precio a pagar es de: "+ precio);
		}
		return 0;
    }
}
