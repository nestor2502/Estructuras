package practica2;

/**
*
*
*
*/
public class Persona{

	 protected String nombre;
	 protected String tipo;
	 protected boolean vivo=true;
	 protected boolean protegido=false;
	 protected boolean encantado=false;

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
     
     /**
     *
     */
     public String getNombre(){

     	 return nombre;
     }


	 /**
	 *
	 */
	 public String getTipo(){

	 	 return tipo;
	 }
     

     /**
     *
     *
     */
     public void setProtegido(){

     	 protegido = true;
     }

     public void quitaProteccion(){
           protegido = false;
     }

     /**
     *
     *
     */
     public void setEncantado(){

     	 encantado=true;
     }
      
      public boolean getEncantado(){

          return encantado ;
      }


     /**
     *
     *
     */
     public void setMuerte(){

     	this.vivo=false    ;

     }

     public void setVida(){

          this.vivo=true;

     }

     /**
     *
     *
     */
     public boolean getMuerte(){
     	return vivo;
     }


 }