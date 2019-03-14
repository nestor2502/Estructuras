package practica2;

import java.util.EmptyStackException;
import java.util.Iterator;

     /**
     *@author Nestor Semer Vazquez Cordero
     *@author Isay Balderas Salomon
     *@version 2.0
     *Clase que implementa ua pila
     *
     */
public class Pila<T> implements Iterable<T>{

	Lista <T> pila;
	Lista <T> l2;

    /**
    *Constructor
    */
    public Pila(){
         
         l2 = new Lista <T>();
         pila= new Lista <T>();

    }
    
    /**
    *Constructor que recibe una lista;
    *
    */
    public Pila(Lista<T> l){
	     pila = l;
         l2 = pila.reversa();
    }
     
     /**
     *Constructor que recibe un arreglo
     *@param arreglo
     */
    public Pila(T[] arreglo){
     
          pila = new Lista <T>(arreglo);	
          l2 = pila.reversa();

    }

    public boolean esVacia(){

	     if (l2.getLongitud()>0)
	    	 return false;
	     else
	     	return true;
    }

    public T mira(){
	
	return l2.getPrimero();
    }

    public int getLong(){

        return l2.getLongitud();
    }

    public T saca(){
	 
	  return l2.eliminaPrimero();
    }

    public void mete(T t){
	
	 l2.agregaInicio(t);
    }

    @Override
    public String toString(){

             Iterator <T> it = l2.iterator();
	 
            String  nuevo ="\n";
            
            if(l2.getLongitud()==0){
                nuevo = "[ ]";
                return nuevo;
            }
            if(l2.getLongitud()==1){
                nuevo = "[ "+it.next().toString()+" ]";
            }
             
             if (l2.getLongitud()>1){

                 nuevo= nuevo+it.next().toString()+"\n";
                 System.out.println();
                 int i =1;
                 while(i<l2.getLongitud()){
                    
                     if(i== l2.getLongitud()-1)

                         nuevo += l2.getUltimo().toString()+"\n";

                     if(i<(l2.getLongitud()-1)){

                         nuevo+= it.next().toString()+"\n";
                         System.out.println();

                         }

                      i++;
                     
                     } 
             }


          return nuevo;
    }

    @Override
    public boolean equals(Object o){

        boolean valor=true;
	
	   if (o instanceof Pila){
                      Lista<T> equ = l2;
                      Pila <T> l3 = (Pila<T>)o;
                      Pila <T> l4 = new Pila(equ.reversa());

                      int con =0;

                      if(l3.getLong()!= l4.getLong()){

                          return false;
                      }

                         Iterator <T> itera = l4.iterator();
                         Iterator <T> iter = l3.iterator();
  
                        for(T it0 : this){

                             if(itera.next()!= iter.next() )
                              
                             con++;
                         }


                      if(con > 1)

                          valor= false;
                      if(con == 0)

                          valor = true;


                 }

                    else 

                        valor =false;

                    return valor;

         }

    @Override
    public Iterator<T> iterator(){
        
     Iterator <T> it2 = l2.iterator();

	return it2;
    }
}
