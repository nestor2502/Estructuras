package practica2;
import java.util.Scanner;

public class UsaJuego{

	  public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        //System.out.println("Ingresa el numero de personas que jugaran: ");
        System.out.println();

	  	Juego usa = new Juego();
	  	usa.asignaJugadores();
	  	usa.mostrarPersonajes();
	  }
}