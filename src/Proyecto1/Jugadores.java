package practica2;
import java.util.Iterator;

/**
*
*
*
*/
public class Jugadores{

	 int numJugadores=0;
     String[] nombres;
     String[] alde; 
     int [] dif;
     Lista <Integer> seleccionados = new Lista <Integer>();
     Lista <Persona> especiales;
     Lista <Persona> aldeanos;


	 Vidente vidente;
	 Protector protector;
	 Lobo lobo1;
	 Lobo lobo2;
	 Lobo lobo3;
	 Lobo lobo4;
	 Niña niña;
	 Bruja bruja;
	 Flautista flautista;
	 Cazador cazador;
	 Tonto tonto;


     public Jugadores(String [] nombres){
     
         numJugadores = nombres.length;

         this.nombres = nombres;
    
      }

     /**
     *Metodo que retorna una lista con los personajes que no son aldeanos
     */
     public Lista <Persona> asignarPersonajesSup(){

     	  Iterator <Integer> it = seleccionados.iterator();
     	     //metodo que devuelve un numero aleatorio
             dif = random1(this.nombres.length);
             int a=dif[0];
             int b=dif[1];
             int c=dif[2];
             int d=dif[3];
             int e=dif[4];
             int f=dif[5];
             int g=dif[6];
             int h=dif[7];
             int l=dif[8];
             int m=dif[9];
             int n=dif[10];

             vidente = new Vidente(nombres[a], "vidente");
             protector = new Protector(nombres[b], "protector"); 
             lobo1 = new Lobo(nombres[c], "lobo");
             lobo2 = new Lobo(nombres[d], "lobo");
             lobo3 = new Lobo(nombres[e], "lobo");
             lobo4 = new Lobo(nombres[f], "lobo");
             niña = new Niña(nombres[g], "niña");
             bruja = new Bruja(nombres[h], "bruja");
             flautista = new Flautista(nombres[l], "flautista");
             cazador = new Cazador(nombres[m], "cazador");
             tonto = new Tonto(nombres[n], "tonto");
             //Lista con personas seleccionadas como especiales
             especiales = new Lista <Persona>();
             
             //Aldenados no comunes
             aldeanos.agregaInicio(tonto);
             aldeanos.agregaInicio(cazador);
             aldeanos.agregaInicio(niña);
             //Especiales
             especiales.agregaInicio(flautista);
             especiales.agregaInicio(bruja);
             especiales.agregaInicio(lobo1);
             especiales.agregaInicio(lobo2);
             especiales.agregaInicio(lobo3);
             especiales.agregaInicio(lobo4);
             especiales.agregaInicio(protector);
             especiales.agregaInicio(vidente);

             //se inicia arreglo con el nombres restantes
             alde = new String[nombres.length-13];
             int j=0;
             for(int i=0; i< nombres.length-13;i++){
                 //se cera el arreglo de aldeanos sin personajes especiales
             	if(seleccionados.contiene(i)==false){
             		alde[j]=nombres[i];
             		j++;
             	}

             }
          
          return especiales;
         }
    
 

     public Lista<Persona> asignarAldeano(){

         aldeanos= new Lista <Persona>();

         String tip = "aldeano";


     	 for(int i =0; i< alde.length;i++){

             Persona n1 = new Persona(alde[i],tip);

             aldeanos.agregaInicio(n1);
        
         }
     	 return aldeanos;
     }

     
     /**
     *Metodo que devuelve un numero random que no se repite
     *
     */
     public int [] random1(int n){
         
          int [] difi = new int[n];

          int i=0;

          while(i< difi.length){

<<<<<<< HEAD
     	     Integer entero = new Integer(numero);


             if(seleccionados.contiene(entero)==false){

                 seleccionados.agregaInicio(entero);
                 j++;
=======
          	  int numero = (int)(Math.random() * n)+1;

          	  int cont=0;

          	 for(int j=0; j<difi.length;i++){
          	  	 
          	  	 if(difi[j]==numero){
          	  	   	 cont++;
          	  	   }
>>>>>>> nestor

          	  }

          	  if(cont<1){
          	  	  difi[i]=numero;
          	  	  i++;

          	  }

          }
         

<<<<<<< HEAD
     }
=======
      return difi;
>>>>>>> nestor
     } 


