package practica5;

/**
 * Clase que representa un árbol binario de búsqueda.
 */
public class ArbolBinarioBusqueda<T extends Comparable<T>> extends ArbolBinario<T>{

    public ArbolBinarioBusqueda(){
	   
       super();
    }

    public ArbolBinarioBusqueda(T[] a){
	  
      super( a );

    }


    @Override
    public void agrega(T elemento){
	      
         Vertice nuevoNodo = new Vertice(elemento);
         if(raiz == null) {

             raiz = nuevoNodo;
         } 
         else {

             Vertice temporal = raiz;   
             //Hacemos el recorrido para encontrar un lugar vacio
             while(temporal != null) {

                 nuevoNodo.padre = temporal;
                 if(elemento.compareTo(temporal.elemento)<= 0) {
                     temporal = temporal.izquierdo;          
                 }
             

                 else {
                     temporal = temporal.derecho;     
                 }           
             }
             //Vemos en donde vamos a ponerlo
             if(nuevoNodo.elemento.compareTo(nuevoNodo.padre.elemento)<0) {
                 nuevoNodo.padre.izquierdo = nuevoNodo;
              }
        
             else {
                 nuevoNodo.padre.derecho = nuevoNodo;
                }
        
         }
     
     elementos++; 
     }

    @Override
    public boolean contiene(T elemento){
	     Vertice otroNodo = raiz; //creamos un nodo
         while(otroNodo != null) { // mientras no este vacio, seguimos, si no, regresamos vacio

             if(otroNodo.elemento.compareTo(elemento)==0) {//revisamos en el nodo actual
                 return true;
             }
             else if(elemento.compareTo( otroNodo.elemento)<0) {//revisamos en su nodo izquierdo
                  otroNodo = otroNodo.izquierdo;
                 }
                 else {
                     otroNodo = otroNodo.derecho;//revisamos en su nodo derecho
                 }
         }
         return false;
     }

    @Override
    public boolean elimina(T elemento){
    	/**
	     
         if(raiz == null ){
              return false;
         }

         else if(raiz.elemento.compareTo(elemento)==0){

              raiz=null;
              return true;

         }

         else if(elemento.equals(raiz.elemento)==false){

              
         }*/
         return false;
    }
   /**
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

     }*/
      
}

