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
       T ele = v.elemento;
       VerticeRojinegro ver =(VerticeRojinegro) buscaVertice(ele);

       return ver.color;
    }
   
    protected void setColor(Vertice v, Color c){
        
        //metodo pendiente por implementacion
        VerticeRojinegro ve =(VerticeRojinegro)v;
        
         ve.color = c;
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
     
     VerticeRojinegro ve  = v;

     if(v.padre.padre.izquierdo==v.padre)
         ve =  (VerticeRojinegro)v.padre.padre.derecho;

     else if(v.padre.padre.derecho==v.padre)
         ve = (VerticeRojinegro)v.padre.padre.izquierdo;

     return ve;
        
    }
    public VerticeRojinegro getAbuelo(VerticeRojinegro v){

        return(VerticeRojinegro) v.padre.padre;
    }


    public void rebalanceo(VerticeRojinegro v){

     // Caso 1

         if(v.padre== null){

          v.color = Color.NEGRO;

          return;
         }
     
         if(v.padre != null){

             VerticeRojinegro p = v.padre;

     //Caso 2

             if(p.color== Color.NEGRO){

                return ;
             }

         //Caso 2.1

              //p rojo, hay abuelo (a) y un tio(t)
             if(p.color== Color.ROJO){
                 VerticeRojinegro a = v.padre.padre;

             if(v.padre.padre.izquierdo == v.padre)  
                 VerticeRojinegro t = v.padre.padre.derecho;

             if(v.padre.padre.derecho == v.padre)
                  VerticeRojinegro t = v.padre.padre.izquierdo;

     //Caso 3

             if(t.color == Color.ROJO || t == null){

                //coloreamos a t y p de negro y a de rojo

                 p.color = Color.NEGRO;
                 t.color = Color.NEGRO;
                 a.color = Color.ROJO;

                 rebalanceo(a);
                 return;

             }
     
         //Caso 3.1 t es negro o es dstinto a null

             if(t.color == Color.NEGRO || t != null){

     //Caso 4

             // v y p estan cruzados, 1.- izquierdo, 2.- derecho
             
             int direccionP;
             int direccionV;

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

                 VerticeRojinegro temp = v;

                 v= p;
                 p= temp;
             } 
     
     //Caso 5
             if(direccionV == direccionP){

                 p.color = Color.NEGRO;
                 a.color = Color.ROJO;

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