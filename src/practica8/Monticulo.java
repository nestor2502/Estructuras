package practica8;
import java.util.Comparator;
/**
 * Clase que implementa montículos mínimos y montículos máximos con enteros.
 */
public class Monticulo {

    private int[] elementos;
    private Comparator<Integer> comparador;
    private int ultimoIndice;
    int indiceAux=0;
    
    /**
    *Constuctor vacio
    *
    */
    public Monticulo(){
	     
         elementos = new int[100];
         ultimoIndice = -1;
         ComparaEnteros compara = new ComparaEnteros();
         comparador = compara;
    }
    
    /**
    *Constructor que recibe un comparador
    *@param comparador
    */
    public Monticulo(Comparator<Integer> comparador){

	     elementos = new int[100];
         ultimoIndice = -1;
         this.comparador = comparador;
    }
    
    /**
    *Constructor que recibe un arreglo 
    *@param elementos
    */
    public Monticulo(int[] elementos){
	     this.elementos = new int[100];
         ultimoIndice = -1;
         ComparaEnteros compara = new ComparaEnteros();
         comparador = compara;
         for(int i =0; i< elementos.length;i++){
             //se puede modificar este metodo comenzando por la mitad
             agrega(elementos[i]);
         }
    }

    public Monticulo(int[] elementos, Comparator<Integer> comparador){
         this.comparador = comparador;
         for(int i=0; i< elementos.length;i++){
             //se puede modificar este metodo comenzando por la mitad
             agrega(elementos[i]);
         }  
    }

    public int elimina(){
	// Aquí va su código.
        return -1;
    }

    public boolean contiene(int elemento){
	      
         for(int i=0;i<elementos.length;i++){
             if(elementos[i]==elemento)
                 return true; 
          }
         return false;
    }

    public boolean esVacio(){ 
         if(ultimoIndice==-1)
         return true;
         else
         return false;
    }

    public int getTamano(){
	     return ultimoIndice+1;
    }

    public void agrega(int i){
         //si el arreglo está lleno se grea un nuevo arreglo con el doble del tamaño
         /**
         if(ultimoIndice+1==elementos.length-1){
             int []  nuevo = new int[elementos.length*2];
             for(int j =0; j< elementos.length;j++){
                 nuevo[j]= elementos[j];
                 elementos= nuevo;
             }
         }*/

         ultimoIndice++;
         elementos[ultimoIndice]=i;
         indiceAux = ultimoIndice;
         acomoda(ultimoIndice);
         
	
    }
    
    /**
    *
    *
    */
    public void acomoda(int indice){
        //int indice = i;
        if(indice == 0)
             return;
        //si el elemento es mayor o igual a si padre terminamos
        if(comparador.compare(elementos[indice], elementos[getPadre(indice)])>=0){
             return;
        }
         //si el elemento es menor a su padre se hace swap y recursion
         if(comparador.compare(elementos[indice], elementos[getPadre(indice)])<0){

             int indice2= getPadre(indice);
             swap(indice, indice2);
             //int indiceAux2= indice2;
             acomoda(indice2);
         }

    }

    /**
    *Metodo que retorna la posicion del padre
    *@param posicion
    *@return padre
    */
    public int getPadre(int i){
         int padre =0;

         if(i == 0)
             return 0;

         else{
             double padrem = (i-1)/2;
             padre = (int)padrem;
         }
         return padre;
    }

     /**
    *Metodo que retorna la posicion del hijo izquierdo
    *@param posicion
    *@return hijo izquierdo
    */
    public int getIzquierdo(int i){
         return (2*i+1);
    }

    /**
    *Metodo que retorna la posicion del hijo derecho
    *@param posicion
    *@return hijo derecho
    */
    public int getDerecho(int i){
         return (2*i+2);
    }
     
     /**
    *Metodo que hace swap
    *@param a
    *@param b
    */
    public void swap(int a, int b){
         int temp = elementos[a];
         elementos[a]= elementos[b];
         elementos[b]=temp;
    }

    public void muestra(){
         for(int i =0; i< ultimoIndice+1;i++){

            System.out.println(elementos[i]+"     "+i);
         }
    }

}

 class ComparaEnteros implements Comparator<Integer>{
     @Override
     public int compare(Integer a, Integer b){
         int num =0;
         if(a>b)
           num =  1;
        if(a<b)
            num= -1;
        if(a>b)
            num = 0;
         return num;
         
     }
}