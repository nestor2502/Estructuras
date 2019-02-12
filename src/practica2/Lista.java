
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Implementación de listas ligadas.
 */
public class Lista<T> implements Iterable<T>{

    // Clase interna para representar los nodos de nuestras listas.
    private class Nodo{
	
	public T elemento;
	public Nodo siguiente;
	public Nodo anterior;
	
	public Nodo(T elemento){
	    // Aquí va su código.
	}
    }

    // Clase para iterar la lista.
    private class Iterador implements Iterator<T>{

	public Nodo siguiente;

	public Iterador(){
	    // Aquí va su código.
	}

	@Override
	public boolean hasNext(){
	    // Aquí va su código.
	}
	
	@Override
	public T next(){
	    // Aquí va su código.
	}
    }

    private Nodo cabeza;
    private Nodo ultimo;
    private int longitud;
    
    public Lista(){
	// Aquí va su código.
    }

    public Lista(T[] arreglo){
	// Aquí va su código.
    }
    
    public T getPrimero(){
	// Aquí va su código.
    }

    public T getUltimo(){
        // Aquí va su código.
    }

    public T eliminaPrimero(){
	// Aquí va su código.
    }

    public T eliminaUltimo(){
	// Aquí va su código.
    }

    public void agregaInicio(T t){
	// Aquí va su código.
    }

    public void agregaFinal(T t){
	// Aquí va su código.
    }

    public boolean contiene(T t){
	// Aquí va su código.
    }

    public int getLongitud(){
	// Aquí va su código.
    }

    public boolean elimina(T t){
	// Aquí va su código.
    }

    public void limpia(){
	// Aquí va su código.
    }

    public T get(int indx){
	// Aquí va su código.
    }
 
    public void inserta(int indx, T t){
	// Aquí va su código.
    }

    public Object[] toArray(){
	// Aquí va su código.
    }

    public Lista<T> reversa(){
	// Aquí va su código.
    }


    public Lista<T> copia(){
	// Aquí va su código.
    }
    
    @Override
    public String toString(){
       	// Aquí va su código.
    }

    @Override
    public boolean equals(Object o){
      	// Aquí va su código.
    }
    
    @Override
    public Iterator<T> iterator(){
	// Aquí va su código.
    }
}
Lista.java
Mostrando Lista.java.