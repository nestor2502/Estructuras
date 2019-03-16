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
     //Lista con lobos vivos
     Lista <Lobo> lviv = new Lista <Lobo>();
     Lista <Persona> encantados = new Lista <Persona> ();
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


     public String lobosMatar(String [] victimas){

          String [] victimas2 = new String[lobosVivos()];
          Iterator <Lobo> lobos = lviv.iterator();

          Scanner teclado = new Scanner(System.in);



          for(int i =0; i< victimas2.length; i++){

                int j=0;


                if(lobos.hasNext()==true){

                     Lobo lo1 = lobos.next();

                       lo1.seleccionaVictima(victimas2[i]);

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
           
           //Itera la lista de personas buscando lobos
           Iterator <Persona> vivos = nocturnos.iterator();

           int cont =0;
            //recorre los elementos de la lista nocturnos
           for(int i = 0; i<= nocturnos.getLongitud();i++){

           	     if(vivos instanceof Lobo){

                      Lobo p1 =(Lobo) vivos.next();

                     if(p1.getMuerte()==true){

                     lviv.agregaInicio(p1);
                      
                     cont++;
                }
             }
           }
           return cont;
     }

public void brujaMatar(String nombre){

}
public void brujaRevive(String nombre){

}
public void encantarPersonas(String nombre, String nombre2){
	Lista <String> encantados = new Lista <String> ();
}
public void personasencantadas(){
 
} 	
//public String [] personasMuertas(){

//}

}