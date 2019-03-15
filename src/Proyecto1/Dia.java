package practica2;

import java.util.Scanner;
import java.util.Iterator;
public class Dia{

	 String [] muertos ;
     int [] votos;
     Lista <String> sospechosos = new Lista <String>();
     Scanner sc = new Scanner(System.in);

	public Dia(Lista <Persona> aldeanos){}
     

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

		 do {

		 	System.out.println("Ingresa al sospechoso: ");
		 	String sospechoso = sc.next();
		 	sospechosos.agregaInicio(sospechoso);
		 	System.out.println();
		 	System.out.println();
		 	System.out.println("¿Hay otro sospechoso?:");
		 	System.out.println();
		 	System.out.println("1) si      2)no");
		    opc = sc.nextInt();


		 }while(opc==1);
	
	}
    
/**
	public void votar(){
	      votos = new int[sospechosos.getLongitud()];

		for(int i =0;i<votos.length;i++){
             votos[i]=0;
		}

		int cont =0;

		Iterator <String> votos2 = sospechosos.iterator();

		do {

		 	System.out.println("Cuantos votan por "+votos2.next());
		 	int cuantos = sc.nextInt();
		 	votos[cont]=cuantos;
		 	System.out.println();
		 	System.out.println();
            cont++;


		 }while(cont < votos.length);


	}*/

	public String matarSospechoso(String sospechoso){
       return sospechoso;
   }
         


//	}
	public void mensajecolgado(String nombre){
          System.out.println("Ha muertoque era un");
	}

	
}