package practica8;

import practica2.*;
import java.util.Iterator;
public class Test2 {

	 public Lista <Integer> mezcla(Lista<Integer> l1, Lista <Integer>l2){
         Lista <Integer>l = new Lista<Integer>();
         if(l1.getLongitud()==0&&l2.getLongitud()==0){
              return l;  
         }
         if(l1.getLongitud()==0||l2.getLongitud()==0){
             if(l1.getLongitud()==0){
                l=l2;
                return l;
             }
             if(l2.getLongitud()==0){
                l=l1;
                return l;
             }
         }
           Iterator <Integer> i = l1.iterator();
         Iterator <Integer> j = l2.iterator();
         //Lista <Integer>l = new Lista<T>();
         Integer temp1=null;
         Integer temp2=null;
         int cont1 =0;
         int cont2=0;
         int cont3 =0;
         int cont4=0;
         int lon =l1.getLongitud()+l2.getLongitud();
         int longitud=0;
         int stop=0;

         while(i.hasNext()==true || j.hasNext()==true){

         if(cont3==0){
             temp1 = i.next();}
         if(cont4==0){
             temp2 = j.next();}
             if(cont1==7){
                 temp1 = i.next();}
             if(cont2==7){
                 temp2 = j.next();}
             cont1=0;
             cont2=0;
             cont3++;
             cont4++;
             if(temp1.compareTo(temp2)<=0){
                 if(temp1.compareTo(temp2)<=0){
                     l.agregaFinal(temp1);
                     if(i.hasNext()==true){
                     cont1=7;}
                 }
             }         
             else{
                 //if(temp2.compareTo(temp1)<=0){
                     l.agregaFinal(temp2);
                 //}
                 if(j.hasNext()==true){
                     cont2=7;}                
             }
             
         }   
         return l;
         }
     
     public Lista<Integer> mergesort(Lista<Integer> l){

         Iterator <Integer> itera = l.iterator();
         Lista<Integer> l1 = new Lista<Integer>();
         Lista<Integer> l2 = new Lista<Integer>();
         int longI = l.getLongitud();
         int long1=0;
         int long2=0;
         if(l.getLongitud()==0||l.getLongitud()==1)
             return l;
         if(longI%2 !=0){
            long1=(longI-1)/2;
            long2=((longI-1)/2)+1;
         }
         else{
            long1=longI/2;
            long2=longI/2;
         }
        int i =0;
        int j =0;
         while(i+1<=long1){
            l1.agregaFinal(itera.next());
            i++;
         }
         while(j<long2){
            l2.agregaFinal(itera.next());
            j++;
         }
         l1= mergesort(l1);
         l2=mergesort(l2);
         l=mezcla(l1,l2);
        return l;
     }
     
     public static void main(String[] args) {
     	Integer[] arr = {2,4};
        Integer[] arr2 = {1,3,5,7};
        Integer[] arr3 = {1,3,2,9,6,5,7};
     	Lista<Integer> l1 = new Lista<Integer>(arr);
        Lista<Integer> l5 = new Lista<Integer>(arr3);
        Lista<Integer> l2 = new Lista<Integer>(arr2);
     	System.out.println("Informacion de la lista 1: "+l1.toString());
        System.out.println("Informacion de la lista 2: "+l2.toString());
        Test2 mez = new Test2();
          Lista<Integer> l3= mez.mezcla(l1, l2);
          System.out.println("Informacion de la lista : "+l3.toString());
          System.out.println("Informacion de la lista l2 : "+l2.getLongitud());
          //Lista<Integer> l4=mez.mergesort(l5);
     	 //System.out.println("ordenada: "+l4.toString());
     
	
}}