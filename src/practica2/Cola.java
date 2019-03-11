package practica2;

import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 * Implementación de colas.
 */
public class Cola<T> implements Iterable<T>{

    Lista <T> cola;

    public Cola(){
	
    cola = new Lista <T>();

    }
    
    public Cola(Lista<T> l){
	//Aquí va su código.
    }
    
    public Cola(T[] arreglo){
	cola= new Lista  <T> (arreglo);
    }

    public boolean esVacia(){

	     if (cola.getLongitud()>0)
             return false;
      
         else
             return  true;

    }

    public T mira(){
	
     return cola.getPrimero();
    }

    public T saca(){
	
    return cola.eliminaPrimero();
    }

    public void mete(T t){
	
         cola.agregaFinal(t);
    }

    @Override
    public String toString(){
	 

        return cola.toString();
    }

    @Override
    public boolean equals(Object o){
	 
     return cola.equals(o);
    }

    @Override
    public Iterator<T> iterator(){
	
    return cola.iterator();
    }
}

