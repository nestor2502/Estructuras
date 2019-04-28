

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

//-----------------------------------------------------------------------------------------
   /**Metodo que agrega un vertice al arbol
    * @param elemento
    * @return true; se agrego exitosamente
    * 
    */
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
/**Metodo que revisa que se encuentra el vertice con el elemento
 * @return true, el elemento se encuentra
 * @return false, el elemento no se encuentra en un vertice
 * @param elemento
 * 
 */
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
/**
 * Metodo que elimina un vertice del arbol
 * @return true, el vertice se borro exitosamente
 * @return false, el vertice no se encuentra
 * @param j
 */
    @Override
    public boolean elimina(T j) {
    	if(contiene(j) == false)
    		return false;
    	
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
    		
    		if(aux.padre.izquierdo == aux) {
    			aux.padre.izquierdo = null;
    		}else {
    			aux.padre.derecho = null;
    		}
    		elementos--;
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
    		
    		if(aux.padre.derecho == aux) {
    		aux.izquierdo.padre =aux.padre;
    		aux.padre.derecho = aux.izquierdo;
    		}else {
    		aux.izquierdo.padre = aux.padre;
    		aux.padre.izquierdo = aux.izquierdo;
    		
    		}
//    		aux.elemento = aux.izquierdo.elemento;
//    		aux.izquierdo.padre = aux.padre;
//    		aux.izquierdo = null;
    		elementos--;
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
    		if(aux.padre.derecho == aux) {
    		aux.derecho.padre =aux.padre;
    		aux.padre.derecho = aux.derecho;
    		}else {
    		aux.derecho.padre = aux.padre;
    		aux.padre.izquierdo = aux.derecho;
    		
    		}
//    		aux.elemento = aux.derecho.elemento;
//    		aux.derecho.padre = aux.padre;
//    		aux.derecho = null;
    		elementos--;
    		return true;

    	}
    //--------------------------------------------------------------------
    	//Caso tiene 2 hijos
    	if(aux.izquierdo != null && aux.derecho != null) {
    		Vertice predecesor = predecesor(aux.elemento);	
    //Caso raiz(especial)		
    		if(aux == raiz) { //Se borra la raiz
    			if(predecesor == raiz.izquierdo){ //Caso donde el predecesor esta a la ziquierda de la raiz
    				raiz.izquierdo = null;
    				raiz.elemento = predecesor.elemento;
    			}else {//Caso donde el predecesor no esta a la izquierda de la raiz, 1)donde el predecesor no tiene hijo izquierdo, 2)predecesor tiene hijo izquierdo
    				raiz.elemento = predecesor.elemento;
    				if(predecesor.izquierdo != null){//Tiene hijo izquierdo
    				predecesor.izquierdo.padre = predecesor.padre;
    				predecesor.padre.derecho = predecesor.izquierdo;
    			}else//No tiene hijo izquierdo
    				predecesor.padre.derecho = null;
    			}
    		}else{//Caso General
    			//Hy dos casos, el predecesor tiene hijo izquierdo null o no
    			T temporal = predecesor.elemento;
    			elimina(predecesor.elemento);
    			aux.elemento = temporal;
			return true;
    		}	
		elementos--;
    		return true;
    	}
    //Fin del programa	
    	return false;
    }
/**
 * Metodo que te regresa el vertice predecesor de cierto elemento
 * @param y
 * @return Vertice
 */
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
//-------------------------------------------------------------------------------------

public Vertice buscaNodo(T x){
	Vertice otroNodo = raiz; 	
	while(otroNodo != null){
		if(otroNodo.elemento.compareTo(x)==0) {
			return otroNodo;
		}else if(x.compareTo(otroNodo.elemento) <= 0) {
			otroNodo = otroNodo.izquierdo;
		}else {
			otroNodo = otroNodo.derecho;
		}
	}
	
	return null;

}

//------------------------------------------------------------------------------------------------
/**
 * Metodo que regresa el vertice mas a la derecha
 * @param z
 * @return Vertice 
 */
public Vertice maximo(T z) {
	Vertice encontrado = buscaNodo(z);
	while(encontrado.derecho != null) {
		encontrado = encontrado.derecho;
	}
	return encontrado;
}
//--------------------------------------------------------------------------------------------------
/**
 * Metodo que regresa la raiz del arbol
 * @return
 */
public Vertice raiz(){

	return raiz;
}
}
