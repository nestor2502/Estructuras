package practica2;
import java.util.Iterator;

     /**
     *@author Nestor Semer Vazquez Cordero
     *@author Isay Balderas Salomon
     *@version 2.0
     *Clase de prueba para una pila
     *
     */
     public class PruebaPila{

     	public static void main(String [] args ){



             String [] arr1 = {"uno","dos","tres"};
             String hola="hola";
             String adios="adios";
             String nuevo= "nuevo";
              Object [] nuevo2= new Object[arr1.length];
             Lista <String> test2 = new Lista <String>(arr1);
             System.out.println();


             Pila <String> test = new Pila <String>(arr1);
             Pila <String> test7 = new Pila <String>(arr1);
               System.out.println("Pila1 "+ test.toString());
             System.out.println("Pila 2"+ test7.toString());
             System.out.println("La pila 1 es igual a la pila 2?"+ test.equals(test7));

             Pila <String> test8 = new Pila <String>();
             System.out.println("Se agregan los siguientes Elementos: "+ test2.toString());
             System.out.println();
             System.out.println();
             System.out.println("Elementos de la pila "+test.toString());
             System.out.println();
             System.out.println();
             System.out.println("¿Es vacia? "+test.esVacia());
             System.out.println();
             System.out.println();
             System.out.println("El siguente elemento: "+ test.mira());
             System.out.println();
             System.out.println();
             System.out.println("agrega un elemento: ");
             	test.mete(hola);
                System.out.println("Longitud: "+test.getLong());
             System.out.println("Elementos de la pila "+test.toString());
             System.out.println();
             System.out.println();
             System.out.println("elimina un elemento: ");
             	test.saca();
                System.out.println("Longitud: "+test.getLong());
             System.out.println("Elementos de la pila "+test.toString());
                          System.out.println();
             System.out.println();
             System.out.println("elimina un elemento: ");
                test.saca();
                System.out.println("Longitud: "+test.getLong());
             System.out.println("Elementos de la pila "+test.toString());
            


             Iterator <String> it = test.iterator();
             System.out.println();
             System.out.println();
             System.out.println("Hay un primer elemento en la lista?"+it.hasNext());
             System.out.println("el primer elemento es: "+it.next());
             System.out.println("Hay un primer elemento en la lista?"+it.hasNext());
              System.out.println();
             System.out.println();

              System.out.println("Se usa constyructor vacio: ");
              test8.mete(hola);
              test8.mete(nuevo);
              test8.mete(adios);
             System.out.println();
             Iterator <String> it2 = test8.iterator();
             System.out.println();
             System.out.println();
             System.out.println("Hay un primer elemento en la lista?"+it2.hasNext());
             System.out.println("el primer elemento es: "+it2.next());
             System.out.println("Hay un primer elemento en la lista?"+it2.hasNext());
              System.out.println("el primer elemento es: "+it2.next());
             System.out.println("Hay un primer elemento en la lista?"+it2.hasNext());
             System.out.println("el primer elemento es: "+it2.next());
             System.out.println("Hay un primer elemento en la lista?"+it2.hasNext());
             System.out.println();
             
             




          
           
             for(String it3: test7){

                 System.out.println("El elemento es: "+it3);

               }


     	}
     }
