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
    	double inicio1 = (double)(elementos.length/2);
    	int inicio =(int)inicio1-1; 
	     this.elementos = new int[100];
         ultimoIndice = -1;
         ComparaEnteros compara = new ComparaEnteros();
         comparador = compara;
         for(int i =0; i<elementos.length;i++){
             //se puede modificar este metodo comenzando por la mitad
             //agrega(elementos[i]);
         	 this.elementos[i]=elementos[i];
         	 ultimoIndice++;
         }
         //for(int i=inicio;i>=0;i--){
         
         while(inicio!=-1){
         	 acomoda2(inicio);
         	 inicio--;
         }
    
    }

    public Monticulo(int[] elementos, Comparator<Integer> comparador){
         double inicio1 = (double)(elementos.length/2);
    	int inicio =(int)inicio1-1; 
	     this.elementos = new int[100];
         ultimoIndice = -1;
         //ComparaEnteros compara = new ComparaEnteros();
         this.comparador = comparador;
         for(int i =0; i<elementos.length;i++){
             //se puede modificar este metodo comenzando por la mitad
             //agrega(elementos[i]);
         	 this.elementos[i]=elementos[i];
         	 ultimoIndice++;
         }
         //for(int i=inicio;i>=0;i--){
         
         while(inicio!=-1){
         	 acomoda2(inicio);
         	 inicio--;
         } 
    }
     
     /**
     *Metodo que elimina el primer elemento del arreglo
     *@return eliminado
     */
    public int elimina(){
         if(esVacio()==false){

         int eliminado = elementos[0];
         swap(ultimoIndice, 0);
         elementos[ultimoIndice]=0;
         ultimoIndice--;
         acomoda2(0);
         //System.out.println(":(");
         return eliminado;
         }
         
         return -1;
	
    }

     /**
     *Metodo que acomoda el arreglo des de un nodo de arriba hacia abajo
     *sirve para eliminar
     *@param index
     */
     public void acomoda2(int indice){
        //mayor que hijo izquierdo?
         boolean mayor1=false;
         //mayor que hijo derecho?
         boolean mayor2=false;

          if(esHoja(indice) == true)
             return;
       
         if(esHoja(indice)==false){
             if(comparador.compare(elementos[indice], elementos[hi(indice)])>0){
                 mayor1= true;}
         }
         if(esHoja(indice)==false){
             if(comparador.compare(elementos[indice], elementos[hd(indice)])>0){
                 mayor2= true;
             }
         }

         //si el elemento es mayor a ambos hijos
         if(mayor1==true&&mayor2==true){
             int index = minimo(indice);
             swap(indice, index);
             //int indiceAux2= indice2;
             acomoda2(index);
             //return;    
         }
         //si es mayor que solo uno(izquierdo)
         if(mayor1==true&&mayor2==false){
             int index = hi(indice);
             swap(indice, index);
             //int indiceAux2= indice2;
             acomoda2(index);
             //return;
         }
         //si es mayor que solo uno(derecho)
         if(mayor1==false&&mayor2==true){
             int index = hd(indice);
             swap(indice, index);
             //int indiceAux2= indice2;
             acomoda2(index);
             //return;
         }       

     }

     /**
     *metodo que returna la posicion a la cual debe intercambiar
     */
     public int minimo(int i){
         if(comparador.compare(elementos[hd(i)], elementos[hi(i)])>=0)
            return hi(i);
         else if(comparador.compare(elementos[hd(i)], elementos[hi(i)])<0)
            return hd(i);
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
         
         if(ultimoIndice+1==elementos.length-1){
             int []  nuevo = new int[elementos.length*2];
             for(int j =0; j< elementos.length;j++){
                 nuevo[j]= elementos[j];
                 elementos= nuevo;
             }
         }
         ultimoIndice++;
         elementos[ultimoIndice]=i;
         indiceAux = ultimoIndice;
         acomoda(ultimoIndice);
         
	
    }
    
    /**
    *Metodo que acomoda despues de balancear
    *sirve para agregar
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
    public int hi(int i){
         return (2*i+1);
    }

    /**
    *Metodo que retorna la posicion del hijo derecho
    *@param posicion
    *@return hijo derecho
    */
    public int hd(int i){
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

     public boolean esHoja(int index){
         if(((2*index+1)>ultimoIndice)&&((2*index+2)>ultimoIndice)){
            return true;}
         return false;
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
        if(a==b)
            num = 0;
         return num;
         
     }
}