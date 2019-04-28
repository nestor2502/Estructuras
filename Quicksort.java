
public class Quicksort {
	/**Metodo quickSort
	* Metodo que agarra un pivote desde el cual pondra a los demas ya sea a su izquierda(son menores)
	*o a su derecha(son mayores)
	*
	*@param a arreglo a ordenar
	*@param <T> tipo a entrar
	*/
	public static <T extends Comparable<T>> void quickSort(T[] a){
				quicksort(a,0,a.length-1);
	}
	/**Auxiliar de metodo quicksort
	*	Recursivamente va acomodando los elementos dentro del arreglo
	*
	*@param arr arreglo a ordenar
	*@param a primera posicion del arreglo
	*@param b ultima posicion del arreglo
	*/
	 public static <T extends Comparable<T>> void quicksort(T[] arr, int a, int b) {
	 	   if (a < b) {
            int i = a, j = b;
            T x = arr[(i + j) / 2];

            do {
                while (arr[i].compareTo(x) < 0) 
                	i++;
                while (x.compareTo(arr[j]) < 0) 
                	j--;

                if ( i <= j) {
                    T tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    i++;
                    j--;
                }

            } while (i <= j);

            quicksort(arr, a, j);
            quicksort(arr, i, b);
        }
    }
}
