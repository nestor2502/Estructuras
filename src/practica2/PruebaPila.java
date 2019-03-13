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

             Pila <String> test = new Pila <String>(arr1);
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
             System.out.println("el primer elemento es: "+it.next());
             System.out.println("Hay un primer elemento en la lista?"+it.hasNext());
             System.out.println("el primer elemento es: "+it.next());
             System.out.println("Hay un primer elemento en la lista?"+it.hasNext());
              System.out.println("el primer elemento es: "+it.next());
               System.out.println("el primer elemento es: "+it.next());
               System.out.println("Hay un primer elemento en la lista?"+it.hasNext());




     	}
     }
