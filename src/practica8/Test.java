package practica8;

public class Test{

	 public static void main(String[] args) {
        
	 	int [] arr = {20, 4, 6, 2, 9, 3, 1};
        //int[] arr = new int[0];
        System.out.println("primer monticulo");
	 	Monticulo m1 = new Monticulo(arr);
	 	m1.muestra();
	 	System.out.println("Ultimo indice"+ m1.getUltimoIndice());
	 	System.out.println();
	 	System.out.println("se agrega un elemtno");
	 	m1.agrega(50);
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
        System.out.println();
	 	System.out.println();
	 	/**for(int i:arr2){

	 	System.out.println(i);
	 	}*/
	 	//int a = m1.elimina();
	 	//m1.muestra();
	 	//System.out.println();
	 	/**
	   	System.out.println("Prueba de heapSort");
	   	
	   	int [] arr3 = {4,10,27,42,41,26,31,44,33,19,45,67,89,1,23,56,33,33};
	   	Ordenamientos ordena = new Ordenamientos();
	   	System.out.println("Original");
	   	System.out.println();
	   	for(int i:arr3){

	 	System.out.println(i);
	 	}
	   	ordena.heapSort(arr3);
	   	System.out.println();
	   	System.out.println("Ordenado");
	   	System.out.println();
	   	for(int i:arr3){

	 	System.out.println(i);
	 	}

	 	System.out.println("");
	 	System.out.println("");
	 	System.out.println("Prueba con monticulo maximo");
	 	
	 	int [] arrm = {20, 4, 6, 2, 9, 3, 1,50};

	 	Monticulo m2 = new Monticulo(arrm, (a, b)->{
         	  int num =0;
         if(a<b)
           num =  1;
        if(a>b)
            num= -1;
        if(a==b)
            num = 0;
         return num;
         });

	 	m2.muestra();

*/



	   }
}