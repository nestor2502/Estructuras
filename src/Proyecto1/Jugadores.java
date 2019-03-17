package practica2;
import java.util.Iterator;

/**
*
*
*
*/
public class Jugadores{

	 int numJugadores=0;
     //arreglo con el nombre de todos los jugadores
     String[] nombres;
     //numeros del 1 al numero total de jugadores
     int [] total;
     //arreglo con 11 numeros aleatorios
     int [] dif;
     //arreglo con numeros sin repetir los numeros que fueron seleccionados aleatorios
     int [] sinRep;
     //arreglo con el nombre de los aldeanos
     String[] alde; 
     //lista con personajes nocturnos
     //Lista <Persona> especiales = new Lista <Persona>();
     //lista de aldeanos
     Lista <Persona> aldeanos = new Lista <Persona>();


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


         total = new int[nombres.length];

         for(int i=0;i< total.length;i++){

             total [i]=i;
         }

    
      }

     /**
     *Metodo que retorna una lista con los personajes que no son aldeanos
     */
     public Lista <Persona> asignarPersonajesSup(){

             Lista <Persona> especiales = new Lista <Persona>();
     	     //metodo que devuelve arrreglo con un 11 numeros aleatorios
             dif = random1(numJugadores);

             vidente = new Vidente(nombres[dif[0]], "vidente");
             protector = new Protector(nombres[dif[1]], "protector"); 
             lobo1 = new Lobo(nombres[dif[2]], "lobo");
             lobo2 = new Lobo(nombres[dif[3]], "lobo");
             lobo3 = new Lobo(nombres[dif[4]], "lobo");
             lobo4 = new Lobo(nombres[dif[5]], "lobo");
             niña = new Niña(nombres[dif[6]], "niña");
             bruja = new Bruja(nombres[dif[7]], "bruja");
             flautista = new Flautista(nombres[dif[8]], "flautista");
             cazador = new Cazador(nombres[dif[9]], "cazador");
             tonto = new Tonto(nombres[dif[10]], "tonto");
             
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
             //se inicia arreglo sin numeros aleatorios de tamaño 11
             sinRep = quitaRepetido(total, dif);

             //se inicia arreglo con el nombres restantes
             alde = new String[sinRep.length];

             //se llena arreglo con los nombres de los aldeanos
             for(int i=0; i <alde.length;i++){
                 //se cera el arreglo de aldeanos sin personajes especiales
             	
             		alde[i]=nombres[sinRep[i]];


             }
          
          return especiales;
         }
    
 

     public Lista<Persona> asignarAldeano(){

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
         
         int [] dif = new int[11];
       int i =0 ;

       while(i < dif.length){

           int numero = (int) (Math.random() * n) +1;

           int cont =0;

           for(int j=0; j<dif.length;j++){

            if(dif[j]==numero){

              cont++;
            }
             
           }
             
           if(cont < 1){
              
              dif[i]=numero;
              i++;

           }
         
         }
      return dif;
     }

     public boolean seEncuentra(int [] arr, int n){


         int [] arre = arr;

         for(int i =0; i< arre.length;i++){

             if(arre[i]==n)

                 return true;
         }

         return false;
     }

        public int [] quitaRepetido(int [] arr6, int[]arr7){
         //este es el arreglo grande
         int [] arr1 = arr6;
         //este es el arreglo chico
         int [] arr2= arr7;
         int [] perfect = new int[(arr6.length-arr7.length)];
         int i=0;
         int con =0;

         while(i<perfect.length-1){
             
             for(int j =0; j< arr1.length;j++){
                if(seEncuentra(arr2, arr1[j])==false){
                   perfect[i]=arr1[j];
                   i++;
                }
             }
             
              }
       return perfect;
    
}

 }





