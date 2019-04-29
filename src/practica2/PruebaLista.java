package practica2;
import java.util.Iterator;

     /**
     *@author Nestor Semer Vazquez Cordero
     *@author Isay Balderas Salomon
     *@version 2.0
     *Clase de prueba para una lista
     *
     */
public class PruebaLista{

	public static void main(String [] args){

		 String [] arr1 = {"uno","dos","tres"};
         String hola="hola";
         String adios="adios";
         String nuevo= "nuevo";
         Object [] nuevo2= new Object[arr1.length];
            
         Lista<String> test= new Lista<String>(arr1);
         Lista<String> test3= new Lista<String>();
         Lista<String> test4= new Lista<String>();
         Lista<String> test5 = new Lista<String>();

         System.out.println("se agrega al final");
         System.out.println();

         test5.agregaFinal(hola);
         System.out.println();
         System.out.println();

         //String destinatario = test5.eliminaPrimero();
         //String recuperacion = test5.saca();

         ///////////////////////////////////////
          System.out.println("Pueba contructor vacio: ");
          Lista<String> test2= new Lista<String>();
          System.out.println("La lista contiene a: dos ? "+test2.contiene("dos") );
          System.out.println("Se agrega nuevo elemento al final");
          String adios2= "adios2";
          test2.agregaFinal(adios2);
          System.out.println("Primer elemento: "+test2.getPrimero());
          test2.agregaFinal(arr1[0]);
          test2.agregaFinal(arr1[1]);
          test2.agregaFinal(arr1[2]);
           System.out.println("Informacion de la lista: "+test2.toString());
           System.out.println("se imprime  elementos de la lista");
           System.out.println();
           for(String it9: test2){

                 System.out.println("el elemento es: "+ it9);
           }
         System.out.println();
         System.out.println();
         System.out.println();

       
         //////////////////////////////////////
         //Lista emptytest = new Lista();
         System.out.println("Longitud: "+test.getLongitud());
         System.out.println("Primer elemento: "+test.getPrimero());
         System.out.println("Segundo elemento: "+test.getEnmedio());
         System.out.println("Ultimo elemento: "+test.getUltimo());
         System.out.println("Longitud: "+test.getLongitud());
         System.out.println();
         System.out.println();
          System.out.println("La lista contiene uno? "+test.contiene("uno"));
         System.out.println();
         //System.out.println("Probamos eliminar dos");
         //System.out.println("se elimino?"+test.elimina("dos"));
         System.out.println();
         System.out.println();
         System.out.println("Informacion de la lista: "+test.toString());
         System.out.println();
         System.out.println();
         test3= test.reversa();
         System.out.println("Reversa de la lista: "+test3.toString());
         System.out.println();
         System.out.println();
         test4= test.copia();
         System.out.println("Copia de la lista: "+test4.toString());
         System.out.println("Longitud: "+test4.getLongitud());
         System.out.println();
         System.out.println();
         System.out.println("Se comparan dos listas (Principal y copia)"+ test.equals(test4));
         System.out.println();
         System.out.println();
         System.out.println("Longitud: "+test.getLongitud());
         System.out.println("Longitud: "+test4.getLongitud());
         System.out.println("Informacion de la lista: "+test.toString());
         //System.out.println("Se comparan dos listas (Principal y copia)"+ test.equals(test4));
         System.out.println();
         System.out.println();
         System.out.print("Se regresa un arreglo: ");
         nuevo2 =test.toArray();
         for(int i=0; i<nuevo2.length;i++)
         	 System.out.print(nuevo2[i]+" ");
         System.out.println();
         System.out.println();
         Iterator <String> it = test.iterator();
         boolean hay;
         System.out.println("hay un primer elemento? "+it.hasNext());
         System.out.println("1) recorriendo el iterador "+ it.next());
         System.out.println("2) recorriendo el iterador "+ it.next());
         System.out.println("3) recorriendo el iterador "+ it.next());
         System.out.println("hay un siguiente elemento? "+it.hasNext());
         System.out.println("hay un siguiente elemento? "+it.hasNext());
         System.out.println("hay un siguiente elemento? "+it.hasNext());
         System.out.println("hay un siguiente elemento? "+it.hasNext());
         System.out.println();
         System.out.println();
         System.out.println();
         System.out.println("¿La lista contiene 'uno'?: "+test.contiene("uno"));
         System.out.println();
         System.out.println();
         System.out.println("Agregando un elemento en la posicion 3");
         test.inserta(3,nuevo);
         System.out.println("Primer elemento: "+test.getPrimero());
         System.out.println("Segundo elemento: "+test.getEnmedio());
         System.out.println("Ultimo elemento: "+test.getUltimo());
         System.out.println("Longitud: "+test.getLongitud());
         System.out.println();
         System.out.println();
         System.out.println("Eliminando 'uno'");
         System.out.println("¿Se elimino 'uno'?: "+test.elimina("uno"));
         System.out.println("Primer elemento: "+test.getPrimero());
         System.out.println("Segundo elemento: "+test.getEnmedio());
         System.out.println("Ultimo elemento: "+test.getUltimo());
         System.out.println("Longitud: "+test.getLongitud());
         System.out.println();
         System.out.println();
         test.agregaInicio(hola);
         System.out.println("Se agrega un elemento");
         System.out.println("Primer elemento: "+test.getPrimero());
         System.out.println("Segundo elemento: "+test.getEnmedio());
         System.out.println("Longitud: "+test.getLongitud());
         System.out.println();
         System.out.println();
         System.out.println("Se agrega nuevo elemento al final");
         test.agregaFinal(adios);
         System.out.println("Ultimo elemento: "+test.getUltimo());
         System.out.println("Longitud: "+test.getLongitud());
         System.out.println("Informacion de la lista: "+test.toString());
         System.out.println();
         System.out.println();
         System.out.println("Se elimina el primer elemento");
         System.out.println("Elemento eliminado: "+test.eliminaPrimero());
         System.out.println("Primer elemento: "+test.getPrimero());
         System.out.println("Longitud: "+test.getLongitud());
         System.out.println();
         System.out.println();
         System.out.println("Se elimina el siguiente elemento");
         System.out.println("Elemento eliminado: "+test.eliminaPrimero());
         System.out.println("Primer elemento: "+test.getPrimero());
         System.out.println("Longitud: "+test.getLongitud());
         System.out.println();
         System.out.println();
         System.out.println("Se elimina el ultimo elemento");
         System.out.println("Elemento eliminado: "+test.eliminaUltimo());
         System.out.println("Ultimo elemento actual: "+test.getUltimo());
         System.out.println();
         System.out.println();
         System.out.println("Limpiando: ");
         test.limpia();
         System.out.println("Longitud: "+test.getLongitud());
         test.agregaInicio("holadenuevo");
         System.out.println("Longitud: "+test.getLongitud());
         System.out.println("Informacion de la lista: "+test.toString());
         Iterator <String> it7 = test.iterator();

         System.out.println("hay un primer elemento? "+it7.hasNext());
         System.out.println("1) recorriendo el iterador "+ it7.next());
         System.out.println("hay un siguiente elemento? "+it7.hasNext());

          System.out.println();
          System.out.println();/**
          System.out.println("Pueba contructor vacio: ");
          Lista<String> test2= new Lista<String>();
          System.out.println("Se agrega nuevo elemento al final");
          String adios2= "adios2";
          test2.agregaInicio(adios2);
         System.out.println("Primer elemento: "+test2.getPrimero());
       */

        }
}