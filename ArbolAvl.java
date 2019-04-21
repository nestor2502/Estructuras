import java.util.LinkedList;
import java.util.Queue;

public class ArbolAvl <T extends Comparable<T>>{
	public Nodo raiz;
	public int elementos;
	
	public ArbolAvl(){
		raiz = null;
		elementos = 0;
	}
	public ArbolAvl(T[] array){
		for(int i = 0;i < array.length;i++){
			agrega(array[i]);
		}
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
			public int altura;
			
			
			public Nodo(T elemento){
				this.izquierdo = null;
				this.derecho = null;
				this.padre = null;
				this.elemento = elemento;
				this.altura = 0;
			}
		}
	//-----------------------------------------------------------
		public int getAltura (Nodo n) {//Le da la altura a nuestros nodos
			if(n != null) {	//Si el nodo es null, devuleve la altura menos 1
			if(n.izquierdo == null && n.derecho == null) {// ambos hijos son vacios
				//Regresas 0 porque es una hoja
				return 0;
			}else{//los hijos, son o uno vacio o los no vacios, sacamos el maximo de entre los dos
				int derecho = getAltura(n.derecho), izquierdo = getAltura(n.izquierdo);
				return 1 + Math.max(derecho, izquierdo);
			}
		}
			//Fin del metodo
			return -1;
			
		}
//---------------------------------------------------------------------------------------------
public void actualizaAltura(Nodo n){
	while(n != null){
	int derecho = getAltura(n.derecho), izquierdo = getAltura(n.izquierdo);
	n.altura = 1 +  Math.max(derecho,izquierdo);
	n = n.padre;
	}
}
//--------------------------------------------------------------------------
public void agrega(T elemento){
	Nodo nuevoNodo = new Nodo(elemento);
	if(raiz == null) {
		raiz = nuevoNodo;
		raiz.altura=getAltura(raiz);
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
		//Decimos de quien es padre
		if(nuevoNodo.elemento.compareTo(nuevoNodo.padre.elemento)<=0) {
			nuevoNodo.padre.izquierdo = nuevoNodo;
		}else {
			nuevoNodo.padre.derecho = nuevoNodo;
		}
		nuevoNodo.altura = getAltura(nuevoNodo);
		actualizaAltura(nuevoNodo);
		balancea(nuevoNodo);
	}
	elementos++;
}

//-------------------------------------------------
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
//-------------------------------------------------------------------------
public void elimina(T j){
	Nodo aux = buscaNodo(j);
	if(busca(j) == false)
		return;
	
	if(raiz == null) 
		return;
	

//------------------------------------------------------------------------------
	//No tiene hijos
	if(aux.izquierdo == null && aux.derecho == null) {
		if(aux == raiz) {//La raiz se borra y no se actualiza nada
			raiz = null;
			elementos--;
			return;
		}else{
		Nodo padre_pre = aux.padre;
		if(aux.padre.izquierdo == aux) {//se agregan padre de los borrados

			aux.padre.izquierdo = null;
			
		}else {
			aux.padre.derecho = null;
	
		}
		aux.padre = null;
		actualizaAltura(padre_pre);
		balancea(padre_pre);
		elementos--;
		return;
		}
	
	}
//-------------------------------------------------------------------------------------------------
//Tiene un nodo hijo
	//Caso izquierdo
	if(aux.derecho == null && aux.izquierdo != null) {
		if(aux == raiz) { //Caso especial
			raiz = raiz.izquierdo;
			actualizaAltura(raiz);
//			balancea(raiz);
			elementos--;
			return;
		}
		Nodo hijoizq = aux.izquierdo;
		if(aux.padre.derecho == aux) {
		aux.izquierdo.padre =aux.padre;
		aux.padre.derecho = aux.izquierdo;
		}else {
		aux.izquierdo.padre = aux.padre;
		aux.padre.izquierdo = aux.izquierdo;		
		}
		actualizaAltura(hijoizq);
		balancea(hijoizq);
		elementos--;
		return;

	

	}
	//Caso derecho
//--------------------------------------------------------------------	
	if(aux.izquierdo == null && aux.derecho != null) {
		if(aux == raiz) {	//Caso especial
			raiz = raiz.derecho;
			actualizaAltura(raiz);
			elementos--;
			return;
		}
		
		Nodo hijoder = aux.derecho;
		
		if(aux.padre.derecho == aux) {
		aux.derecho.padre =aux.padre;
		aux.padre.derecho = aux.derecho;
		}else {
		aux.derecho.padre = aux.padre;
		aux.padre.izquierdo = aux.derecho;		
		}
		actualizaAltura(hijoder);
		balancea(hijoder);
		elementos--;
		return;

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
				actualizaAltura(raiz);
				balancea(raiz);
			}else {//Caso donde el predecesor no esta a la izquierda de la raiz, 1)donde el predecesor no tiene hijo izquierdo, 2)predecesor tiene hijo izquierdo
			
				Nodo padre_predecesor = predecesor.padre;
				
				raiz.elemento = predecesor.elemento;
				
			
				if(predecesor.izquierdo != null){//Tiene hijo izquierdo
					
				predecesor.izquierdo.padre = predecesor.padre;
				predecesor.padre.derecho = predecesor.izquierdo;
				
			}else{//No tiene hijo izquierdo
				
				predecesor.padre.derecho = null;
			}
				actualizaAltura(raiz);
				balancea(padre_predecesor);
			}
			
			
			
		}else{//Caso General
			Nodo padre_predecesor = predecesor.padre;
			//Hy dos casos, el predecesor tiene hijo izquierdo null o no
			T temporal = predecesor.elemento;
			elimina(predecesor.elemento);
			aux.elemento = temporal;
			actualizaAltura(padre_predecesor);
			balancea(padre_predecesor);
		}	
		
