package practica2;

/**
*
*
*
*/
public class Noche{

 Lista <Persona> nocturnos = new Lista <Persona>();

public void agrega(){
	String va = "nestor";
	String ve = "Lobo"; 
 Persona l1 = new Persona(va, ve);

  nocturnos.agregaInicio(l1);
}


}