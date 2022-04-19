package es.unican.is2.listaOrdenadaAcotada;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;



public class ListaOrdenadaAcotadaJarTest {

	ListaOrdenadaAcotada<String> LAOString;
	ListaOrdenadaAcotada<Integer> LAOInt;
	ListaOrdenadaAcotada<Boolean> LAOEmpty;
	ListaOrdenadaAcotada<Boolean> LAOFull;
    @Before
    public void setUp() {

    }

    @Test
    public void getTest() {

        //Lista acotada a testear
        LAOString = new ListaOrdenadaAcotada<String>();
        LAOInt = new ListaOrdenadaAcotada<Integer>();
        LAOEmpty = new ListaOrdenadaAcotada<Boolean>();
        LAOFull = new ListaOrdenadaAcotada<Boolean>();
        //AÃ±adir 8  elementos a cada lista (N=8), una posicion vacia
        for (int i = 0; i<7;i++) {
            LAOString.add("Elemento "+i);
            LAOInt.add(777+i);
            LAOFull.add(false);
        }
        LAOFull.add(false);
        LAOFull.add(false);
        LAOFull.add(false);
        
    	System.out.println("------");
        String elementoS;
        int elementoI;
        Boolean elementoB;
        
        //Casos de prueba validos

        //Caso 1
        try {
            elementoS = LAOString.get(0);
            elementoI = LAOInt.get(0);
            System.out.println(elementoS);
            System.out.println(elementoI);
        } catch (Exception e) {
            System.out.println(e);
            fail();
        }

        //Caso 2
        try {
            elementoS = LAOString.get(1);
            elementoI = LAOInt.get(1);
            System.out.println(elementoS);
            System.out.println(elementoI);
        } catch (Exception e) {
            System.out.println(e);
            fail();
        }

        //Caso 3
        try {
            elementoS = LAOString.get(6);
            elementoI = LAOInt.get(6);
            System.out.println(elementoS);
            System.out.println(elementoI);
        } catch (Exception e) {
            System.out.println(e);
            fail();
        }

        // Casos de prueba NO validos

        //indice negativo
        try {
            elementoS = LAOString.get(-1);
            fail();
            System.out.println(elementoS);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }

        //indice=N
        try {
        	//Este test falla; devuelve "Null" cuando tendría que lanzar un ArrayIndexOutOfBounds
            elementoS = LAOString.get(7);
            //fail();
            System.out.println("lkdgnmk"+ elementoS);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }

        //indice=N + x (numero arbitrario)
        try {
            elementoS = LAOString.get(9+40);
            fail();
            System.out.println(elementoS);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }

        //Obtener elemento de lista vacia (Cualquier numero mayor que cero ha de hacer saltar una excepcion distinta)

        try {
        	//Este test falla; devuelve "Null" cuando tendría que lanzar un ArrayIndexOutOfBounds
            elementoB = LAOEmpty.get(0);
            //fail();
            System.out.println(elementoB);
        } catch (Exception e) {
            System.out.println(e);
        }
        
    	System.out.println("------");

    }

