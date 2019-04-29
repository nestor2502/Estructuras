/**
 * Clase que representa arboles AVL.
 */
public class ArbolAVL<T extends Comparable<T>> extends ArbolBinarioBusqueda<T>{
	
	protected class VerticeAVL extends Vertice{
		
		public int altura;
		
		public VerticeAVL(T elemento) {
			super(elemento);
			altura = 0;
		}		
	}
	
	public ArbolAVL() {
		super();
	}
	
	public ArbolAVL(T[] elementos) {

		super(elementos);
	}
//---------------------------------------------------------------	
	protected int getAltura(Vertice v) {
		
	}
//-----------------------------------------------------------------	
	protected void actualizaAltura(Vertice v) {
		VericeAVL n = v;
		while(n != null){
			int derecho = getAltura(n.derecho), izquierdo = getAltura(n.izquierdo);
			n.altura = 1 +  Math.max(derecho,izquierdo);
			n = n.padre;
			}		
	}
//-------------------------------------------------------------------------	
	protected int getBalance(Vertice v){
		
	}
//----------------------------------------------------------------------	
	@Override
	public void agrega(T elemento){
		Vertice nuevoNodo = new VerticeAVL(elemento);
		if(raiz == null) {
			raiz = nuevoNodo;
			raiz.altura=getAltura(raiz);
		}else {
			VerticeAVL temporal = raiz;
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
			//Damos su altura, actualizamos alturas y balanceamos de ser necesario
			nuevoNodo.altura = getAltura(nuevoNodo);
			actualizaAltura(nuevoNodo);
			balancea(nuevoNodo);
		}
		elementos++;
	}		
	}
//----------------------------------------------------------------	
	@Override
	public boolean elimina(T elemento){
		
	}
	
	@Override
	protected void giraIzquierda(Vertice v) {
		VerticeAVL k1 = (VerticeAVL)v; //renombramos a nuestro nodo
		
		if(k1.derecho == null) // regresas, no se puede girar
		return;
		VerticeAVL k2 = k1.derecho;	
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
		VerticeAVL k3 = k1.padre;
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
	@Override
	protected void giraDerecha(Vertice v) {

		VerticeAVL k1 = (VerticeAVL)v; //renombramos a nuestro nodo
		
		if(k1.izquierdo == null) // regresas, no se puede girar
		return;
		VerticeAVL k2 = k1.izquierdo;	
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
		VerticeAVL k3 = k1.padre;
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
}