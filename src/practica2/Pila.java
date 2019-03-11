package practica2;

import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * Implementación de pilas.
 */
public class Pila<T> implements Iterable<T>{

	Lista <T> pila;
	Lista <T> l2;

    public Pila(){
         
         pila = new Lista <T>();
    }
    
    public Pila(Lista<T> l){
	//Aquí va su código.
    }

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