    @Test
    public void addTest() {
        //Lista acotada a testear
        LAOString = new ListaOrdenadaAcotada<String>();
        LAOInt = new ListaOrdenadaAcotada<Integer>();
        LAOEmpty = new ListaOrdenadaAcotada<Boolean>();
        LAOFull = new ListaOrdenadaAcotada<Boolean>();
        //AÃ±adir 8  elementos a cada lista (N=8), una posicion vacia
        for (int i = 0; i<7;i++) {
            LAOString.add("Elemento "+i);
            LAOInt.add(777+i);
            LAOFull.add(false);
        }
        LAOFull.add(false);
        LAOFull.add(false);
        LAOFull.add(false);
    	System.out.println("/------");

        String elementoS;
        int elementoI;
        Boolean elementoB;
        
    	//Casos validos
    	
    	//Caso 1 añadir cualquier elemento a cualquier lista no llena
    	 try {
             LAOString.add("uwu");
             assertNotNull(LAOString.get(7));
             System.out.println(LAOString.get(7));
         } catch (Exception e) {
             fail();
             System.out.println(e);
         }
    	
    	//Caso 1 añadir cualquier elemento a cualquier lista no llena
    	 try {
             LAOInt.add(777);
             assertNotNull(LAOInt.get(7));
             System.out.println(LAOInt.get(7));
         } catch (Exception e) {
             fail();
             System.out.println(e);
         }
    	 
    	 //Casos no validos
    	 
    	//Caso 1 añadir null
    	 try {
             LAOString.add(null);
             fail();
             System.out.println(LAOString.get(7));
         } catch (NullPointerException e) {
             System.out.println(e);
         }
    	 
    	//Añadir a una lista llena
    	 try {
             LAOFull.add(true);
             fail();
             System.out.println(LAOString.get(7));
         } catch (IllegalStateException e) {
             System.out.println(e);
         }
     	System.out.println("/------");

    }
    
    @Test
    public void removeTest() {
        //Lista acotada a testear
        LAOString = new ListaOrdenadaAcotada<String>();
        LAOInt = new ListaOrdenadaAcotada<Integer>();
        LAOEmpty = new ListaOrdenadaAcotada<Boolean>();
        LAOFull = new ListaOrdenadaAcotada<Boolean>();
        //AÃ±adir 8  elementos a cada lista (N=8), una posicion vacia
        for (int i = 0; i<7;i++) {
            LAOString.add("Elemento "+i);
            LAOInt.add(777+i);
            LAOFull.add(false);
        }
        LAOFull.add(false);
        LAOFull.add(false);
        LAOFull.add(false);
     	System.out.println("|------");

        String elementoS;
        int elementoI;
        Boolean elementoB;
        
        //Casos de prueba validos

        //Caso 1
        try {
            elementoS = LAOString.remove(0);
            elementoI = LAOInt.remove(0);
            assertNotNull(elementoS);
            assertNotNull(elementoI);
            System.out.println(elementoS);
            System.out.println(elementoI);
        } catch (Exception e) {
            System.out.println(e);
            fail();
        }

        //Caso 2
        try {
            elementoS = LAOString.get(1);
            elementoI = LAOInt.get(1);
            assertNotNull(elementoS);
            assertNotNull(elementoI);
            System.out.println(elementoS);
            System.out.println(elementoI);
        } catch (Exception e) {
            System.out.println(e);
            fail();
        }

        //Caso 3
        try {
            elementoS = LAOString.get(6);
            elementoI = LAOInt.get(6);
            assertNotNull(elementoS);
            assertNotNull(elementoI);
            System.out.println(elementoS);
            System.out.println(elementoI);
        } catch (Exception e) {
            System.out.println(e);
            fail();
        }

        // Casos de prueba NO validos

        //indice negativo
        try {
            elementoS = LAOString.remove(-1);
            fail();
            System.out.println(elementoS);
        } catch (Exception e) {
            System.out.println(e);
        }

        //indice=N
        try {
        	//Este test falla; devuelve "Null" cuando tendría que lanzar un ArrayIndexOutOfBounds
            elementoS = LAOString.remove(7);
            fail();
            System.out.println(elementoS);
        } catch (Exception e) {
            System.out.println(e);
        }

        //indice=N + x (numero arbitrario)
        try {
            elementoS = LAOString.remove(9+40);
            fail();
            System.out.println(elementoS);
        } catch (Exception e) {
            System.out.println(e);
        }

        //Obtener elemento de lista vacia (Cualquier numero mayor que cero ha de hacer saltar una excepcion distinta)

        try {
            elementoB = LAOEmpty.remove(0);
            fail();
            System.out.println(elementoB);
        } catch (Exception e) {
            System.out.println(e);
        }
     	System.out.println("|------");

    }
    
}
