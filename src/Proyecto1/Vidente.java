package practica2;

/**
*
*
*
*/
public class Vidente extends Persona{

	 /**
	 *Constructor 
	 *@param nombre
	 *@param tipo
	 */
     public Vidente(String nombre, String tipo){

	     super(nombre, tipo);
     }

     public void observar(){

     	System.out.println("La vidente puede observar una carta");

     }
}