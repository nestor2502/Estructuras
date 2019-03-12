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
         
         pila = new Lista <T>();
    }
    
    /**
    *Constructor que recibe una lista;
    *
    */
    public Pila(Lista<T> l){
	     pila = l;
    }
     
     /**
     *Constructor que recibe un arreglo
     *@param arreglo
     */
    public Pila(T[] arreglo){
     
          pila = new Lista <T>(arreglo);	

    }

    public boolean esVacia(){

	     if (pila.getLongitud()>0)
	    	 return false;
	     else
	     	return true;
    }

    public T mira(){
	
	return pila.getUltimo();
    }

    public T saca(){
	 
	  return pila.eliminaUltimo();
    }

    public void mete(T t){
	
	 pila.agregaFinal(t);
    }

    @Override
    public String toString(){
	 
	 l2 = pila.reversa();
	 return l2.toString();
    }

    @Override
    public boolean equals(Object o){
	
	return pila.equals(o);
    }

    @Override
    public Iterator<T> iterator(){
	return l2.iterator();
    }
}
