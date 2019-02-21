package practica2;
import java.util.Iterator;

    import java.util.Iterator;
    import java.util.NoSuchElementException;


    /**
     * Implementación de listas ligadas.
     */
    public class Lista<T> implements Iterable<T>{

        ////////////////////////////////////////////////////////////////

        // Clase interna para representar los nodos de nuestras listas.
        private class Nodo{
        
        public T elemento;
        public Nodo siguiente;
        public Nodo anterior;
        
        public Nodo(T elemento){
            
            this.elemento = elemento;
        }

        }


    ///////////////////////////////////////////////////////////////////////


        // Clase para iterar la lista.
        private class Iterador implements Iterator<T>{

        public Nodo siguiente;

        public Iterador(){

             siguiente = cabeza;

         }

        @Override
        public boolean hasNext(){


             return (siguiente!=null);
             
             //return true;

             //else 

             //return false;
            
         }
        
         /**
         *Regresa el siguiente elemento en la iteracion
         */
         @Override
         public T next() throws NoSuchElementException{

            if(siguiente == null){
                
             throw new NoSuchElementException();

             }

                else{

                 T aux = siguiente.elemento;

                 siguiente = siguiente.siguiente;


                 return aux;
                 
                 }      
        }
        }
    //////////////////////////////////////////////////////////////////////////


        private Nodo cabeza;
        private Nodo ultimo;
        private int longitud=0;
        
        /**
        *Constructor vacio
        */
        public Lista(){

        cabeza = null;
        cabeza.siguiente = ultimo;
        cabeza.anterior= null;
        ultimo = null;
        ultimo.siguiente=null;
        ultimo.anterior=cabeza;

        }


        /**
        *Constructor que toma un arreglo y mete sus elementos a la lista 
        */
        public Lista(T[] arreglo){

             int tamaño = arreglo.length;

             if(tamaño==0){
                  cabeza = null;
                  cabeza.siguiente = ultimo;
                  cabeza.anterior= null;
                  ultimo = null;
                  ultimo.siguiente=null;
                  ultimo.anterior=cabeza;

                 }

             if (tamaño==1){

                 Nodo n1 = new Nodo(arreglo[0]);

                 cabeza= n1;
                 cabeza.siguiente=null;
                 cabeza.anterior=null;
                 ultimo=n1;
                 ultimo.siguiente=null;
                 ultimo.anterior=null;

                 this.longitud ++;
                 
                 }
             
             if(tamaño>1){

                     Nodo n1 = new Nodo(arreglo[0]);
                     cabeza = n1;
                     ultimo= n1;
                     cabeza.anterior= null;
                     cabeza.siguiente=null;
                     ultimo.anterior= null;
                     ultimo.siguiente= null;
                     this.longitud++;


                 for(int i= 1;i<tamaño;i++ ){
                        
                        //Nodo n2= new Nodo(arreglo[i]);           

                         agregaFinal(arreglo[i]);
                         
                         this.longitud++;

                     }

                    
             }
          }
         
        

        /**
        *Regresa el primer elemento de la lista
        */
        //si la lista es vacía, deben lanzar una NoSuchElementException.
        public T getPrimero(){
        
             return cabeza.elemento;

         }
        public T getEnmedio(){
            return cabeza.siguiente.elemento;
        }

        /**
        *Regresa el ultimo elemento de la lista, 
        */
        //si la lista es vacía, deben lanzar una NoSuchElementException.
        public T getUltimo(){
            
             return ultimo.elemento;

         }
        

        /**
        *Elimina el primer elemento de la lista, si la lista es vacia 
        *@throws NoSuchElementException 
        */
        //debe lanzar NoSuchElementException
        public T eliminaPrimero() throws NoSuchElementException{

                Nodo temp;

             if(longitud == 0){

                 throw new NoSuchElementException();
                 }

             if(longitud == 1){
                
                 temp = new Nodo (cabeza.elemento);            
                 cabeza = null;
                 cabeza.anterior= null;
                 cabeza.siguiente = null;
                 

                 ultimo = null;
                 ultimo.anterior= null;
                 ultimo.siguiente = null;
                 longitud--;
                  return temp.elemento;
                 }

             if(longitud > 1){

                 temp = new Nodo (cabeza.elemento);

                 cabeza.siguiente.anterior=null;
                 cabeza= cabeza.siguiente;

                 //cabeza.anterior= null;


                 
                 longitud--;
                  return temp.elemento;
                 }

                 
          return cabeza.elemento;
                
         }
        

        /**
        *Elimina el ultimo elemento de la lista, si la lista es vacia 
        *@throws NoSuchElementException
        */
        //debe lanzar NoSuchElementException
        public T eliminaUltimo() throws NoSuchElementException{

                 Nodo temp2; 
                 Nodo temp5;

             if(longitud==0)

                 throw new NoSuchElementException();

             if(longitud == 1){

                 temp2 = new Nodo(ultimo.elemento);
               
                 ultimo = null;

                 cabeza = null;
                 
                 longitud--;
                 }

             if(longitud > 1){

                 temp2 = new Nodo(ultimo.elemento);

                 ultimo = ultimo.anterior;

                 ultimo.siguiente = null;

                 longitud--;

                 }

                 temp2 = new Nodo (cabeza.elemento);

             
                 return temp2.elemento;
        
        }
        

        /**
        *Recibe un elemento y lo agrega al inicio de la lista
        */
        public void agregaInicio(T t){

             Nodo nuevoElemento = new Nodo(t);

            // cabeza.siguiente.anterior= nuevoElemento;

             cabeza.anterior= nuevoElemento;

             nuevoElemento.siguiente = cabeza;

             nuevoElemento.anterior= null;

             cabeza= nuevoElemento;

             //cabeza.anterior = nuevoElemento; 

             longitud++;       

        }
        

        /**
        *Recibe un elemento y lo agrega al final de la lista
        */
        public void agregaFinal(T t){

             Nodo nuevoElemento = new Nodo(t);

             ultimo.siguiente = nuevoElemento;

             nuevoElemento.anterior= ultimo;

             nuevoElemento.siguiente = null;

             ultimo= nuevoElemento;

             longitud++;
             


        
        }
        

        /**
        *Recibe un elemento, si el elemento se encuentra en la lista devuelve true
        *si no false 
        */
        public boolean contiene(T t){

             
                
            if(t == null){
                return false;
            }
            else{

                return true;
            }

        
        }
        

        /**
        *regresa la longitud de la lista
        *@return longitud 
        */
        public int getLongitud(){

             return longitud;

        }
        

        /**
        *Recibe un elemento y elimina su primera ocurrencia en la lista,
        *devuelve true si el elemento se eliminó, false en otro claso
        */
        public boolean elimina(T t){
        // Aquí va su código.
            return true;
        }
        

        /**
        *Vacía la lista
        */
        public void limpia(){
        
        cabeza= ultimo;
        cabeza = null;
        cabeza.siguiente=null;
        cabeza.anterior= null;

        }
        

        /**
        *Este método toma un índice i y regresa el i-ésimo elemento de la lista.
        */
        //Deben lanzar una IndexOutOfBoundsException si el índice es menor a 0 o mayor o igual al tamaño de la lista.
        public T get(int indx){

        return cabeza.elemento;
        }
        

        /**
        *Toma un índice i y un elemento y mete el elemento en la posición i de la lista.
        //
        */
        public void inserta(int indx, T t){
        // Aquí va su código.
        }
        

        /**
        *Este método nos regresa un arreglo con los mismos elementos de nuestra lista en el mismo orden.
        */
        //public Object[] toArray(){
        // Aquí va su código.
        //}
        

        /**
        *Este método nos regresa una lista con los elementos de nuestra lista en orden inverso. 
        */
        //public Lista<T> reversa(){
        // Aquí va su código.
        //}

        

        /**
        *Este método nos regresa una copia de nuestra lista.
        */
        //public Lista<T> copia(){
        // Aquí va su código.
        //}


        /**
        *El método regresa una cadena con la información de nuestra lista.
        */
        //@Override
        //public String toString(){
            // Aquí va su código.
        //}

        /**
        *Deben regresar true si el objeto recibido es igual a la lista y false en otro caso.
        */
        //@Override
        //public boolean equals(Object o){
            // Aquí va su código.
        //}


        /**
        *Este método pertenece a la interfaz Iterable
        */
        @Override
        public Iterator<T> iterator(){
        
        return new Iterador();

        }


        public static void main(String [] args){
            String [] arr1 = {"uno","dos","tres"};
            String hola="hola";
            String adios="adios";

            Lista<String> test= new Lista<String>(arr1);
            //Lista emptytest = new Lista();
            System.out.println("Longitud: "+test.getLongitud());
            System.out.println(test.getPrimero());
            System.out.println(test.getEnmedio());
            System.out.println(test.getUltimo());
            test.agregaInicio(hola);
            System.out.println(test.getPrimero());
            System.out.println("Longitud: "+test.getLongitud());
            System.out.println(test.getPrimero());
            test.agregaFinal(adios);
            System.out.println(test.getUltimo());
            System.out.println("Longitud: "+test.getLongitud());
            System.out.println("se elimina el primer elemento");
            System.out.println(test.eliminaPrimero());
            System.out.println(test.getPrimero());
            System.out.println("Longitud: "+test.getLongitud());
            System.out.println("se elimina el siguiente elemento");
            System.out.println(test.eliminaPrimero());
            System.out.println(test.getPrimero());
            System.out.println("Longitud: "+test.getLongitud());
            //System.out.println(test.getUltimo());

        }
    }
