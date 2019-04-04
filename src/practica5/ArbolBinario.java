
package practica5;
import practica2.*;

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
        izquierdo = null;
        derecho= null;
        padre = null;
	}
    }

    protected Vertice raiz;
    protected int elementos;
    
    public ArbolBinario(){
	
         raiz = null;
         elementos = 0;
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

     public void conectaIzquierda(Vertice padre, Vertice hijo){ 
              
         if (padre != null )

             padre.izquierdo = hijo;
         if  (hijo != null )

             hijo.padre = padre;

         if (padre == null && hijo != null){

             padre = hijo;

         }

      }

    public void conectaDerecha(Vertice padre, Vertice hijo){ 
      
       if (padre != null )

             padre.derecho = hijo;
         if  (hijo != null )

             hijo.padre = padre;

         if (padre == null && hijo != null){

             padre = hijo;

         }

     }

     public void giraIzquierda(Vertice u){


          if(u.derecho== null){

             return;

          }

          else if (u.derecho != null) {

            if(u.padre != null){


                 u.derecho.padre = u.padre;
                 Vertice dad = u.padre;
                 if(dad.izquierdo == u){

                 dad.izquierdo = u.derecho;

                 }
                 if(dad.derecho == u){

                 dad.izquierdo = u.derecho;
                 }
                 u.izquierdo.padre = dad;

            }

            if(u.padre == null){
                u.derecho.padre = null;
             }

            u.padre = u.derecho;
            u.derecho = u.derecho.izquierdo;
            u.derecho.izquierdo.padre = u;
            u.padre.izquierdo = u;


          }
     }

     public void giraDerecha(Vertice u ){
        
         if(u.izquierdo == null){

            return ;
         }

         else if(u.izquierdo != null){
             
             if(u.padre != null){

                u.izquierdo.padre = u.padre;
                Vertice dad = u.padre;
             
            
             if(dad.izquierdo == u){

                 dad.izquierdo = u.izquierdo;

             }
             if(dad.derecho == u){

                 dad.izquierdo = u.izquierdo;
                 u.izquierdo.padre = dad;
             }}
             if(u.padre == null){
                u.izquierdo.padre = null;
             }
             u.padre = u.izquierdo;
             u.izquierdo = u.izquierdo.derecho;
             u.izquierdo.derecho.padre = u;
             u.padre.derecho = u;

         }

     }

    public void bfs(Consumer<T> funcion){
	      

         if(raiz == null){

        	return;
         }


         Cola <Vertice> cola = new Cola <Vertice>();

         cola.mete(raiz);

         while(cola.esVacia()==false){

        	 Vertice vertice = cola.saca();

        	 funcion.accept(vertice.elemento);

        	 if(vertice.izquierdo != null ){

        	 	 cola.mete(vertice.izquierdo);
        	 }

        	 if(vertice.derecho != null){

                  cola.mete(vertice.derecho);
        	 }
        }

        
    }

    public void dfs(int tipo, Consumer<T> funcion) throws IllegalArgumentException{
	       
        switch(tipo){

             case 1: preOrden(funcion, raiz);
 
                 break;

             case 2: inOrden(funcion, raiz);

                 break; 

             case 3:  postOrden(funcion, raiz); 

                  break; 

             default: throw new IllegalArgumentException(); 
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
         postOrden(funcion, x.izquierdo);
         postOrden(funcion, x.derecho);
         funcion.accept(x.elemento);
    }
    }



}

