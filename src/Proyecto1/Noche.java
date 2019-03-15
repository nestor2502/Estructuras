package practica2;
import java.util.Iterator;
import java.util.Scanner;
/**
*
*
*
*/
public class Noche{

     Lista <Persona> nocturnos;
     Vidente vid;
     Protector protec;
     Lobo l1;
     Lobo l2;
     Lobo l3;
     Lobo l4;
     Bruja bruj;
     Flautista flau;

     /**
     *
     *
     */
     public Noche(Lista <Persona> nocturnos){

           this.nocturnos = nocturnos;

           Iterator <Persona> it = this.nocturnos.iterator();

           vid = (Vidente) it.next();
           protec = (Protector) it.next();
           l1 = (Lobo)it.next();
           l2 = (Lobo)it.next();
           l3 = (Lobo)it.next();
           l4 = (Lobo)it.next();
           bruj = (Bruja)it.next();
           flau = (Flautista)it.next();

     }
     

     /**
     *Metodo que usará la vidente
     *
     */
     public void espiar(){

     	 vid.observar();
      
       }

     public String proteger(String nombre){

     	 return protec.seleccionaProtegido(nombre);
 
     }


     public String lobosMatar(){

          String [] victimas = new String[lobosVivos()];
          Iterator <Persona> lobos = nocturnos.iterator();

          Scanner teclado = new Scanner(System.in);



          for(int i =0; i< victimas.length; i++){

                System.out.println("Lobo "+(i+1)+" selecciona tu victima");

                int j=0;

                if(lobos.hasNext()==true){

                     for(int k =0; j<1;k++){
                          
                          //me quedé aqui, hay que hacer una nueva lista con lobos
                          if(lobos.next() instanceof Lobo){}




                           }
                }





          } 
          String temp = "ayuda";
          return temp;
                }
     
/**
     public String matar(String [] nombres){



          // l1.seleccionaVictima(String nombre);
           l2.seleccionaVictima(String nombre);
           l3.seleccionaVictima(String nombre);
           l4.seleccionaVictima(String nombre);
     }
*/
     public int lobosVivos(){

           Iterator <Persona> vivos = nocturnos.iterator();

           int cont =0;

           for(int i = 0; i<= nocturnos.getLongitud();i++){

                if(vivos.next().getMuerte()==true){

                    cont++;
                }
           }
           return cont;
     }



 


}