		elementos--;
		return;
	}
//Fin del programa	
	return;
}
//----------------------------------------------------------------
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
//-------------------------------------------------------------------------
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
	k2.padre = null;
	k1.padre = k2;
	raiz = k2;
	actualizaAltura(k1);
	actualizaAltura(raiz);
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
	actualizaAltura(k1);
	actualizaAltura(k2);
}

}
//---------------------------------------------------------------------------------------------------
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
	k2.padre = null;
	k1.padre = k2;
	raiz = k2;
	
	actualizaAltura(k1);
	actualizaAltura(raiz);
	
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
	actualizaAltura(k1);
	actualizaAltura(k1.padre);
	
}


	}
//-----------------------------------------------------------------------------------------------
public int getBalance(Nodo n){
	if(n != null){
		//2 signfica que el izquierdo esta desbalaceado. viceversa
		//Valores -1, 1 y 0 significa que esta bien balanceado
		return (getAltura(n.izquierdo) - getAltura(n.derecho));
	}
	return 0;
}
//-----------------------------------------------------------------------------
public void balancea(Nodo n){ // 1, -1 y 0 estan bien balanceados, por lo tanto, revisamos casos 2 o menos 2, ya que son donde se descompone

	if(n == null)//entramos en este si el nodo es null
		return;	//termina la recursion

	if(getBalance(n) == 2){//Tiene mas del lado izquierdo		
			if(getBalance(n.izquierdo) >= 0) {//esta del lado izquierdo				
		rotarderecha(n);
			}else{//esta del lado derecho del hijo izquierdo, dos giros				
		rotarizquierda(n.izquierdo);
		rotarderecha(n);
		}			
	}else if(getBalance(n) == -2){//Tiene mas del lado derecho		
		if(getBalance(n.derecho) <= 0) {//todo esta a la derecha				
		rotarizquierda(n);
			}else {//esta del lado izquierdo del hijo derecho, dos giros				
				rotarderecha(n.derecho);			
				rotarizquierda(n);
			}			
	}else{
n = n.padre;
balancea(n);
	}
}

	

//-----------------------------------------------------------------------------
public Nodo buscaNodo(T x){
	Nodo otroNodo = raiz; 	

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

//----------------------------------------------------------------------------
public static void main(String [] args){
	ArbolAvl<Integer> avl = new ArbolAvl<Integer>();
	avl.agrega(100);
	avl.agrega(200);
	avl.agrega(50);
	avl.agrega(75);
	avl.agrega(40);
	avl.agrega(0);
	avl.agrega(30);
	avl.agrega(80);
	avl.agrega(20);
	avl.agrega(90);
	avl.agrega(10);
	avl.agrega(400);
	avl.agrega(300);
	avl.agrega(1000);
	avl.agrega(2000);
	avl.elimina(2000);
	avl.elimina(0);
	avl.elimina(10);
/**
	avl.elimina(2000);
	avl.elimina(52);
	avl.elimina(45);
	avl.elimina(43);
	avl.elimina(40);
	avl.elimina(35);
	avl.elimina(10);
//	avl.elimina(80);
 * */
	
	avl.bsf(avl.raiz);
	System.out.println();
	System.out.println(avl.raiz.elemento);
	System.out.println(avl.raiz.altura);
	System.out.println(avl.raiz.derecho.elemento);
	System.out.println(avl.raiz.izquierdo.elemento);
	System.out.println(avl.getBalance(avl.raiz.izquierdo));
	System.out.println(avl.getBalance(avl.raiz.derecho));
	System.out.println();
//	System.out.println(avl.getBalance(avl.raiz));
//	System.out.println(avl.raiz.izquierdo.altura);
//	System.out.println(avl.raiz.izquierdo.elemento);
//	System.out.println(avl.raiz.derecho.altura);
//	System.out.println(avl.raiz.izquierdo.altura);
//	System.out.println(avl.raiz.izquierdo.altura);
//	System.out.println(avl.raiz.izquierdo.elemento);
//	System.out.println(avl.raiz.derecho.altura);
//	System.out.println(avl.raiz.derecho.elemento);
//	System.out.println();
	}
}

