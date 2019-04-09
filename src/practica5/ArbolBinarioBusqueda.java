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
    public boolean elimina(T j) {
	Vertice aux = buscaNodo(j);
	if(raiz == null) {
		return false;
	}
//------------------------------------------------------------------------------
	//No tiene hijos
	if(aux.izquierdo == null && aux.derecho == null) {
		if(aux == raiz) {
			raiz = null;
			elementos--;
			return true;
		}
		
		if(aux.padre.izquierdo == aux)
			aux.padre.izquierdo = null;
		else
			aux.padre.derecho = null;
		return true;
	
	}
//-------------------------------------------------------------------------------------------------
//Tiene un nodo hijo
	//Caso izquierdo
	if(aux.derecho == null && aux.izquierdo != null) {
		if(aux == raiz) { //Caso especial
			raiz = raiz.izquierdo;
			elementos--;
			return true;
		}
		
		
		if(aux.padre.izquierdo == aux)
			aux.padre.izquierdo = aux.padre.izquierdo;
		else
			aux.padre.derecho = aux.padre.izquierdo;
		
		return true;

	

	}
	//Caso derecho
//--------------------------------------------------------------------	
	if(aux.izquierdo == null && aux.derecho != null) {
		if(aux == raiz) {	//Caso especial
			raiz = raiz.derecho;
			elementos--;
			return true;
		}
		
		if(aux.padre.izquierdo == aux)
			aux.padre.izquierdo = aux.padre.derecho;
		else
			aux.padre.derecho = aux.padre.derecho;
		
		return true;

	}
//--------------------------------------------------------------------
	//Caso tiene 2 hijos
	if(aux.izquierdo != null && aux.derecho != null) {
		Vertice predecesor = predecesor(aux.elemento);
		//Nodo temporal;
		aux.elemento = predecesor.elemento;
		if(predecesor.izquierdo != null) {
		predecesor.padre.derecho = predecesor.izquierdo;
		predecesor.izquierdo.padre = predecesor.padre;
		predecesor = null;
		elementos--;
		return true;
		}
		
		if(predecesor.izquierdo == null) {
		predecesor.padre.derecho = null;
		predecesor = null;
		elementos--;
		return true;
		}
		
	}
//Fin del programa	
	return false;
}

 public Vertice predecesor(T y) {
	Vertice encontrado = buscaNodo(y);
	//arbol vacio
	if(encontrado == null)
		return null;
	//revisamos que su izquierda no este vacia y buscamos el maximo en ese subarbol
	if(encontrado.izquierdo != null) {
	return maximo(encontrado.izquierdo.elemento);
	}
	else {
		//Si no tiene arbol izquierdo, entonces subimos y buscamos a alguien que si lo tenga
	Vertice aux = encontrado.padre;
	while(aux != null && encontrado == aux.izquierdo) {
		encontrado = aux;
		aux = aux.padre;
	}
	
	if(aux == null)
		return null;
	else 
		return aux;
	}
	//return null;
}

public Vertice buscaNodo(T x){
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

public Vertice maximo(T z) {
	Vertice encontrado = buscaNodo(z);
	while(encontrado.derecho != null) {
		encontrado = encontrado.derecho;
	}
	return encontrado;
}

public Vertice raiz(){

	return raiz;
}
}

