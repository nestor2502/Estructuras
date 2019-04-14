
package practica5;
import java.util.LinkedList;
import java.util.Queue;
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

    public Vertice raiz;
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
              
         if (padre != null ){

             if  (hijo == null )
         	     padre.izquierdo = null;

             if  (hijo != null )
                 padre.izquierdo = hijo;

                 hijo.padre = padre;

          }
     }

    public void conectaDerecha(Vertice padre, Vertice hijo){ 
      
       if (padre != null ){

             if  (hijo == null )
             padre.derecho = null;
         if  (hijo != null )
             padre.derecho = hijo;

             hijo.padre = padre;


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
                raiz = u.derecho;
             }
            /**
            u.padre = u.derecho;
            u.derecho = u.derecho.izquierdo;
            u.derecho.izquierdo.padre = u;
            u.padre.izquierdo = u;*/
            
             Vertice aux = u.derecho;
             u.padre = u.derecho;
             u.derecho = aux.izquierdo;
             aux.derecho.padre = u;
             aux.izquierdo  = u;
            
             //Vertice aux = u.derecho;
             //u.padre = u.derecho;
            // conectaDerecha(u,aux.derecho);

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
                 //se cambio
                 dad.derecho = u.izquierdo;
                 //u.izquierdo.padre = dad;
             }}
             if(u.padre == null){
                u.izquierdo.padre = null;
                raiz = u.izquierdo;
             }/**
             u.padre = u.izquierdo;
             u.izquierdo = u.izquierdo.derecho;
             u.izquierdo.derecho.padre = u;
             u.padre.derecho = u;
             */
             //Vertice pivote = u;
             Vertice aux = u.izquierdo;
             u.padre = u.izquierdo;
             u.izquierdo = aux.derecho;
             aux.derecho.padre = u;
             aux.derecho = u;

           //raiz = aux;

         }

     }

    public void bfs(Consumer<T> funcion){
    	/**
    	Cola <Vertice> cola = new Cola<Vertice>();
	      
         //Cola<Vertice> cola = new LinkedList<>();
         cola.mete(raiz);
         while(!cola.esVacia()){

         	   Vertice v = cola.saca();
         	   funcion.accept(v.elemento);
         	   if(v.izquierdo!= null) 
         	   	   cola.mete(v.izquierdo);
               if(v.derecho!= null) 
         	   	   cola.mete(v.derecho);

         }
         System.out.println();
	
*/      bfs2(funcion, raiz);


        
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

    public void bfs2(Consumer<T> funcion, Vertice x){

    	

    	 Queue<Vertice> cola = new LinkedList<Vertice>();
	     cola.add(x);
	
	     while(!cola.isEmpty()) {
		 Vertice vertice = cola.remove();
		 funcion.accept(vertice.elemento);
		 if(vertice.izquierdo != null) {
			 cola.add(vertice.izquierdo);
		 }
		
		 if(vertice.derecho != null) {
			 cola.add(vertice.derecho);
		 }
	}

	     //Queue<Vertice> cola = new LinkedList<Vertice>();
         //cola.
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

