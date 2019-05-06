package practica8;

public class Test{

	 public static void main(String[] args) {

	 	int [] arr = {20, 4, 6, 2, 9, 3, 1};
        //int[] arr = new int[0];
	 	Monticulo m1 = new Monticulo(arr);
	 	m1.muestra();
	 	/**
	 	Ordenamientos or = new Ordenamientos();
	 	or.heapSort(arr);
	 	for(int i:arr){

	 	System.out.println(i);
	 	}
	 	System.out.println();

	 	*/
	 	for(int i:arr){

	 	System.out.println(m1.elimina());
	 	}
	 	//int a = m1.elimina();
	 	//m1.muestra();
	 	//System.out.println();
	   	
	   }
}