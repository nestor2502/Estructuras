package practica5;
/**
 * Implementación de árboles rojinegros.
 */
public class ArbolRojinegro<T extends Comparable<T>> extends ArbolBinarioBusqueda<T>{

    protected class VerticeRojinegro extends Vertice{
	
	public VerticeRojinegro(T elemento){
	   

       super(elemento);   
       color = Color.ROJO;


	}
	
	public Color color;
	
    }

    public ArbolRojinegro(){
	

    }

    public ArbolRojinegro(T[] a){
        
        for(int i = 0; i< a.length; i++){

             agrega (a[i]);
        }
    }
    
    protected Color getColor(Vertice v){   
       //implementar un metodo que recorra el arbol y encuentre el vertice

       VerticeRojinegro ve =(VerticeRojinegro) buscaNodo(v);
       return ve.color;
    }

    protected void setColor(Vertice v){
        
        //metodo pendiente por implementacion
        //VerticeRojinegro ve =(VerticeRojinegro) buscaNodo(ve);
        

        if(v.color== Color.ROJO){

             v.color = Color.NEGRO;
        }

        if(v.color == Color.NEGRO){

             v.color = Color.ROJO;
        }
    }

    @Override
    public void agrega(T elemento){

        VerticeRojinegro nuevoNodo = new VerticeRojinegro(elemento);
         if(raiz == null) {

             raiz = nuevoNodo;
             //nuevoNodo.color = Color.NEGRO;
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
     //rebalanceo( T elemento);
     elementos++;
	

    }

    @Override
    public boolean elimina(T elemento){
    // Aquí va su código.
        return false;
    }

    public VerticeRojinegro getTio(VerticeRojinegro v){
     

     if(v.padre.padre.izquierdo==v.padre)
         return (VerticeRojinegro)v.padre.padre.derecho;

     else if(v.padre.padre.derecho==v.padre)
         return (VerticeRojinegro)v.padre.padre.izquierdo;
        
    }
    public VerticeRojinegro getAbuelo(VerticeRojinegro v){}
    public void rebalanceo(){}
}