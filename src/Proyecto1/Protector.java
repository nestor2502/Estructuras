package practica2;

/**
*
*
*/
public class Protector extends Persona {

	 /**
	 *Constructor
	 *@param nombre
	 *@param tipo
	 */
	 public Protector(String nombre, String tipo){
          super(nombre, tipo);

	 }


	 /**
	 *Metodo que selecciona una pesona y lo protege
	 *
	 */
	 public String seleccionaProtegido(String nombre){

	 	 return nombre;
	 }


}