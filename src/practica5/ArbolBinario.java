package practica5;
import java.util.function.Consumer;
/**
 * @author Balderas Salomon Isay Damar
 * @author Nestor Semer Vazquez Cordero
 * Clase que representa un Árbol Binario.
 */
public abstract class ArbolBinario<T extends Comparable<T>>{

/**
 * 
 * Vertices del arbol binario
 *
 */
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
    /**
     * Constructor del arbol
     */
    public ArbolBinario(){
	
         raiz = null;
         elementos = 0;
    }
    /**
    *Inicia un arbol con un arreglo
    *
    */
    public ArbolBinario(T[] arreglo){


         for(int i=0;i<arreglo.length;i++) {
             agrega(arreglo[i]);
         }  
    }
 /**
  * Metodos abstractos de agrega, contiene y elimina
  * @param elemento
  */

    public abstract void agrega(T elemento);
    public abstract boolean elimina(T elemento);
    public abstract boolean contiene(T elemento);
    /**
     * Metodo que conecta dos vertices
     * poniendo el hijo a la izquierda
     * @param padre
     * @param hijo
     */

     public void conectaIzquierda(Vertice padre, Vertice hijo){ 
              
          if (padre != null ){

             if  (hijo == null )
         	     padre.izquierdo = null;

             if  (hijo != null ){
                 padre.izquierdo = hijo;

                 hijo.padre = padre;}

          }
     }
/**
 * Metodo que conecta dos vertices
 * Poniendo el hijo a la derecha
 * @param padre
 * @param hijo
 */
    public void conectaDerecha(Vertice padre, Vertice hijo){ 
      
        if (padre != null ){

             if  (hijo == null )
             padre.derecho = null;
         if  (hijo != null ){
             padre.derecho = hijo;

             hijo.padre = padre;}

         }

     }
/**
 * Metodo que gira cierto vertice a la izquierda
 * @param u
 */
    public void giraIzquierda(Vertice u){

         if(u.derecho== null){
             return;
          }
          else if (u.derecho != null) {     
            if(u.padre == null){
                u.derecho.padre = null;
                raiz = u.derecho;
             }
            else if(u.padre != null){
                 u.derecho.padre = u.padre;
                 Vertice dad = u.padre;
                 if(dad.izquierdo == u){

                 dad.izquierdo = u.derecho;
                 }
                 if(dad.derecho == u){
                 dad.izquierdo = u.derecho;
                 }
            }             
             Vertice aux = u.derecho;
             u.padre = u.derecho;
             conectaDerecha(u, aux.izquierdo);   
             if(aux.izquierdo != null )
             aux.izquierdo.padre = u;
             conectaIzquierda(aux, u);         
          }
     }
/**
 * Metodo que gira cierto vertice a la derecha
 * @param u
 */
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
             }
         }
             if(u.padre == null){
                u.izquierdo.padre = null;
                raiz = u.izquierdo;
             }
             Vertice aux = u.izquierdo;
             u.padre = u.izquierdo;
             conectaIzquierda(u,aux.derecho );     
               if(aux.derecho != null )
             aux.derecho.padre = u;
             conectaDerecha(aux, u);
         }
     }
/**
 * Metodo que da el recorrido bsf de un arbol
 * @param funcion
 */
    public void bfs(Consumer<T> funcion){
    	
    	Cola<Vertice> cola = new Cola<Vertice>();

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
	
 //     bfs2(funcion, raiz);


        
    }
/**
 * Metodo que , dependiendo del numero y funcion, te da el recorrido
 * pre orden, en orden o post orden.
 * @param tipo
 * @param funcion
 * @throws IllegalArgumentException
 */
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


  /**
   * Regresa el numero de elementos  
   * @return
   */
    public int getElementos(){
	

            return elementos;
    }

/**
 * Metodo auxiliar que da el preorden del arbol
 * @param funcion
 * @param x
 */
    public void preOrden(Consumer<T> funcion, Vertice x ){


        
         if(x != null) {
             funcion.accept(x.elemento);
             preOrden(funcion, x.izquierdo);
             preOrden(funcion, x.derecho);
    }




    }
/**
 * Metodo que da el recorrido inorder del arbol
 * @param funcion
 * @param x
 */
    public void inOrden(Consumer<T> funcion, Vertice x ){

         if(x != null) {
         inOrden(funcion , x.izquierdo);
         funcion.accept(x.elemento);
         inOrden(funcion, x.derecho);
         
    }


    }
/**
 * Metodo que da el recorrido postorden 
 * @param funcion
 * @param x
 */
    public void postOrden(Consumer<T> funcion, Vertice x){

         if(x != null) {
         postOrden(funcion, x.izquierdo);
         postOrden(funcion, x.derecho);
         funcion.accept(x.elemento);
    }
    }
    /**
     * Metodo que busca un vertice con elemento x 
     * @param x
     * @return Vertice regresa el vertice con el elemento
     * @return null el nodo no se encontro
     */
public Vertice buscaVertice(T x){
	Vertice otroNodo = raiz; 	
	
	while(otroNodo != null){
		if(otroNodo.elemento.compareTo(x) == 0) {
			return otroNodo;
		}else if(x.compareTo(otroNodo.elemento) < 0) {
			otroNodo = otroNodo.izquierdo;
		}else {
			otroNodo = otroNodo.derecho;
		}
	}
	
	return null;

}



}
