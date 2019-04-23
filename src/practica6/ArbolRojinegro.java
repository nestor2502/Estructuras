 package practica5;

/**
 * Implementación de árboles rojinegros.
 *@author Nestor Semer Vazquez Cordero
 *@author Isay Balderas Salomon
 */
public class ArbolRojinegro<T extends Comparable<T>> extends ArbolBinarioBusqueda<T>{

    protected class VerticeRojinegro extends Vertice{
	
	/**
	*Constructor de un vertice Rojinegro
	*@param elemento
	*/
	public VerticeRojinegro(T elemento){
       super(elemento);   
       color = Color.ROJO;
	}
	public Color color;
    }
    
    /**
	*Constructor de arbol Rojinegro
	*/
    public ArbolRojinegro(){
        super();
    }
    
    /**
	*Constructor de arbol Rojinegro que recibe un arreglo
	*/
    public ArbolRojinegro(T[] a){   
        for(int i = 0; i< a.length; i++){
             agrega (a[i]);
        }
    }
    /**
    *Metodo que devuelve el color de un vertice
    *@param v
    */
    public Color getColor(Vertice v){   
          //implementar un metodo que recorra el arbol y encuentre el vertice
         T ele = v.elemento;
          VerticeRojinegro ver = new VerticeRojinegro(null);
         if(v instanceof ArbolRojinegro.VerticeRojinegro)
             ver = (VerticeRojinegro) v;
       return ver.color;
    }
    
    /**
    *Metodo que asigna un color a un vertice
    *@param v
    *@param c
    */
    protected void setColor(Vertice v, Color c){  
         if(v instanceof ArbolRojinegro.VerticeRojinegro){
             VerticeRojinegro ve =(VerticeRojinegro)v;
             ve.color = c;}
    }

    /**
    *Metodo que agrega un elemento al arbol
    *@param elemento
    */
    @Override
    public void agrega(T elemento){
    	 Vertice nuevo = new Vertice(elemento);
         if(raiz == null) {
             raiz = nuevo;
         } 
         else {
             Vertice temporal = raiz;  
             while(temporal != null) {
                 nuevo.padre = temporal;
                 if(elemento.compareTo(temporal.elemento)<= 0) {
                     temporal = temporal.izquierdo;        
                 } else {
                     temporal = temporal.derecho;   
                 }           
             }
             //Vemos en donde vamos a ponerlo
             if(nuevo.elemento.compareTo(nuevo.padre.elemento)<=0) {
                 nuevo.padre.izquierdo = nuevo;
              } else {
                 nuevo.padre.derecho = nuevo;
                }       
         }
      rebalanceo1(nuevo);
      elementos++;
	
    }

    /**
    *Metodo que elimina un elemento del arbol
    *
    */
    @Override
    public boolean elimina(T elemento){
    // Aquí va su código.
        return false;
    }

     /**
     *Metodo auxiliar que encuentra el tio de un vertice
     *@param v
     */
    public Vertice getTio(Vertice v){
         Vertice ve  = v;
         if(v.padre.padre.izquierdo==v.padre){
             if(v.padre.padre.derecho!=null)
                 ve = v.padre.padre.derecho;

              if(v.padre.padre.derecho==null)
             ve =  null;
         }
     else if(v.padre.padre.derecho==v.padre){
          if(v.padre.padre.izquierdo!=null)
              ve =  v.padre.padre.derecho;
          if(v.padre.padre.izquierdo==null)
         ve =  null;
      }
     return ve;   
    }
     
     /**
     *Metodo auxiliar que encuentra el abuelo de un vertice
     *@param v
     */
    public Vertice getAbuelo(Vertice v){

         return v.padre.padre;
    }

    /**
    *Metodo que rebancea un arbol despues de agregar un nodo
    *@param v
    */
    public void rebalanceo1(Vertice v){
         if(v.padre == null){
         	 setColor(v, Color.NEGRO);
             return;
         }
         else if(v.padre != null){
             Vertice p = v.padre;
     //Caso 2
             if(getColor(p)== Color.NEGRO){
                return ;
             }
         //Caso 2.1
                Vertice a= new Vertice(v.elemento);
                Vertice t= new Vertice(v.elemento);
              //p rojo, hay abuelo (a) y un tio(t)
                 a = getAbuelo(v);
                 t = getTio(v);
     //Caso 3
             if(t!= null){
             if(getColor(t) == Color.ROJO){
                //coloreamos a t y p de negro y a de rojo
                 //p.color = Color.NEGRO;
             	 setColor(p, Color.NEGRO);
                 //t.color = Color.NEGRO;
                 setColor(t, Color.NEGRO);
                 //a.color = Color.ROJO;
                 setColor(a, Color.NEGRO);
                 rebalanceo1(a);
                 return;
             }}
         //Caso 3.1 t es negro o es dstinto a null
             if(t == null || getColor(t) == Color.NEGRO ){
     //Caso 4
             // v y p estan cruzados, 1.- izquierdo, 2.- derecho      
             int direccionP=0;
             int direccionV=0;
             if(v.padre.padre.izquierdo == v.padre)  
                 direccionP = 1;       
             if(v.padre.padre.derecho == v.padre)
                 direccionP = 2;
             if(v.padre.izquierdo == v)  
                 direccionV = 1;
             if(v.padre.derecho == v)
                 direccionV = 2;  
             // si u y v estan cruzados
             if(direccionV != direccionP){
                 if(direccionP==1){
                     giraIzquierda(p);
                 }
                 if(direccionP==2){
                     giraDerecha(p);
                 }
                 //se regresan a su posicion solo los vertices
                 Vertice temp = v;
                 v= p;
                 p= temp;
                 if(v.padre.padre.izquierdo == v.padre)  
                 direccionP = 1;
                 if(v.padre.padre.derecho == v.padre)
                 direccionP = 2;
                 if(v.padre.izquierdo == v)  
                 direccionV = 1;
                 if(v.padre.derecho == v)
                 direccionV = 2;
             } 
     
     //Caso 5
            //VerticeRojinegro p = v;
            //VerticeRojinegro v = v;       
             if(direccionV == direccionP){
                 //p.color = Color.NEGRO;
             	 setColor(p, Color.NEGRO);
                 //a.color = Color.ROJO;
                 setColor(a, Color.NEGRO);
                 //giramos en direccion contraria de v
                 if(direccionV == 1){
                      giraDerecha(a);
                 }
                 if(direccionV == 2){
                      giraIzquierda(a);
                 }
             return;
             }
             }
         }


    }

    public Vertice buscaVertice(T x){
         Vertice otroNodo = raiz;   
         /** if(otroNodo == raiz){
        
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
   
}