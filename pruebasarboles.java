
public class pruebasarboles {
	public Nodo raiz;
	public int elementos;
public pruebasarboles(){
	this.raiz = null;
	this.elementos = 0;
}

public pruebasarboles(int[] arreglo){
	this.elementos = arreglo.length;
	for(int i=0;i<arreglo.length;i++) {
		agrega(arreglo[i]);
	}
}

public void agrega(int elemento) {
	Nodo nuevoNodo = new Nodo(elemento);
	if(raiz == null) {
		raiz = nuevoNodo;
		
	}else {
		Nodo temporal = raiz;	
		//Hacemos el recorrido para encontrar un lugar vacio
		while(temporal != null) {
			nuevoNodo.padre = temporal;
			if(elemento<=temporal.elemento) {
				temporal = temporal.izquierdo;
				
			}else {
				temporal = temporal.derecho;
				
			}			
		}
		//Vemos en donde vamos a ponerlo
		if(nuevoNodo.elemento < nuevoNodo.padre.elemento) {
			nuevoNodo.padre.izquierdo = nuevoNodo;
		}else {
			nuevoNodo.padre.derecho = nuevoNodo;
		}
		
	}
	elementos++;
}
//----------------------------------------------------------------------
/**public boolean elimina(int j) {
	//No puedes borrar un arbol vacio
	if(raiz == null)
		return false;
	//Sin hijos
	Nodo prueba2 = raiz;
	if(prueba2.izquierdo == null && prueba2.derecho == null) {
		prueba2 = null;
		return true;
	}
}
*/
//----------------------------------------------------------------------
/**public void bsf(Nodo node) {
	if(node != null) {
		Cola cola = new Cola();
		Cola.push
	}
}
*/
//-------------------------------------------------------------------------
public boolean busca(int r) {
	Nodo otroNodo = raiz; //creamos un nodo
	while(otroNodo != null) { // mientras no este vacio, seguimos, si no, regresamos vacio
		if(otroNodo.elemento == r) {//revisamos en el nodo actual
			return true;
		}else if(r < otroNodo.elemento) {//revisamos en su nodo izquierdo
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
		public int elemento;
		public Nodo izquierdo;
		public Nodo derecho;
		public Nodo padre;
		
		public Nodo(int elemento){
			this.izquierdo = null;
			this.derecho = null;
			this.padre = null;
			this.elemento = elemento;
			
		}
	}
//-----------------------------------------------------------
	public static void main(String [] args) {
		pruebasarboles tree = new pruebasarboles();
		tree.agrega(6);
		tree.agrega(4);
		tree.agrega(8);
		tree.agrega(5);
		tree.agrega(3);
		tree.agrega(7);
		tree.agrega(9);
		tree.agrega(1);
		
		tree.recorrido_en_orden(tree.raiz);
		System.out.println("");
		tree.preorder(tree.raiz);
		System.out.println("");
		tree.postorder(tree.raiz);
		System.out.println("");
		System.out.println("el arbol tiene " + tree.elementos + " elementos");
		System.out.println(tree.busca(1));
		System.out.println();
	}

}
