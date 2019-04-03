package practica2;

import java.util.function.Consumer;
package arboles;
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

     public Vertice conectaIzquierda(Vertice padre, Vertice hijo){ 
              
         if (padre != null )

             padre.izquierdo = hijo;
         if  (hijo != null )

             hijo.padre = padre;

         if (padre == null && hijo != null){

             padre = hijo;

         }

      }

    public Vertice conectaDerecha(Vertice padre, Vertice hijo){ 
      
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
            }

            u.padre = u.derecho;
            u.derecho = u.derecho.izquierdo;
            u.derecho.izquierdo.padre = u;
            u.padre.izquierdo = u;


          }
     }

     public void giraDerecha(Vertice v ){
        
         if(v.izquierdo == null){

            return 
         }

         else if(v.izquierdo != null){

              Vertice temp1 = v.izquierdo;
           //funcion max pewndiente por implementar
              v.izquierdo = max(a);
              tem1.derecho = v;

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

