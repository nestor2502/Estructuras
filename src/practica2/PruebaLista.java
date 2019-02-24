package practica2;

public class PruebaLista{

	public static void main(String [] args){

		 String [] arr1 = {"uno","dos","tres"};
         String hola="hola";
         String adios="adios";
         String nuevo= "nuevo";
         String [] nuevo2= new String[7];
            
         Lista<String> test= new Lista<String>(arr1);
         //Lista emptytest = new Lista();
         System.out.println("Longitud: "+test.getLongitud());
         System.out.println("Primer elemento: "+test.getPrimero());
         System.out.println("Segundo elemento: "+test.getEnmedio());
         System.out.println("Ultimo elemento: "+test.getUltimo());
         System.out.println("Longitud: "+test.getLongitud());
         System.out.println();
         System.out.println();
         System.out.println("Se regresa un arreglo");
         //nuevo2 =(String)test.toArray();
         //for(int i=0; i<nuevo2.length;i++)
         	//System.out.println(nuevo2[i]);
         
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
         //System.out.println("Elemento en la posicion 2: "+test.get(2));
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

        }
}