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
	  	 aldeanosVivos=usa.aldeanosVivos();
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
         System.out.println();
	  	 while(j==0){

	  	 	 if(numeroDia>0){
	  	 	 System.out.println("Se hace de noche");
             System.out.println("La aldea duerme");
             System.out.println("Los jugadores cierran los ojos");
             System.out.println();
             System.out.println("Presione cualquier tecla para continuar");
             String continua2 = sc.next();
             System.out.println();
	  	 	 }
	  	 System.out.println();
         System.out.println();
	  	 System.out.println("Noche: "+(numeroDia+1));
	  	 System.out.println();
         System.out.println();
         System.out.println();
	  	 usa.iniciaNoche();
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
}}