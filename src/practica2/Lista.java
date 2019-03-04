package practica2;
import java.util.Iterator;

    import java.util.Iterator;
    import java.util.NoSuchElementException;


    /**
     * Implementación de listas ligadas.
     */
    public class Lista<T> implements Iterable<T>{


        // Clase interna para representar los nodos de nuestras listas.
        
        private class Nodo{
        
        public T elemento;
        public Nodo siguiente;
        public Nodo anterior;
        
        public Nodo(T elemento){
            
            this.elemento = elemento;
        }

        }

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

                 longitud ++;
                 
                 }
             
             if(tamaño>1){

                     Nodo n1 = new Nodo(arreglo[0]);
                     cabeza = n1;
                     ultimo= n1;
                     cabeza.anterior= null;
                     cabeza.siguiente=null;
                     ultimo.anterior= null;
                     ultimo.siguiente= null;
                     longitud++;


                 for(int i= 1;i<tamaño;i++ ){           

                         agregaFinal(arreglo[i]);
                         
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

                 Nodo temp2 = new Nodo(ultimo.elemento); 
                 Nodo temp5;

             if(longitud==0)

                 throw new NoSuchElementException();

             if(longitud == 1){
               
                 ultimo = null;

                 cabeza = null;
                 
                 longitud--;

                 return temp2.elemento;
                 }

             if(longitud > 1){

                 temp2 = new Nodo(ultimo.elemento); 

                 ultimo = ultimo.anterior;

                 ultimo.siguiente = null;

                 longitud--;

                 return temp2.elemento;
                 }

               

             return temp2.elemento;
        
        }
        

        /**
        *Recibe un elemento y lo agrega al inicio de la lista
        */
        public void agregaInicio(T t){

             Nodo nuevoElemento = new Nodo(t);

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

             Nodo n1 = new Nodo(cabeza.elemento);
             boolean resul=false;

             n1=cabeza;
             if(longitud==0)
                 return false;

             if(cabeza.elemento == t)
                 return true;

             int cont=0;

             while(cont <=longitud-2){

                 cabeza= cabeza.siguiente;

                 if(cabeza.elemento == t)
                     resul =  true;

                 cont++;

             }

             cabeza = n1;

             return resul;
        
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

             int cont=0;
             int cont2=0;  //contador para encontrar la primera incidencia
             boolean valor=false;
             Nodo n1 = new Nodo(cabeza.elemento);
             n1=cabeza;

             if(contiene(t)==false){

                return false;

             }

             if((longitud == 1) & (cabeza.elemento == t)){

                 limpia();
                 return contiene(t);
             }


             if(cabeza.elemento == t){
                 /**
                 cabeza=cabeza.siguiente; 
                 cabeza.anterior.siguiente= null;
                 cabeza.anterior= null;
                 longitud--;
                 */
                 eliminaPrimero();
                 valor = true;
             }

             else {//comienza a recorrer la lista a partir del segundo elemento
                 
                 while(cont2 <1){

                     cabeza = cabeza.siguiente;



                     if(cabeza.elemento == t){

                        if(cabeza.siguiente == null){
                              
                             cabeza.anterior.siguiente=null;
                             ultimo = cabeza.anterior;
                             //cabeza.siguiente.anterior=cabeza.anterior;
                             //eliminaUltimo();
                             cabeza= ultimo;
                             cont2++;
                             longitud--;
                             }

                         if(cabeza.siguiente != null){
                      
                             cabeza.anterior.siguiente=cabeza.siguiente;
                             cabeza.siguiente.anterior=cabeza.anterior;    
                             cont2++;
                             longitud--;
                             }
                             
                         valor = true;
 
                         }
                
                     cont++;
                     
                     }

                     cabeza=n1;
                 }
             
             
             return valor;

         }
        

        /**
        *Vacía la lista
        */
        public void limpia(){
        
         cabeza.siguiente=null;
         cabeza = null;

         ultimo.anterior= null;
         ultimo = null;
         
         longitud=0;

        }
        

        /**
        *Este método toma un índice i y regresa el i-ésimo elemento de la lista.
        */
        //Deben lanzar una IndexOutOfBoundsException si el índice es menor a 0 o mayor o igual al tamaño de la lista.
        public T get(int indx)throws IndexOutOfBoundsException{

             int cont=0;
             Nodo n1 = new Nodo(cabeza.elemento);
             n1= cabeza;

             if(indx<0 || indx>=longitud){

                 throw new IndexOutOfBoundsException();

                 }

             if(indx>0 && indx<longitud){

                
                 while(indx!=cont){
                     cabeza= cabeza.siguiente;
                     cont++;
                
                     }
                 Nodo n2= new Nodo(cabeza.elemento);
                 cabeza = n1;
                 return n2.elemento;
                 }

         return cabeza.elemento;
         }
        

        /**
        *Toma un índice i y un elemento y mete el elemento en la posición i de la lista.
        //
        */
        public void inserta(int indx, T t)throws IndexOutOfBoundsException{

             Nodo n1 = new Nodo(t);
             Nodo n2 = new Nodo(cabeza.elemento);
             n2=cabeza;
             int j = 1;

             if(indx<0 || indx>longitud+1){

                 throw new IndexOutOfBoundsException();
                 
             }

             if(longitud == 0 || indx==0)
                 agregaInicio(t);

             if(indx==longitud){
                 agregaFinal(t);
                 }

             else if(longitud > 0 && j<longitud){ 

                 while(j <= longitud){

                      cabeza= cabeza.siguiente;

                      if(j == indx){

                        cabeza.anterior.siguiente = n1;
                        cabeza.anterior= n1;
                        cabeza.anterior.siguiente = cabeza;
                        cabeza.anterior.anterior = cabeza.anterior.anterior;
                        cabeza = n1;

                      }
                     j++;
                 }
             cabeza = n2;
             longitud++;
             }
        }
        

        /**
        *Este método nos regresa un arreglo con los mismos elementos de nuestra lista en el mismo orden.
        */
        public Object[] toArray(){
         
             Object [] nuevo = new Object[longitud];

             Nodo n1 = new Nodo(cabeza.elemento);

             n1 = cabeza;

             nuevo [0]= cabeza.elemento;

             int cont = 1;

              while(cont<longitud){

                 cabeza = cabeza.siguiente;

                 nuevo[cont]=cabeza.elemento;
           
                 cont++;

                 }
           
              cabeza= n1;
              return nuevo;
        }
        

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
        @Override
        public String toString(){

            Nodo n1 = new Nodo(cabeza.elemento);
            n1= cabeza;
            String  nuevo ="";

            if(longitud==1){
                nuevo = "[ "+cabeza.elemento.toString()+" ]";
            }
             
             if (longitud>1){

                 nuevo= "["+cabeza.elemento+", ";

                 for(int i=0; i<=longitud;i++){

                     cabeza= cabeza.siguiente;

                     if(i<longitud){

                         nuevo=nuevo+cabeza.elemento.toString()+", ";
                         }

                     if(i= longitud)
                         nuevo = nuevo+cabeza.elemento.toString()+" ]";

                     }

                     cabeza=n1;
             }


          return nuevo;
         }

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

    }
