package practica2;

import java.util.Scanner;
import java.util.Iterator;

public class Juego{ 
      

     int dia;
     int numeroJugadores;
     String [] jugadores;
     int numeroLobos;
     int numeroAldeanos;
     int numeroEncantados;
     Lista <Persona> players = new Lista <Persona>();
     Lista <Persona> nocturnos;
     Lista <Persona> aldeanos;
     Jugadores personajes;
     Scanner sc= new Scanner(System.in);

     /**
     public Juego(int numeroJugadores){
     	this.numeroJugadores=numeroJugadores;
     	jugadores = new String [numeroJugadores];


     }*/

     public void asignaJugadores(){

     	System.out.println("¿Cuantos jugadores son?");
     	System.out.println("Nota: minimo 14 jugadores, maximo: 30");
     	this.numeroJugadores = sc.nextInt();
     	this.jugadores = new String[this.numeroJugadores];
     	System.out.println();
     	System.out.println();
        for(int i =0 ; i < numeroJugadores; i++){
     	     System.out.println("ingresa al jugador "+(i+1));
     	     this.jugadores[i]=sc.next();
          }
         //se inicia clase jugadores
         this.personajes = new Jugadores(this.jugadores);
         //metodo de clase Jugadores que devuelve una lista que seran los nocturnos
         nocturnos = personajes.asignarPersonajesSup();
         //Metodo que regresa una lista con los aldeanos
         aldeanos = personajes.asignarAldeano();
         //Se inicia noche y se recibe una lista con jugadores
         Noche nocheVar = new Noche(nocturnos); 

     }


     public void mostrarPersonajes(){

     	   Iterator <Persona> it  = nocturnos.iterator();
     	   Iterator <Persona> it2 = aldeanos.iterator();

     	   System.out.println("Lista de jugadores con su repectivo personaje:");
     	   System.out.println();
           int long1=nocturnos.getLongitud();
           int long2=aldeanos.getLongitud();

           for(int i=0; i<long1; i++){
           	Persona p1 = it.next();
           	System.out.println(p1.getTipo()+" : "+p1.getNombre());
           }
           for(int j=0; j<long1; j++){
           	Persona p2 = it2.next();
           	System.out.println(p2.getTipo()+" : "+p2.getNombre());
           }

           
    


     }



}