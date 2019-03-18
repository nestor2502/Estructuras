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

	public void informeDiario(Lista <String> muertos){

            Iterator <String> iss = muertos.iterator();


		    String muer=" ";
            
            if(muertos.getLongitud()==0){
            	System.out.println();
            	System.out.println("Hoy fue una buena noche, no murió nadie");
            	System.out.println();

            }
            if(muertos.getLongitud()>0){
		    System.out.println("Las personas que murieron esta noche son: ");
             
             for(int i =0; i< muertos.getLongitud(); i++){
              
              String n1 = iss.next();
              Persona p1 = itera(n1);
              System.out.println();
              System.out.println(p1.getNombre()+" que era "+ p1.getTipo());
              System.out.println();

             }
		     }
		     System.out.println();
		     System.out.println();
		     System.out.println("Presione cualquier tecla para continuar: ");
		     String rrr = sc.next(); 
		     System.out.println();

            
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
		 System.out.println("los sospechosos son: ");
		 System.out.println();
		 System.out.println(sospechosos.toString());
         System.out.println();
		 System.out.println("¿A quien deciden matar?");
		 System.out.println();
		 System.out.println();
		 System.out.println("Ingresen el nombre: ");
		
         muerto =sc.next();

         System.out.println();
        // if(sospechosos.contiene(muerto)==true){
         System.out.println("Unas ultimas palabras?  "+muerto);
         System.out.println();
         System.out.println();
         System.out.println("Presione cualquier letra para continuar");
         String see = sc.next();
         Persona pr = itera(muerto);
         pr.setMuerte();
         System.out.println();
         System.out.println("Mataron a  "+muerto+"  que era: "+pr.getTipo());
         System.out.println();
         System.out.println();
         System.out.println();
         System.out.println();

         sospechosos.limpia(); 
         //}
	     
	}


         


//	}
/**
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
    */
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