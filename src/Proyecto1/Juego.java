package practica2;
import practica2.Jugadores;

import java.util.Scanner;
import java.util.Iterator;

public class Juego{ 
      

     int dia;
     //total de jugadores
     int numeroJugadores;
     //nombre de los jugadores
     String [] jugadores;
     int numeroLobos;
     int numeroAldeanos;
     int numeroEncantados;
     //persona protegida
     Persona proteg;
     // persona caso 1
     Persona per;
     //persona que mataron lobos
     Persona per2;
     //persona en caso de uso de pocion primera per
     Persona per3;
     //persona en caso de uso de pocion segunda per
     Persona per4;
     Lista <Persona> players = new Lista <Persona>();
     Lista <Persona> nocturnos
;     Lista <Persona> aldeanos;
     //clase que asigna roll en el juego
     Jugadores personajes;
     Noche nocheVar;
     Scanner sc= new Scanner(System.in);
     



     /**
     public Juego(int numeroJugadores){
     	this.numeroJugadores=numeroJugadores;
     	jugadores = new String [numeroJugadores];


     }*/

     public void asignaJugadores(){

     	System.out.println("¿Cuantos jugadores son?");
     	System.out.println("Nota: minimo 14 jugadores, maximo: 30");
     	numeroJugadores = sc.nextInt();

     	jugadores = new String[numeroJugadores];
     	System.out.println();
     	System.out.println();
     	//Pide el nombre de los jugadores y llena el arreglo de "jugadores"
        for(int i =0 ; i < numeroJugadores; i++){
     	     System.out.println("ingresa al jugador "+(i+1));
     	     jugadores[i]=sc.next();
          }
         //se inicia clase jugadores con arreglo de nombres
         personajes = new Jugadores(jugadores);
          
          for(int i =0; i< jugadores.length; i++){

          	System.out.println(jugadores[i]);
          }
         //metodo de clase Jugadores que devuelve una lista que seran los nocturnos
          nocturnos = personajes.asignarPersonajesSup();

         //Metodo que regresa una lista con los aldeanos
         aldeanos = personajes.asignarAldeano();

         //Se inicia noche y se recibe una lista con jugadores
         nocheVar = new Noche(nocturnos); 

     }

     /**
     *Metodo que muestra los personajes seleccionados para cada jugador
     */
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
           for(int j=0; j<long1-1; j++){
           	Persona p2 = it2.next();
           	System.out.println(p2.getTipo()+" : "+p2.getNombre());
           }
     }
      /**
      *Metodo que llama a todos los personajes nocturnos
      */
     public void iniciaNoche(){


       if(personajes.vidente.getMuerte()== true){
        System.out.println();
        System.out.println("Despierta la vidente");
        System.out.println();
          nocheVar.espiar();
          System.out.println();
          System.out.println("se duerme la vidente");
       }

       if(personajes.protector.getMuerte ()== true){
          System.out.println("lobos vivos: "+nocheVar.lobosVivos());
          System.out.println("Despierta la bruja");
          System.out.println();
          System.out.println("¿A quien quieres proteger?");
          System.out.println();
          String prot = sc.next();
          String protegido = nocheVar.proteger(prot);
           per = itera(protegido);
          
                   per.setProtegido();
                   proteg = per;
           }

        

       if(nocheVar.lobosVivos() > 0){
        System.out.println();
        System.out.println("Despiertan lobos");
        System.out.println();
           System.out.println("a quien decicieron matar?");
           String victi = sc.next();
           System.out.println();
           String guardar1 = nocheVar.lobosMatar(victi);
            per2 = itera(guardar1);
             per2.setMuerte();
         }

        if(personajes.bruja.getMuerte() == true){

           if(personajes.bruja.pocionesDisponibles()==0){
             System.out.println("la bruja ya no tiene pociones");
           }

          if(personajes.bruja.pocionesDisponibles()==1 ){
             System.out.println(" tienes disponible" + personajes.bruja.pociones());
             System.out.println();
             System.out.println("lo quieres usar?");
             System.out.println();
             System.out.println("1)si      2) no");
             System.out.println();
             int opc = sc.nextInt();
             if (opc == 1 && personajes.bruja.pocion_curativa==true){
                    System.out.println("¿A quien quieres revivir?");
                    System.out.println();
                    String suertudo = sc.next();
                    String revive=personajes.bruja.revivir(suertudo);
                    per3 = itera(revive);
                    per3.setVida();
             }
             else  if (opc == 1 && personajes.bruja.pocion_veneno==true){
                    System.out.println("¿A quien quieres matar?");
                    System.out.println();
                    String morira = sc.next();
                    String revive=personajes.bruja.matar(morira);
                    per3 = itera(revive);
                    per3.setMuerte();
             }

            
                    
             }

          if(personajes.bruja.pocionesDisponibles()==2){

               System.out.println("tienes disponibles"+ personajes.bruja.pociones()+" ¿quieres usar ambas?");
               System.out.println();
               System.out.println("1)si      2) no");
               System.out.println();
               int opc = sc.nextInt();
              if (opc ==1){
             
                    System.out.println("¿A quien quieres revivir?");
                    String suertudo = sc.next();
                    String revive = personajes.bruja.revivir(suertudo);
                    per3 = itera(revive);
                    per3.setVida();
            
   
                    System.out.println("¿A quien quieres matar?");
                    String morira = sc.next();
                    String morira2= personajes.bruja.matar(morira);
                    per4 = itera(morira2);
                    per4.setMuerte();
     

             }

               if(opc ==2){
                    System.out.println("cual quieres usar?");
                    System.out.println();
                    System.out.println("1) Poción curativa      2) Veneno");
                    System.out.println();
                    int opc2 = sc.nextInt();
                    if (opc2 == 1){
                        System.out.println("¿A quien quieres revivir?");
                        String suertudo = sc.next();
                        String revive = personajes.bruja.revivir(suertudo);
                        per3 = itera(revive);
                        per3.setVida();
                     }
                    else  if (opc2 == 2){
                    System.out.println("¿A quien quieres matar?");
                    String morira = sc.next();
                    String revive=personajes.bruja.matar(morira);
                    per3= itera(revive);
                    per3.setMuerte();
            }


             }

   
       }

        }



     }

     public Persona itera(String nombre ){
         Persona prueba = new Persona("no se", "encuantra");
         Iterator <Persona> it1  = nocturnos.iterator();
         Iterator <Persona> it2 = aldeanos.iterator();

      for(int i = 0;i< nocturnos.getLongitud(); i++){
               prueba = it1.next();
               if(prueba.getNombre()==nombre){
                return prueba;
               }
           }

           for(int i = 0;i< aldeanos.getLongitud(); i++){
             
              prueba = it2.next();
                if(prueba.getNombre()==nombre){
             return prueba;
           }
     }
     
     return prueba;

}
}