package practica5;

public class TestArboles{
	public static void main(String [] args){

			ArbolBinarioBusqueda <Integer> tree = new ArbolBinarioBusqueda <Integer>();
		tree.agrega(50);
		tree.agrega(30);
		tree.bfs(i-> System.out.println(i));
		//tree.agrega(20);
		//tree.agrega(45);
		//tree.agrega(15);
		//tree.agrega(25);
		//tree.agrega(35);
		//tree.agrega(48);
		//tree.agrega(24);
//		tree.agrega(11);
		tree.giraDerecha(tree.raiz());
		tree.bfs(i-> System.out.println(i));
	
//		tree.recorrido_en_orden(tree.raiz);
/**		System.out.println("");
		tree.preorder(tree.raiz);
		System.out.println("");
		tree.postorder(tree.raiz);
		System.out.println("");
		System.out.println("el arbol tiene " + tree.elementos + " elementos");
*/
//		System.out.println(tree.busca(0));
//		System.out.println();
		//System.out.println(tree.elimina(30));
	/*    
		System.out.println();
		//tree.dfs(3, i -> System.out.println(i));
		System.out.println();
        System.out.println();
        System.out.println();
        //tree.giraDerecha(50);
        //tree.dfs(3, i -> System.out.println(i));

        //tree.elimina(15);
		//tree.dfs(3, i -> System.out.println(i));
		System.out.println("Imprime bfs");
		//tree.giraDerecha(tree.raiz());
		//tree.dfs(3, i -> System.out.println(i));
		tree.bfs(i-> System.out.println(i));
		System.out.println();
		System.out.println();
        System.out.println();
        System.out.println();
*/
//		System.out.println(tree.predecesor(5));


        /////////////////Rojo Negro//////////

        //ArbolRojinegro <Integer> ryb = new ArbolRojinegro <Integer>();
        //ryb.agrega(50);
	    //ryb.agrega(20);
	    //System.out.println(ryb.getColor(raiz2()));
		//ryb.agrega(60);
		//ryb.agrega(45);
		//ryb.agrega(25);
		//ryb.agrega(35);
		//ryb.agrega(48);
		//ryb.agrega(24);

		//ryb.bfs(i -> System.out.println(i));
	}
}