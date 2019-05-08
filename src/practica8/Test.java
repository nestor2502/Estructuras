package practica8;

public class Test{

	 public static void main(String[] args) {

	 	int [] arr = {20, 4, 6, 2, 9, 3, 1};
        //int[] arr = new int[0];
        System.out.println("primer monticulo");
	 	Monticulo m1 = new Monticulo(arr);
	 	m1.muestra();
	 	int [] arr2= new int[arr.length];
	 	/**
	 	for(int i =0;i< arr2.length;i++){

	 		arr2[i]=m1.elimina();
	 	}

	 	/**
	 	Ordenamientos or = new Ordenamientos();
	 	or.heapSort(arr);
	 	for(int i:arr){

	 	System.out.println(i);
	 	}
	 	System.out.println();

	 	*/
	 	System.out.println();
	 	System.out.println();
	 	System.out.println("se elimina la raiz");
	 	//m1.agrega(0);
	 	//m1.muestra();
	 	System.out.println(m1.elimina());
	 	System.out.println("elementos restantes");
        m1.muestra();
        System.out.println();
        System.out.println();
        System.out.println();
	 	System.out.println();
	 	System.out.println("se elimina la raiz");
	 	//m1.agrega(0);
	 	//m1.muestra();
	 	System.out.println(m1.elimina());
	 	System.out.println("elementos restantes");
        m1.muestra();
        System.out.println();
        System.out.println();
        System.out.println();
	 	System.out.println();
	 	System.out.println("se elimina la raiz");
	 	//m1.agrega(0);
	 	//m1.muestra();
	 	System.out.println(m1.elimina());
	 	System.out.println("elementos restantes");
        m1.muestra();
        System.out.println();
        System.out.println();
	 	/**for(int i:arr2){

	 	System.out.println(i);
	 	}*/
	 	//int a = m1.elimina();
	 	//m1.muestra();
	 	//System.out.println();
	   	
	   }
}