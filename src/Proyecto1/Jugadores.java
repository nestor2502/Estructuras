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
             random1();
             int a=it.next();
             int b=it.next();
             int c=it.next();
             int d=it.next();
             int e=it.next();
             int f=it.next();
             int g=it.next();
             int h=it.next();
             int l=it.next();
             int m=it.next();
             int n=it.next();

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

             especiales.agregaInicio(tonto);
             especiales.agregaInicio(cazador);
             especiales.agregaInicio(flautista);
             especiales.agregaInicio(bruja);
             especiales.agregaInicio(niña);
             especiales.agregaInicio(bruja);
             especiales.agregaInicio(niña);
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
    
 

     public Lista<Persona> asignarAldeno(){

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
     public void random1(){
         
         int numero=0;
         int j=0;
         
         // 11 es el numero de personajes que no son aldeanos
         while(j<=11){


     	     numero = (int) (Math.random() * numJugadores) + 1;


             if(seleccionados.contiene(numero)==false){

                 seleccionados.agregaInicio(numero);
                 j++;

                 }
         }


     } 


}