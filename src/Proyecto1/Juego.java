package practica2;
import practica2.Jugadores;

import java.util.Scanner;
import java.util.Iterator;

/**
*Clase que contiene la logica del juego
*/
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
     // persona protegida
     Persona per;
     //persona que mataron lobos
     Persona per2;
     //persona en caso de uso de pocion primera per
     Persona per3;
     //persona en caso de uso de pocion segunda per
     Persona per4;
     //arreglo con el nombre de muertos
     Lista <String>  muer; 
     Lista <String> muertos = new Lista <String>();
     Lista <Persona> nocturnos
;     Lista <Persona> aldeanos;
     //clase que asigna roll en el juego
     Jugadores personajes;
     Noche nocheVar;
     Dia diaVar;
     Scanner sc= new Scanner(System.in);
      
     /**
     *Metodo que inicia el juego y asigna personajes a cada jugador
     *
     */
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
          
         //metodo de clase Jugadores que devuelve una lista que seran los nocturnos
          nocturnos = personajes.asignarPersonajesSup();

         //Metodo que regresa una lista con los aldeanos
         aldeanos = personajes.asignarAldeano();

         //Se inicia noche y se recibe una lista con jugadores
         nocheVar = new Noche(nocturnos); 
         diaVar = new Dia(nocturnos, aldeanos);

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
            if(p1.getMuerte()==true)
           	System.out.println(p1.getTipo()+" : "+p1.getNombre());
           }
           for(int j=0; j<long1-1; j++){
           	Persona p2 = it2.next();
            if(p2.getMuerte()==true)
           	System.out.println(p2.getTipo()+" : "+p2.getNombre());
           }
     }

       /**
     *Metodo que muestra los personajes seleccionados para cada jugador
     */
     public void mostrarPersonajesVivos(){

         Iterator <Persona> it  = nocturnos.iterator();
         Iterator <Persona> it2 = aldeanos.iterator();
         System.out.println();
          System.out.println();
         System.out.println("Lista de jugadores vivos");
         System.out.println();
           int long1=nocturnos.getLongitud();
           int long2=aldeanos.getLongitud();

           for(int i=0; i<long1; i++){
            Persona p1 = it.next();
            if(p1.getMuerte()==true)
            System.out.println(p1.getNombre());
           }
           for(int j=0; j<long1-1; j++){
            Persona p2 = it2.next();
            if(p2.getMuerte()==true)
            System.out.println(p2.getNombre());
           }
     }

       /**
       *Metodo que devuelve el total de jugadores al comienzo de una partida
       */
       public int numJuga(){

          return numeroJugadores;
       }
      /**
      *Metodo que llama a todos los personajes nocturnos ademas de sus metodos
      */
     public void iniciaNoche(){

         if(muertos.getLongitud()>0){

             muertos.limpia();
         }

        if(muertos.getLongitud()>0){
          System.out.println();
        }
       if(personajes.vidente.getMuerte()== true){
        System.out.println();
        System.out.println("Despierta la vidente");
        System.out.println();
          nocheVar.espiar();
          System.out.println();
          System.out.println();
          System.out.println("Selecciona cualquier letra para continuar");
          String seleccion7 = sc.next();
          System.out.println();
          System.out.println();
          System.out.println("se duerme la vidente");
          System.out.println();
          System.out.println("Selecciona cualquier letra para continuar");
          String seleccion1 = sc.next();
          System.out.println();
       }

       if(personajes.protector.getMuerte ()== true){
          //System.out.println("lobos vivos: "+nocheVar.lobosVivos());
          System.out.println();
          System.out.println("Despierta el protector");
          System.out.println();
          System.out.println();
          mostrarPersonajesVivos();
          System.out.println();
          System.out.println();
          System.out.println("¿A quien quieres proteger?");
          System.out.println();
          String prot = sc.next();
          System.out.println();
          //String protegido = nocheVar.proteger(prot);
           per = itera(prot);
                   // System.out.println(per.getNombre());
                   per.setProtegido();
                   //proteg = per;
            System.out.println();
            System.out.println();
            System.out.println("El protector duerme");
            System.out.println();
            System.out.println();
            System.out.println("Selecciona cualquier letra para continuar");
            String seleccion7 = sc.next();
            System.out.println();
           }

        

       if(nocheVar.lobosVivos() > 0){
        System.out.println();
        System.out.println("Despiertan lobos");
        System.out.println();
        System.out.println();
          System.out.println();
          mostrarPersonajesVivos();
          System.out.println();
          System.out.println();
           System.out.println("a quien decicieron matar?");
           String victi = sc.next();
           System.out.println();
           String guardar1 = nocheVar.lobosMatar(victi);
            per2 = itera(victi);
             if((per.getNombre()).equals(guardar1)==false){
                  per2.setMuerte();
                  muertos.agregaInicio(per2.getNombre());
                  //muer[0]=per2.getNombre();
             }
          
            System.out.println();
            System.out.println();
            System.out.println("Los lobos duermen");
            System.out.println();
            System.out.println();
            System.out.println("Selecciona cualquier letra para continuar");
            String seleccion8 = sc.next();
            System.out.println();
            
            // System.out.println("lo sentimos "+per2.getNombre()+" estaba protegido");
             System.out.println("esta persona esta viva: "+ per2.getMuerte());
             System.out.println();
             System.out.println();
         }
         

        if(personajes.bruja.getMuerte() == true){
              
              System.out.println();
              System.out.println("Despierta bruja");
              System.out.println();
              //System.out.println("¿quieres usar alguna pocion?");
                if(per2.getMuerte()==true){
                System.out.println("¿quieres usar la pocion veneno?");
                System.out.println();
              System.out.println("1) si       2) no");
              System.out.println();
              int pppp = sc.nextInt();
              if (pppp == 1 && personajes.bruja.pocion_veneno==true){
                   System.out.println("¿A quien quieres matar?");
                    System.out.println();
                    String morira = sc.next();
                    String revive=personajes.bruja.matar(morira);
                    per3 = itera(revive);
                    if(per.getNombre()!=revive){
                       per3.setMuerte();
                       if(muertos.contiene(per3.getNombre())==false){
                            muertos.agregaInicio(per3.getNombre());
                       }
                       //muer[1]= per3.getNombre();
                       personajes.bruja.usarPocion("veneno");
                    }}
               }
              if(per2.getMuerte()==false){
                System.out.println("¿Quieres usar alguna pocion?");
                System.out.println();
              System.out.println("Ten encuenta que los lobos mataron a: "+per2.getNombre());
               
              System.out.println();
              System.out.println("1) si       2) no");
              System.out.println();
              int opc9 = sc.nextInt();
              if( opc9 == 1) {
           if(personajes.bruja.pocionesDisponibles()==0){
             System.out.println("Rayos, creo que la bruja ya no tiene pociones");
           }

          if(personajes.bruja.pocionesDisponibles()==1 ){

             if((personajes.bruja.pocion_veneno==true)){
                  System.out.println(" tienes disponible  " + personajes.bruja.pociones());
                  System.out.println();
                  System.out.println("lo quieres usar?");
                  System.out.println();
                  System.out.println("1)si      2) no");
                  System.out.println();
                   int opc5 = sc.nextInt();
                   if (opc5 == 1 && personajes.bruja.pocion_veneno==true){
                   System.out.println("¿A quien quieres matar?");
                    System.out.println();
                    String morira = sc.next();
                    String revive=personajes.bruja.matar(morira);
                    per3 = itera(revive);
                    if(per.getNombre()!=revive){
                       per3.setMuerte();
                       if(muertos.contiene(per3.getNombre())==false){
                            muertos.agregaInicio(per3.getNombre());
                       }
                       //muer[1]= per3.getNombre();
                       personajes.bruja.usarPocion("veneno");
                    }}
             }

              if((personajes.bruja.pocion_curativa)==true){
                  System.out.println(" tienes disponible " + personajes.bruja.pociones());
                  System.out.println();
                  System.out.println("lo quieres usar para revivir a? "+per2.getNombre());
                  System.out.println();
                  System.out.println("1)si      2) no");
                  System.out.println();
                   int opc6 = sc.nextInt();
                   if (opc6 == 1 && personajes.bruja.pocion_curativa==true){
                   System.out.println("¿quieres revivir a "+per2.getNombre()+" ?");
                    System.out.println();
                    System.out.println("1)si      2) no");
                    System.out.println();
                    int opc3 = sc.nextInt();
                      if(opc3== 1){

                        per2.setVida();
                        if(muertos.contiene(per2.getNombre())==true){
                            System.out.println("Se quito de la lista de muertos?"+muertos.elimina(per2.getNombre()));
                       }
                        //muer[0]=null;
                        personajes.bruja.usarPocion("curativa");
                    }
                    }
             }
          
             }

          if(personajes.bruja.pocionesDisponibles()==2){
               
               System.out.println("tienes disponibles "+ personajes.bruja.pociones());

               System.out.println();

               if(per2.getMuerte()==true){
                     System.out.println("¿Quieres matar a alguien?");
                     int acierto = sc.nextInt();
                     System.out.println("1) si     2) no");
                     if(acierto==1){
                      System.out.println();
                      System.out.println("¿A quien quieres matar?");
                      System.out.println();
                      String morira = sc.next();
                      String morira2= personajes.bruja.matar(morira);
                      per4 = itera(morira);

                      if((per.getNombre()).equals(morira)==false){
                       per4.setMuerte();
                       if(muertos.contiene(per4.getNombre())==false){
                           muertos.agregaInicio(per4.getNombre());
                       }
                      // muer[0]=per4.getNombre();
                       personajes.bruja.usarPocion("veneno");
                    }
                     }
                     
                  }

               if(per2.getMuerte()==false){////
                System.out.println("¿Cuantas quieres usar?");
                System.out.println();
                System.out.println("1) solo 1     2) ambas     3) ninguna");
                System.out.println();
               int cantidad = sc.nextInt();
               System.out.println();
               if(cantidad==2){//////////////////////////////////////
                System.out.println("Los lobos mataron a: "+ per2.getNombre()+", ¿quieres revivirlo?");
                 System.out.println();
                 System.out.println("1)si      2) no");
                 System.out.println();
                 int opc = sc.nextInt();
                if (opc ==1){
             
                         
                   // String revive = personajes.bruja.revivir(suertudo);
                    //per3 = itera(revive);
                    per2.setVida();
                    if(muertos.contiene(per2.getNombre())==true){
                            System.out.println("Se quito de la lista de muertos?"+muertos.elimina(per2.getNombre()));
                       }
                       System.out.println();
                       System.out.println();
                    //muer[0]= null;
                    personajes.bruja.usarPocion("curativa");
                    System.out.println("Reviviste a: "+per2.getNombre());
                    System.out.println();
                       System.out.println();
               }
            
                    System.out.println();
                    System.out.println("¿A quien quieres matar?");
                    System.out.println();
                    System.out.println("Ingresa el nombre");
                    System.out.println();
                    String morira = sc.next();
                    String morira2= personajes.bruja.matar(morira);
                    per4 = itera(morira);

                    if((per.getNombre()).equals(morira2)==false){
                       per4.setMuerte();
                       if(muertos.contiene(per4.getNombre())==false){
                           muertos.agregaInicio(per4.getNombre());
                       }
                       //muer[1]=per4.getNombre();
                       personajes.bruja.usarPocion("veneno");
                       System.out.println();
                    }
                  }//////////////////////////////////////////////////////////

                    if(cantidad==1){
                      
                      System.out.println("¿quieres revivir a "+per2.getNombre()+" ?");
                      System.out.println();
                      System.out.println("1)si      2) no");
                      System.out.println();
                      int ggg = sc.nextInt();
                      if(ggg==1){

                          per2.setVida();
                          if(muertos.contiene(per2.getNombre())==true){
                              System.out.println("Se quito de la lista de muertos?"+muertos.elimina(per2.getNombre()));
                          }
                          System.out.println();
                          System.out.println();
                          personajes.bruja.usarPocion("curativa");
                          System.out.println("Reviviste a: "+per2.getNombre());
                          System.out.println();
                          System.out.println();
                       System.out.println();
                      }
                      System.out.println();
                      System.out.println();
                      if(ggg==2){

                          System.out.println("¿A quien quieres matar?");
                          String morira = sc.next();
                          String morira2= personajes.bruja.matar(morira);
                          per4 = itera(morira);

                          if((per.getNombre()).equals(morira)==false){
                              per4.setMuerte();
                       if(muertos.contiene(per4.getNombre())==false){
                           muertos.agregaInicio(per4.getNombre());
                       }
                       //muer[1]=per4.getNombre();
                       personajes.bruja.usarPocion("veneno");
                    }
                      }
                    
                   }
                   }////
                  

             
           }

   
       }}

        }

           if( personajes.flautista.getMuerte()== true ){

               String encantado1;
               String encantado2;
               System.out.println();
               System.out.println("Flautista");
               System.out.println();
               System.out.println();
               mostrarPersonajesVivos();
               System.out.println();
               System.out.println();
               System.out.println("A quienes vas a encantar?");
               System.out.println();
               System.out.println("ingresa al primer encantado");
               encantado1 = sc.next();
               System.out.println("ingresa al segundo  encantado");
               encantado2 = sc.next();

               Persona p5 = itera(encantado1);
               Persona p6 = itera(encantado2); 
               p5.setEncantado();
               p6.setEncantado();
              }
              System.out.println();
              System.out.println();
              System.out.println();
              per.protegido= false;
              System.out.println("Aldeanos vivos: "+aldeanosVivos());
              System.out.println("Lobos vivos: "+lobosVi());
              System.out.println("Personas encantadas: "+encantados());
              //seleccionar opc para continuarx|



     }

     /**
     *Metodo que inicia dia
     *
     */
     public void iniciaDia(){
      
      diaVar.informeDiario(muertos);
      diaVar.seleccionaSospechoso();
     
       System.out.println("Aldeanos vivos: "+aldeanosVivos());
       System.out.println("Lobos vivos: "+lobosVi());
       System.out.println("Personas encantadas: "+encantados());
     }


     /**
     *Metodo que devuelve el total de personajes vivos sin contar a los lobos
     *@return personasVivas
     */
     public int aldeanosVivos(){

          Iterator <Persona> contador1 = aldeanos.iterator();
          Iterator <Persona> contador2 = nocturnos.iterator();

          int personasVivas = 0;

          for(int i =0; i< aldeanos.getLongitud(); i++){
              
               Persona temp = contador1.next();

               if(temp.getMuerte()==true)
                  personasVivas++;
 

          }

          for(int i =0; i< nocturnos.getLongitud(); i++){
              
               Persona temp2 = contador2.next();
                
               if((temp2.getTipo()).equals("lobo")==false&&temp2.getMuerte()==true)

                  personasVivas++;
 

          }
       return personasVivas;

       }

       /**
       *Metodo que retorna el total de lobos vivos
       *@return lobosViv
       */
       public int lobosVi(){
           
           Iterator <Persona> cont3 = nocturnos.iterator();

           int lobosViv =0;

           for(int i =0 ; i< nocturnos.getLongitud(); i++){

               Persona temp3 = cont3.next();

               if((temp3.getTipo()).equals("lobo")==true&&temp3.getMuerte()==true)

                  lobosViv++;
 
           }
        return lobosViv;
       }

       /**
       *Metodo que devuelve el total de personas encantadas
       *@return encantados
       */
       public int encantados(){

        Iterator <Persona> contador6 = aldeanos.iterator();
          Iterator <Persona> contador7 = nocturnos.iterator();

          int personasEncantadas = 0;

          for(int i =0; i< aldeanos.getLongitud(); i++){
              
               Persona temp = contador6.next();

               if(temp.getEncantado()==true&&temp.getMuerte()==true)
                  personasEncantadas++;
 

          }

          for(int i =0; i< nocturnos.getLongitud(); i++){
              
               Persona temp2 = contador7.next();
                
               if(temp2.getEncantado()==true&&temp2.getMuerte()==true)

                  personasEncantadas++;
 

          }
       return personasEncantadas;


       }

     

     /**
     *este metodo regresa un objeto persona que contiene el nombre de la persona que ingresa de parametro
     *@param nombre
     *@return prueba
     */
     public Persona itera(String nombre ){
         Persona prueba = new Persona("no se", "encuentra");
         Iterator <Persona> it4  = nocturnos.iterator();
         Iterator <Persona> it8 = aldeanos.iterator();
          int long7 = nocturnos.getLongitud();
         String busco = nombre;
         
               for(int i=0; i< long7; i++){
               prueba = it4.next();
               String nom = prueba.getNombre(); 
               if(nom.equals(busco)){
                return prueba;
               }
           }
        
           for(int i = 0;i< aldeanos.getLongitud(); i++){
             
              prueba = it8.next();
                if((prueba.getNombre()).equals(nombre)){
             return prueba;
           }
     }
     
     return prueba;

}
}