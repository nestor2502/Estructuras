package practica2;

import java.util.Scanner;
import java.util.Iterator;
public class Dia{

	 String [] muertos ;
     int [] votos;
     Lista <String> sospechosos = new Lista <String>();
     Lista <Persona> nocturnos;
     Lista <Persona> aldeanos; 
     Scanner sc = new Scanner(System.in);
     String muerto;

	public Dia(Lista<Persona> noctu,Lista <Persona> aldea){
		nocturnos = noctu;
		aldeanos = aldea;
	}
     

    /**
    *Metodo que informa muertos
    *
    */

	public void informediario(String [] muertos){

		    String muer=" ";

		    System.out.println("Las personas muertas son");

            this.muertos = new String [muertos.length] ;

            for(int i =0; i< this.muertos.length;i++){
                 
                 System.out.println("El muerto "+i+" es: "+this.muertos[i]);

            }
	 }

	public void seleccionaSospechoso(){

		 System.out.println("Es el momento de seleccinar al lobo");



		 
		 int opc=1;

		 int i=0;

		 do {

		 	 System.out.println("Ingresa al sospechoso: "+(i+1));
		 	 String sospechoso = sc.next();
		 	 sospechosos.agregaInicio(sospechoso);
		 	 System.out.println();
		 	 System.out.println();
		 	 System.out.println("¿Hay otro sospechoso?:");
		 	 System.out.println();
		 	 System.out.println("1) si      2)no");
		     opc = sc.nextInt();
             i++;

		 }while(opc==1);
         System.out.println();
         System.out.println();
		 System.out.println("los sospechosos son:");
		 System.out.println();
		 System.out.println(sospechosos.toString());

		 System.out.println("a quien deciden matar?");
		
         muerto =sc.next();

         System.out.println();
         System.out.println("Unas ultimas palabras?"+muerto);
         System.out.println();
         System.out.println();
         mensajecolgado(muerto);
	     
	}


	public String matarSospechoso(){
       return muerto;
   }
         


//	}
	public void mensajecolgado(String nombre){

		 Iterator <Persona> sospe = nocturnos.iterator();
		 Iterator <Persona> sospe2 = aldeanos.iterator();
         String tipo= " ";
		 for(int i = 0;i< nocturnos.getLongitud(); i++){

		 	Persona per = sospe.next();

		 	if(per.getNombre()==nombre){

		 		tipo = per.getTipo();

		 		break;
		 	}

		 }

		  for(int i = 0;i< aldeanos.getLongitud(); i++){

		 	Persona per = sospe2.next();

		 	if(per.getNombre()==nombre){

		 		tipo = per.getTipo();

		 		break;
		 	}

		 }

          System.out.println("Ha muertoque"+muerto+" era un"+tipo);
	}

	
}