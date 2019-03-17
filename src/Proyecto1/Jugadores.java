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


	 public Vidente vidente;
	 public Protector protector;
	 public Lobo lobo1;
	 public Lobo lobo2;
	 public Lobo lobo3;
	 public Lobo lobo4;
	 public Niña niña;
	 public Bruja bruja;
	 public Flautista flautista;
	 public Cazador cazador;
	 public Tonto tonto;


     public Jugadores(String [] nombres){
     
         numJugadores = nombres.length;

         //this.nombres = nombres;
         this.nombres = new String[nombres.length];
         for(int i =0; i< this.nombres.length;i++){

              this.nombres[i]=nombres[i];
         }


         total = new int[this.nombres.length];

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
             dif = diferentes(numJugadores);

             vidente = new Vidente(nombres[dif[0]], "vidente");
             protector = new Protector(nombres[dif[1]], "protector"); 
             lobo1 = new Lobo(nombres[dif[2]], "lobo");
             lobo2 = new Lobo(nombres[dif[3]], "lobo");
             lobo3 = new Lobo(nombres[dif[4]], "lobo");
             lobo4 = new Lobo(nombres[dif[5]], "lobo");
             
             bruja = new Bruja(nombres[dif[6]], "bruja");
             flautista = new Flautista(nombres[dif[7]], "flautista");
             
             
             //Especiales
             especiales.agregaInicio(flautista);
             especiales.agregaInicio(bruja);
             especiales.agregaInicio(lobo1);
             especiales.agregaInicio(lobo2);
             especiales.agregaInicio(lobo3);
             especiales.agregaInicio(lobo4);
             especiales.agregaInicio(protector);
             especiales.agregaInicio(vidente);
             
             //se inicia arreglo sin numeros aleatorios de tamaño 
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
         niña = new Niña(nombres[dif[8]], "niña");
         cazador = new Cazador(nombres[dif[9]], "cazador");
         tonto = new Tonto(nombres[dif[10]], "tonto");
         
        //Aldenados no comunes
             aldeanos.agregaInicio(tonto);
             aldeanos.agregaInicio(cazador);
             aldeanos.agregaInicio(niña);

         String tip = "aldeano";


     	 for(int i =0; i< alde.length;i++){

             Persona n1 = new Persona(alde[i],tip);

             aldeanos.agregaInicio(n1);
        
         }
     	 return aldeanos;
     }

     
      public boolean seEncuentra(int [] arr, int n){


         int [] arre = arr;

         for(int i =0; i< arre.length;i++){

             if(arre[i]==n)

                 return true;
         }

         return false;
     }



    public int[] diferentes(int n){

       int [] dif = new int[11];
       int i =0 ;

       while(i < dif.length){

           int numero = (int) (Math.random() * n);

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

     public int [] quitaRepetido(int [] arr6, int[]arr7){
         //este es el arreglo grande
         int [] arr1 = arr6;
         //este es el arreglo chico
         int [] arr2= arr7;
         int [] perfect = new int[(arr6.length-arr7.length)];
         int i=0;
         int con =0;


             
             for(int j =0; j< arr1.length;j++){
                if(seEncuentra(arr2, arr1[j])==false){
                   if(i<perfect.length){
                   perfect[i]=arr1[j];
                   i++;}
                }
             }
             
              
       return perfect;
    
}



 }





