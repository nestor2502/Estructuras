package practica2;

/**
*
*
*/
public class Cazador extends Persona{

     /**
     *Constructor
     *@param nombre
     *@param tipo
     */
	 public Cazador(String nombre, String tipo){
		  super(nombre, tipo);
	 }


     /**
     *Metodo para seleccionar que matara junto a el
     *@param nombre
     *@return nombre
     */
	 public String seleccionaVictima(String nombre){

		 return nombre;
	} 


}