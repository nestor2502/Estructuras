package practica2;
import java.util.Scanner;

public class UsaJuego{



	  public static void main(String [] args){
	  	 int aldeanosVivos;
	  	 int lobosVivos;
	  	 int personasEncantadas;
	  	 int totalJugadores;
	  	 int numeroDia=0;
	  	 int j =0;
         Scanner sc = new Scanner(System.in);
         


         limpiarPantalla();
         System.out.println();
         System.out.println("          LOBOS DE CASTRONEGRO");
         System.out.println();
         System.out.println();
         System.out.println();
	  	 Juego usa = new Juego();
	  	 totalJugadores = usa.numJuga();
	  	 usa.asignaJugadores();
	  	 usa.mostrarPersonajes();
	  	 System.out.println("Presione cualquier tecla para continuar");
         String continuar = sc.next();
         limpiarPantalla();
	  	 aldeanosVivos=usa.aldeanosVivos();
	  	 limpiarPantalla();
	  	 lobosVivos  = usa.lobosVi();
	  	 personasEncantadas= usa.encantados();
	  	 System.out.println();
         System.out.println("Dia: "+(numeroDia+1));
         System.out.println();
         System.out.println();
         System.out.println("Se hace de noche");
         System.out.println("La aldea duerme");
         System.out.println("Los jugadores cierran los ojos");
         System.out.println();
         System.out.println("Presione cualquier tecla para continuar");
         String continua = sc.next();
         limpiarPantalla();
         System.out.println();
	  	 while(j==0){

	  	 	 if(numeroDia>0){
	  	 	 System.out.println("Se hace de noche");
             System.out.println("La aldea duerme");
             System.out.println("Los jugadores cierran los ojos");
             System.out.println();
             System.out.println("Presione cualquier tecla para continuar");
             String continua2 = sc.next();
             limpiarPantalla();
             System.out.println();
	  	 	 }
	  	 System.out.println();
         System.out.println();
	  	 System.out.println("Noche: "+(numeroDia+1));
	  	 System.out.println();
         System.out.println();
         System.out.println();
	  	 usa.iniciaNoche();
	  	 limpiarPantalla();
	  	 System.out.println();
         System.out.println();
	  	 System.out.println("Dia: "+(numeroDia+2));
	  	 System.out.println();
         System.out.println();
	  	 usa.iniciaDia();
	  	 numeroDia++;
         if(aldeanosVivos==0){
         	j++;
         }
         else if(usa.lobosVi()==0){
         	j++;
         }
         else if(personasEncantadas==(totalJugadores-1)){
         	j++;
         }
	  	 
	   }
         System.out.println();
         System.out.println();
         System.out.println();
         System.out.println();
	   if(aldeanosVivos==0){
	   	    limpiarPantalla();
         	System.out.println("Lamentablemente todos los aldeanos murieron :c");
         }
         else if(usa.lobosVi()==0){
         	limpiarPantalla();
         	System.out.println("¡Felicidades mataron a todos los lobos!");
         }
         else if(personasEncantadas==(totalJugadores-1)){
         	limpiarPantalla();
         	System.out.println("El flautista hizo de las suyas y encanto a todos");
         }
         System.out.println();
         System.out.println();
         System.out.println();
         System.out.println("FIN DEL JUEGO");
  

}
public static void limpiarPantalla(){
		System.out.print("\033[H\033[2J");
		System.out.flush();
} 
}
