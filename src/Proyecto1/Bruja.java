package practica2;
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
	 public void usarPocion(String tipo){

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

	 public int pocionesDisponibles(){

	 	 int cont =0;
	 	 if(pocion_curativa==true){
	 		 cont++;
	 	 }
	 	 if(pocion_veneno==true){
	 		 cont++;
	 	 }

	 	 return cont;
	 }

	 public String pociones(){

	 	 String poc = " ";
         if(pocionesDisponibles()==2){
	 	     if(pocion_curativa==true){
	 		     poc+= "Pocion curativa y ";
	 	     }
	 	     if(pocion_veneno==true){
	 		     poc += " Veneno";
	 	     }
         }
         if(pocionesDisponibles()==1){
	 	     if(pocion_curativa==true){
	 		     poc+= "Pocion curativa";
	 	     }
	 	     if(pocion_veneno==true){
	 		     poc += "Veneno";
	 	     }
         }

         return poc;
	 }
}