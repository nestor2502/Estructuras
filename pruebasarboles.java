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
			if(elemento.compareTo(temporal.elemento)<= 0) {
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
//--------------------------------------------------------------------
public Nodo minimo(T z) {
	Nodo encontrado = buscaNodo(z);
	while(encontrado.izquierdo != null) {
		encontrado = encontrado.izquierdo;
	}
	return encontrado;
}
//-------------------------------------------------------------------
public Nodo sucesor(T z) {
	Nodo encontrado = buscaNodo(z);
	if(encontrado == null)
		return null;
	
	if(encontrado.derecho != null) {
		return minimo(encontrado.derecho.elemento);
	}else {
		Nodo aux = encontrado.padre;
		while(aux != null && encontrado == aux.derecho) {
			encontrado = aux;
			aux = aux.padre;
		}
		if(aux == null)
			return null;
		else 
			return aux;
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
	if(busca(j) == false)
		return false;
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
//		aux.elemento = aux.izquierdo.elemento;
//		aux.izquierdo.padre = aux.padre;
//		aux.izquierdo = null;
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
//		aux.elemento = aux.derecho.elemento;
//		aux.derecho.padre = aux.padre;
//		aux.derecho = null;
		elementos--;
		return true;

	}
//--------------------------------------------------------------------
	//Caso tiene 2 hijos
	if(aux.izquierdo != null && aux.derecho != null) {
		Nodo predecesor = predecesor(aux.elemento);	
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
		}		
		elementos--;
		return true;
	}
//Fin del programa	
	return false;
}

//---------------------------------------------------------------------
public void rotarderecha(Nodo x){
	Nodo k1 = x; //renombramos a nuestro nodo
	
	if(k1.izquierdo == null) // regresas, no se puede girar
	return;
	Nodo k2 = k1.izquierdo;	
	if(k1.padre == null){			//casos donde no tienen padres
		if(k1.izquierdo.derecho != null){
		k1.izquierdo = k2.derecho;
		k1.izquierdo.padre = k1;
		}else{
		k1.izquierdo = null;
	}
	k2.derecho = k1;
	k1.padre = k2;
	raiz = k2;
	return;
	}else{					//casos donde tienen padres
	Nodo k3 = k1.padre;
	if(k3.derecho == k1){
		if(k1.izquierdo.derecho != null){
		k1.izquierdo = k2.derecho;
		k1.izquierdo.padre = k1;
		}else{
		k1.izquierdo = null;	
		}
	k2.derecho = k1;
	k1.padre = k2;
	k3.derecho = k2;
	k2.padre = k3;
	} else {
		if(k1.izquierdo.derecho != null){
		k1.izquierdo = k2.derecho;
		k1.izquierdo.padre = k1;
		}else{
		k1.izquierdo = null;
	}
	k2.derecho = k1;
	k1.padre = k2;
	k3.izquierdo = k2;
	k2.padre = k3;	
	}
	return;
}
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
//---------------------------------------------------------------------
public void rotarizquierda(Nodo x){
	Nodo k1 = x; //renombramos a nuestro nodo
	
	if(k1.derecho == null) // regresas, no se puede girar
	return;
	Nodo k2 = k1.derecho;	
	if(k1.padre == null){			//casos donde no tienen padres
		if(k1.derecho.izquierdo != null){
		k1.derecho = k2.izquierdo;
		k1.derecho.padre = k1;
		}else{
		k1.derecho = null;
	}
	k2.izquierdo = k1;
	k1.padre = k2;
	raiz = k2;
	return;
	}else{					//casos donde tienen padres
	Nodo k3 = k1.padre;
	if(k3.derecho == k1){
		if(k1.derecho.izquierdo != null){
		k1.derecho = k2.izquierdo;
		k1.derecho.padre = k1;
		}else{
		k1.derecho = null;	
		}
	k2.izquierdo = k1;
	k1.padre = k2;
	k3.derecho = k2;
	k2.padre = k3;
	} else {
		if(k1.derecho.izquierdo != null){
		k1.derecho = k2.izquierdo;
		k1.derecho.padre = k1;
		}else{
		k1.derecho = null;
	}
	k2.izquierdo = k1;
	k1.padre = k2;
	k3.izquierdo = k2;
	k2.padre = k3;	
	}
	return;
}
	}
//---------------------------------------------------------------------

public Nodo buscaNodo(T x){
	Nodo otroNodo = raiz; 	

	while(otroNodo != null){
		if(otroNodo.elemento.compareTo(x) == 0) {
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
		if(otroNodo.elemento.compareTo(r) == 0) {//revisamos en el nodo actual
			return true;
		}else if( r.compareTo(otroNodo.elemento) < 0) {//revisamos en su nodo izquierdo
			otroNodo = otroNodo.izquierdo;
		}else{
			otroNodo = otroNodo.derecho;//revisamos en su nodo derecho
		}
	}
	return false;
}
//----------------------------------------------------------------------
//LPR
public void inorder(Nodo x) {
	if(x != null) {
		inorder(x.izquierdo);
		System.out.print(x.elemento + " ");
		inorder(x.derecho);
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
		tree.agrega(75);
		tree.agrega(25);
//		tree.elimina(75);
		tree.agrega(100);
		tree.agrega(65);
//		tree.elimina(50);
		tree.agrega(0);
		tree.agrega(35);
//		tree.agrega(100);
		tree.agrega(200);
		tree.agrega(90);
		tree.agrega(500);
		tree.agrega(-10);
		tree.agrega(-40);
		tree.agrega(-60);
		tree.agrega(300);
		tree.elimina(50);
//System.out.println(tree.sucesor(60).elemento);
//		tree.Nodorotadoizquierda(50);
//		tree.elimina(25);
		System.out.println();
		System.out.println(tree.busca(500));
		System.out.println();
		tree.bsf(tree.raiz);
		System.out.println();
	}

}
