package Proyecto1;


/**
*
*
*
*/
public class Persona{

	 protected String nombre;
	 protected String tipo;
	 protected boolean vivo;
	 protected boolean protegido;
	 protected boolean encantado;

	 /**
	 *Constructor
	 *@param nombre
	 */
	 public Persona(String nombre){

		 this.tipo   = tipo;
	 }


	 /**
	 *Constructor
	 *@param nombre
	 *@param tipo
	 */
	 public Persona(String nombre, String tipo){
 
		 this.tipo   = tipo;
		 this.nombre = nombre;
	 }

     
     /**
     *Metodo que selecciona al posible lobo
     *@param sospechoso
     *@return sospechos
     */
	 public String seleccionarLobo(String sospechoso){

		 return sospechoso;
	 } 


 }