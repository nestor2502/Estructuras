
package practica5;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;
/**
 * Clase que representa un Árbol Binario.
 */
public abstract class ArbolBinario<T extends Comparable<T>>{

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

     public void giraIzquierda(Vertice x){

	//if(busca(x.elemento) == false)
	//	return;
	
	Vertice k1 = x;// buscaVertice(x.elemento);
	
	if(k1.derecho == null) {
	return;
	//Caso padre en null		
}else if(k1.padre == null){
	Vertice k2 = k1.derecho;
	k1.derecho = k2.izquierdo;
	k1.derecho.padre = k1;
	k2.izquierdo = k1;
	k1.padre = k2;
	raiz = k2;
	return;
}else if(k1.padre.izquierdo == k1 && k1.derecho.izquierdo != null){
	//Caso padre no es null y k1 es su hijo izquierdo e hijo derecho del hijo que rota no es vacio
	Vertice k2 = k1.derecho;
	Vertice k3 = k1.padre;
	k1.derecho = k2.izquierdo;
	k1.izquierdo.padre = k1;
	k2.izquierdo = k1;
	k1.padre = k2;
	k3.izquierdo = k2;
	k2.padre = k3;
	return;
}else if(k1.padre.derecho == k1 && k1.derecho.izquierdo != null) {
	//Caso padre no es null y k1 es su hijo derecho e hijo derecho del hijo que rota no es vacio
	Vertice k2 = k1.derecho;
	Vertice k3 = k1.padre;
	k1.derecho = k2.izquierdo;
	k1.derecho.padre = k1;
	k2.izquierdo = k1;
	k1.padre = k2;
	k3.derecho = k2;
	k2.padre = k3;
	return;
}else if(k1.padre.izquierdo == k1 && k1.derecho.izquierdo == null) {
	// Caso padre no es null, k1 es su hijo izquierdo e hijo derecho del hijo que rota no es vacio
	Vertice k2 = k1.derecho;
	Vertice k3 = k1.padre;
	k2.izquierdo = k1;
	k1.padre = k2;
	k3.izquierdo = k2;
	k2.padre = k3;
	k1.derecho = null;
	return;
}else if(k1.padre.derecho == k1 && k1.derecho.izquierdo == null){
	//Caso padre no es null, k1 es su hijo derecho e hijo derecho del hijo que rota no es vacio
	Vertice k2 = k1.derecho;
	Vertice k3 = k1.padre;
	k2.izquierdo = k1;
	k1.padre = k2;
	k3.derecho = k2;
	k2.padre = k3;
	k1.derecho = null;
	return;
}
     }

     public void giraDerecha(Vertice x ){
        
         //if(busca(x.elemento) == false)
		//return;
	
	Vertice k1 = x;	//buscaVertice(x.elemento);
	
	if(k1.izquierdo == null) {
	return;
	//Caso padre en null		
}else if(k1.padre == null){
	Vertice k2 = k1.izquierdo;
	k1.izquierdo = k2.derecho;
	k1.izquierdo.padre = k1;
	k2.derecho = k1;
	k1.padre = k2;
	raiz = k2;
	return;
}else if(k1.padre.izquierdo == k1 && k1.izquierdo.derecho != null){
	//Caso padre no es null y k1 es su hijo izquierdo e hijo derecho del hijo que rota no es vacio
	Vertice k2 = k1.izquierdo;
	Vertice k3 = k1.padre;
	k1.izquierdo = k2.derecho;
	k1.izquierdo.padre = k1;
	k2.derecho = k1;
	k1.padre = k2;
	k3.izquierdo = k2;
	k2.padre = k3;
	return;
}else if(k1.padre.derecho == k1 && k1.izquierdo.derecho != null) {
	//Caso padre no es null y k1 es su hijo derecho e hijo derecho del hijo que rota no es vacio
	Vertice k2 = k1.izquierdo;
	Vertice k3 = k1.padre;
	k1.izquierdo = k2.derecho;
	k1.izquierdo.padre = k1;
	k2.derecho = k1;
	k1.padre = k2;
	k3.derecho = k2;
	k2.padre = k3;
	return;
}else if(k1.padre.izquierdo == k1 && k1.izquierdo.derecho == null) {
	// Caso padre no es null, k1 es su hijo izquierdo e hijo derecho del hijo que rota no es vacio
	Vertice k2 = k1.izquierdo;
	Vertice k3 = k1.padre;
	k2.derecho = k1;
	k1.padre = k2;
	k3.izquierdo = k2;
	k2.padre = k3;
	k1.izquierdo = null;
	return;
}else if(k1.padre.derecho == k1 && k1.izquierdo.derecho == null){
	//Caso padre no es null, k1 es su hijo derecho e hijo derecho del hijo que rota no es vacio
	Vertice k2 = k1.izquierdo;
	Vertice k3 = k1.padre;
	k2.derecho = k1;
	k1.padre = k2;
	k3.derecho = k2;
	k2.padre = k3;
	k1.izquierdo = null;
	return;
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
public Vertice buscaVertice(T x){
	Vertice otroNodo = raiz; 	
/**	if(otroNodo == raiz){
		
		return otroNodo;
		
	}	
*/	
	while(otroNodo != null){
		if(otroNodo.elemento == x) {
			return otroNodo;
		}else if(x.compareTo(otroNodo.elemento) <= 0) {
			otroNodo = otroNodo.izquierdo;
		}else {
			otroNodo = otroNodo.derecho;
		}
	}
	
	return null;

}

public boolean busca(T r) {
	Vertice otroNodo = raiz; //creamos un nodo que va a la raiz
	while(otroNodo != null) { // mientras no este vacio, seguimos, si no, regresamos vacio
		if(otroNodo.elemento == r) {//revisamos en el nodo actual
			return true;
		}else if( r.compareTo(otroNodo.elemento) <= 0) {//revisamos en su nodo izquierdo
			otroNodo = otroNodo.izquierdo;
		}else {
			otroNodo = otroNodo.derecho;//revisamos en su nodo derecho
		}
	}
	return false;
}



}

