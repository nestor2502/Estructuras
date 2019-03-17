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
     int longe=0;

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

          longe = nocturnos.getLongitud();
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

    //hay que modificar
     public String lobosMatar(String  victimas){

          
          return victimas;
                }
     

     public int lobosVivos(){
           
           //Itera la lista de personas buscando lobos
           Iterator <Persona> vivos = nocturnos.iterator();

           int cont =0;
            //recorre los elementos de la lista nocturnos
           for(int i = 0; i< nocturnos.getLongitud();i++){

                      Persona p1 = vivos.next();
           	         if(p1.getMuerte()==true && p1.getTipo()=="lobo"){


                     //lviv.agregaInicio(p1);
                      
                     cont++;
             }
           }
           return cont;
     }



}