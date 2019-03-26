package practica2;

import java.util.function.Consumer;

/**
 * Clase que representa un Árbol Binario.
 */
public abstract class ArbolBinario<T>{

    protected class Vertice{

	public T elemento;
	public Vertice izquierdo;
	public Vertice derecho;
	public Vertice padre;

	/**
    *Constructor vertice 
    *@param elemento
    */
	public Vertice(T elemento){
	    
        this.elemento = elemento;
	}
    }

    protected Vertice raiz;
    protected int elementos=0;
    
    public ArbolBinario(){
	
         raiz.elemento = null;
         raiz.izquierdo = null;
         raiz.derecho = null;
         raiz.padre = null;
    }
    /**
    *Inicia un arbol con un arreglo
    *
    */
    public ArbolBinario(T[] arreglo){

         this.elementos = arreglo.length;
         for(int i=0;i<arreglo.length;i++) {
             agrega(arreglo[i]);
         }  
    }

    public abstract void agrega(T elemento);


    public abstract boolean elimina(T elemento);

    public abstract boolean contiene(T elemento);

    public void bfs(Consumer<T> funcion){
	      


         //s funcion.accept();
    }

    public void dfs(int tipo, Consumer<T> funcion){
	       
        switch(tipo){

             case 1: preOrden(funcion, raiz);
 
                 break;

             case 2: inOrden(funcion, raiz);

                 break; 

             case 3:  postOrden(funcion, raiz); 

                  break; 
        }



    }

    public int getElementos(){
	

            return elementos;
    }


    public void preOrden(Consumer<T> funcion, Vertice x ){


        
         if(x != null) {
             funcion.accept(x.elemento);
             preOrden(funcion, x.izquierdo);
             preOrden(funcion, x.derecho);
    }




    }

    public void inOrden(Consumer<T> funcion, Vertice x ){

         if(x != null) {
         inOrden(funcion , x.izquierdo);
         funcion.accept(x.elemento);
         inOrden(funcion, x.derecho);
         
    }


    }

    public void postOrden(Consumer<T> funcion, Vertice x){

         if(x != null) {
         postOrden(x.izquierdo, x);
         postOrden(x.derecho, x);
         funcion.accept(x.elemento);
    }
    }



}

