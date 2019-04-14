import java.util.LinkedList;
import java.util.Queue;

public class pruebasarboles<T extends Comparable<T>> {
	public Nodo raiz;
	public int elementos;
public pruebasarboles(){
	this.raiz = null;
	this.elementos = 0;
}

public pruebasarboles(T[] arreglo){
	this.elementos = arreglo.length;
	for(int i=0;i<arreglo.length;i++) {
		agrega(arreglo[i]);
	}
}

public void agrega(T elemento) {
	Nodo nuevoNodo = new Nodo(elemento);
	if(raiz == null) {
		raiz = nuevoNodo;
		
	}else {
		Nodo temporal = raiz;
		//Hacemos el recorrido para encontrar un lugar vacio
		while(temporal != null) {
			nuevoNodo.padre = temporal;
			if(elemento.compareTo(temporal.elemento)< 0) {
				temporal = temporal.izquierdo;
				
			}else {
				temporal = temporal.derecho;
				
			}			
		}
		//Vemos en donde vamos a ponerlo
		if(nuevoNodo.elemento.compareTo(nuevoNodo.padre.elemento)<=0) {
			nuevoNodo.padre.izquierdo = nuevoNodo;
		}else {
			nuevoNodo.padre.derecho = nuevoNodo;
		}
		
	}
	elementos++;
}
//---------------------------------------------------------------------
public void Nodorotadoizquierda(T x){
	Nodo y = buscaNodo(x);
	rotarizquierda(y);
}
//---------------------------------------------------------------------
public void Nodorotadoderecha(T x){
	Nodo y = buscaNodo(x);
	rotarderecha(y);
}	
//-----------------------------------------------------------------
public void rotarderecha(Nodo x){
//	if(busca(x) == false)
//		return;
	
	Nodo k1 = x;
	
	if(k1.izquierdo == null) {
	return;
	//Caso padre en null		
}else if(k1.padre == null){
	Nodo k2 = k1.izquierdo;
	k1.izquierdo = k2.derecho;
	k1.izquierdo.padre = k1;
	k2.derecho = k1;
	k1.padre = k2;
	raiz = k2;
	return;
}else if(k1.padre.izquierdo == k1 && k1.izquierdo.derecho != null){
	//Caso padre no es null y k1 es su hijo izquierdo e hijo derecho del hijo que rota no es vacio
	Nodo k2 = k1.izquierdo;
	Nodo k3 = k1.padre;
	k1.izquierdo = k2.derecho;
	k1.izquierdo.padre = k1;
	k2.derecho = k1;
	k1.padre = k2;
	k3.izquierdo = k2;
	k2.padre = k3;
	return;
}else if(k1.padre.derecho == k1 && k1.izquierdo.derecho != null) {
	//Caso padre no es null y k1 es su hijo derecho e hijo derecho del hijo que rota no es vacio
	Nodo k2 = k1.izquierdo;
	Nodo k3 = k1.padre;
	k1.izquierdo = k2.derecho;
	k1.izquierdo.padre = k1;
	k2.derecho = k1;
	k1.padre = k2;
	k3.derecho = k2;
	k2.padre = k3;
	return;
}else if(k1.padre.izquierdo == k1 && k1.izquierdo.derecho == null) {
	// Caso padre no es null, k1 es su hijo izquierdo e hijo derecho del hijo que rota no es vacio
	Nodo k2 = k1.izquierdo;
	Nodo k3 = k1.padre;
	k2.derecho = k1;
	k1.padre = k2;
	k3.izquierdo = k2;
	k2.padre = k3;
	k1.izquierdo = null;
	return;
}else if(k1.padre.derecho == k1 && k1.izquierdo.derecho == null){
	//Caso padre no es null, k1 es su hijo derecho e hijo derecho del hijo que rota no es vacio
	Nodo k2 = k1.izquierdo;
	Nodo k3 = k1.padre;
	k2.derecho = k1;
	k1.padre = k2;
	k3.derecho = k2;
	k2.padre = k3;
	k1.izquierdo = null;
	return;
}
 }
//---------------------------------------------------------------------
public void rotarizquierda(Nodo x){
//	if(busca(x) == false)
//		return;
	
	Nodo k1 = x;
	
	if(k1.derecho == null) {
	return;
	//Caso padre en null		
}else if(k1.padre == null){
	Nodo k2 = k1.derecho;
	k1.derecho = k2.izquierdo;
	k1.derecho.padre = k1;
	k2.izquierdo = k1;
	k1.padre = k2;
	raiz = k2;
	return;
}else if(k1.padre.izquierdo == k1 && k1.derecho.izquierdo != null){
	//Caso padre no es null y k1 es su hijo izquierdo e hijo derecho del hijo que rota no es vacio
	Nodo k2 = k1.derecho;
	Nodo k3 = k1.padre;
	k1.derecho = k2.izquierdo;
	k1.izquierdo.padre = k1;
	k2.izquierdo = k1;
	k1.padre = k2;
	k3.izquierdo = k2;
	k2.padre = k3;
	return;
}else if(k1.padre.derecho == k1 && k1.derecho.izquierdo != null) {
	//Caso padre no es null y k1 es su hijo derecho e hijo derecho del hijo que rota no es vacio
	Nodo k2 = k1.derecho;
	Nodo k3 = k1.padre;
	k1.derecho = k2.izquierdo;
	k1.derecho.padre = k1;
	k2.izquierdo = k1;
	k1.padre = k2;
	k3.derecho = k2;
	k2.padre = k3;
	return;
}else if(k1.padre.izquierdo == k1 && k1.derecho.izquierdo == null) {
	// Caso padre no es null, k1 es su hijo izquierdo e hijo derecho del hijo que rota no es vacio
	Nodo k2 = k1.derecho;
	Nodo k3 = k1.padre;
	k2.izquierdo = k1;
	k1.padre = k2;
	k3.izquierdo = k2;
	k2.padre = k3;
	k1.derecho = null;
	return;
}else if(k1.padre.derecho == k1 && k1.derecho.izquierdo == null){
	//Caso padre no es null, k1 es su hijo derecho e hijo derecho del hijo que rota no es vacio
	Nodo k2 = k1.derecho;
	Nodo k3 = k1.padre;
	k2.izquierdo = k1;
	k1.padre = k2;
	k3.derecho = k2;
	k2.padre = k3;
	k1.derecho = null;
	return;
}
}	
//-------------------------------------------------------------------
public Nodo maximo(T z) {
	Nodo encontrado = buscaNodo(z);
	while(encontrado.derecho != null) {
		encontrado = encontrado.derecho;
	}
	return encontrado;
}
//--------------------------------------------------------------------
public Nodo predecesor(T y) {
	Nodo encontrado = buscaNodo(y);
	//arbol vacio
	if(encontrado == null)
		return null;
	//revisamos que su izquierda no este vacia y buscamos el maximo en ese subarbol
	if(encontrado.izquierdo != null) {
	return maximo(encontrado.izquierdo.elemento);
	}
	else {
		//Si no tiene arbol izquierdo, entonces subimos y buscamos a alguien que si lo tenga
	Nodo aux = encontrado.padre;
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

//----------------------------------------------------------------------
public boolean elimina(T j) {
	Nodo aux = buscaNodo(j);
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
		Nodo predecesor = predecesor(aux.elemento);
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

//---------------------------------------------------------------------
public Nodo buscaNodo(T x){
	Nodo otroNodo = raiz; 	
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

//----------------------------------------------------------------------
public void bsf(Nodo nodo) {
	if(nodo == null) {
		return;
	}
	
	Queue<Nodo> nodos = new LinkedList<>();
	nodos.add(raiz);
	
	while(!nodos.isEmpty()) {
		Nodo node = nodos.remove();
		System.out.print(" " + node.elemento);
		if(node.izquierdo != null) {
			nodos.add(node.izquierdo);
		}
		
		if(node.derecho != null) {
			nodos.add(node.derecho);
		}
	}
}

//-------------------------------------------------------------------------
public boolean busca(T r) {
	Nodo otroNodo = raiz; //creamos un nodo que va a la raiz
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
//----------------------------------------------------------------------
//LPR
public void recorrido_en_orden(Nodo x) {
	if(x != null) {
		recorrido_en_orden(x.izquierdo);
		System.out.print(x.elemento + " ");
		recorrido_en_orden(x.derecho);
	}
		
}
//PLR
public void preorder(Nodo y) {
	if(y != null) {
		System.out.print(y.elemento + " ");
		preorder(y.izquierdo);
		preorder(y.derecho);
	}
	
}

//LRP
public void postorder(Nodo z) {
	if(z != null) {
		postorder(z.izquierdo);
		postorder(z.derecho);
		System.out.print(z.elemento + " ");
	}
}
	//------------------------------------------------
	//Nodo del arbol
	private class Nodo{
		public T elemento;
		public Nodo izquierdo;
		public Nodo derecho;
		public Nodo padre;
		
		public Nodo(T elemento){
			this.izquierdo = null;
			this.derecho = null;
			this.padre = null;
			this.elemento = elemento;
			
		}
	}
//-----------------------------------------------------------
	public static void main(String [] args) {
		pruebasarboles <Integer> tree = new pruebasarboles <Integer>();
		tree.agrega(50);
		tree.agrega(30);
		tree.agrega(20);
		tree.agrega(45);
		tree.agrega(15);
		tree.agrega(25);
		tree.agrega(35);
		tree.agrega(48);
		tree.agrega(24);
//		tree.agrega(11);
		
//		tree.recorrido_en_orden(tree.raiz);
/**		System.out.println("");
		tree.preorder(tree.raiz);
		System.out.println("");
		tree.postorder(tree.raiz);
		System.out.println("");
		System.out.println("el arbol tiene " + tree.elementos + " elementos");
*/
//		System.out.println(tree.busca(0));
//		System.out.println();
		System.out.println(tree.elimina(30));
		System.out.println();
		tree.recorrido_en_orden(tree.raiz);
		System.out.println();
//		System.out.println(tree.predecesor(5));
	}

}
