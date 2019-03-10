package Proyecto1;

/**
*
*
*
*/
public class Bruja extends Persona{

	 boolean pocion_curativa= true;
	 boolean pocion_veneno= true;

	 /**
	 *Constructor
	 *@param nombre
	 */
	 public Bruja(String nombre, String tipo){
	 	 super(nombre, tipo);
	 }

	 /**
	 *Pocion que cambia de disponibilidad una pocion
	 *@param tipo
	 */
	 private void usarPocion(String tipo){

	 	 if(tipo.equals("curativa")){
	 	 	pocion_curativa= false;
	 	 }

	 	 if(tipo.equals("veneno")){

	 	 	pocion_veneno=false;
	 	 }
	 }
     
     /**
     *Metodo que usa la pocion veneno para matar una persona
     *@param nombre 
     *@return nombre
     */
	 public String matar(String nombre){

	     String veneno = "veneno";

	     usarPocion(veneno);

	     return nombre; 

	 }
     
      /**
     *Metodo que usa la pocion curativa parea revivir una persona
     *@param nombre 
     *@return nombre
     */
	 public String revivir(String nombre){

	 	 String curativa = "curativa";

	     usarPocion(curativa);

	     return nombre; 

	 }
}