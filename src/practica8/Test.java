package practica8;

public class Test{

	 public static void main(String[] args) {

	 	int [] arr = {20, 4, 6, 2, 9, 3, 1};
        //int[] arr = new int[0];
	 	Monticulo m1 = new Monticulo(arr);
	 	m1.muestra();
	 	System.out.println();
	 	System.out.println();

	 	
	 	int a = m1.elimina();
	 	System.out.println(a);
	 	m1.muestra();
	 	System.out.println();
	   	
	   }
}