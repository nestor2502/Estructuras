package practica8;
import practica2.Lista;
/**
 * Clase con varios métodos para ordenar arreglos y listas.
 */
public class Ordenamientos{/**
    
    public static <T extends Comparable<T>> Lista<T> mergesort(Lista<T> l){
	     Iterator <T> it = l.iterator();
         int longitud = l.getLongitud();
         

         //return l1;

    }
     /**
     *Metodo auxiliar de mergesort
     *@param l1
     *@param l2
     *@return l
     */
    /** public Lista <T extends Comparable<T>> Lista<T> mezcla(Lista<T> l1, Lista <T>l2){
         Iterator <T> i = l1.iterator();
         Iterator <T> j = l2.iterator();
         Lista <T>l = new Lista<T>();
         T temp1=null;
         T temp2=null;
         int cont1 =0;
         int cont2=0;
         int lon =l1.getLongitud()+l2.getLongitud();
         int longitud=0;

         if(cont1==0){
             temp1 = i.next();}
         if(cont2==0){
             temp2 = j.next();}
         while(i.hasNext()==true && j.hasNext()==true){
             if(cont1==7){
                 temp1 = i.next();}
             if(cont2==7){
                 temp2 = j.next();}
             cont1=0;
             cont2=0;
             if(temp1.compareTo(temp2)<=0){
                 if(temp1.compareTo(temp2)<=0){
                     l.agregaFinal(temp1);
                     if(i.hasNext()==true){
                     cont1=7;}
                 }
             }         
             else{
                 if(temp2.compareTo(temp1)<=0){
                     l.agregaFinal(temp2);
                 }
                 if(j.hasNext()==true){
                     cont2=7;}                
             }
             if(i.hasNext()==false){
                 l.agregaFinal(temp1);
             }
             if(j.hasNext()==false){
                 l.agregaFinal(temp2);
             }
         }
       
         if(i.hasNext()==true){
             while(i.hasNext()==true){
                 l.agregaFinal(i.next());
             }
         }
         if(j.hasNext()==true){
             while(j.hasNext()==true){
                 l.agregaFinal(j.next());
             }
         }        
         return l;
     }


    public static <T extends Comparable<T>> void quicksort(T[] a){
	// Aquí va su código.
    }
    
    public static <T extends Comparable<T>> int busquedaBinaria(T[] a, T elem, int inicio, int fin){
	// Aquí va su código.
        return -1;
    }

    public static <T extends Comparable<T>> void bubbleSort(T[] a){
	     int swap = 1, outCounter, inCounter; 
         T temp;
         for (outCounter = a.length - 1; outCounter > 0 && swap == 1; outCounter--){
             swap = 0;
             for (inCounter = 0; inCounter < outCounter; inCounter++){
                 if (a[inCounter].compareTo(a[inCounter+1]) > 0){
                     temp = a[inCounter];
                     a[inCounter] = a[inCounter+1];
                     a[inCounter+1] = temp;
                     swap = 1;   
                  }
             }
         }
    }
    
    public static <T extends Comparable<T>> void selectionSort(T[] a){
    // Aquí va su código.  
    }*/

    public static void heapSort(int[] a){

    	 Monticulo m1 = new Monticulo(a);
    	 
    	 for(int i=0;i< a.length;i++){
    	 	 a[i]=m1.elimina();

    	 }
         //a = arr;


	     
    }
}