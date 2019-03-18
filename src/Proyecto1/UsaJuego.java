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
         System.out.println("                LOBOS DE CASTRONEGRO");
         System.out.println();
         System.out.println();
         System.out.println();
	  	 Juego usa = new Juego();
	  	 totalJugadores = usa.numJuga();
	  	 usa.asignaJugadores();
	  	 usa.mostrarPersonajes();
	  	 aldeanosVivos=usa.aldeanosVivos();
	  	 lobosVivos  = usa.lobosVi();
	  	 personasEncantadas= usa.encantados();
	  	 while(j==0){
	  	 System.out.println();
         System.out.println();
	  	 System.out.println("Dia: "+(numeroDia+1));
	  	 System.out.println();
         System.out.println();
         System.out.println();
	  	 usa.iniciaNoche();
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