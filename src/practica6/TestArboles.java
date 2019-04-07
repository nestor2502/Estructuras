package practica5;

public class TestArboles{
	public static void main(String [] args){

			ArbolBinarioBusqueda <Integer> tree = new ArbolBinarioBusqueda <Integer>();
		tree.agrega(50);
		tree.agrega(30);
		tree.agrega(20);
		tree.agrega(45);
		tree.agrega(15);
		tree.agrega(25);
		tree.agrega(35);
		tree.agrega(48);
		tree.agrega(24);
//		tree.agrega(11);
		
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
		System.out.println(tree.elimina(30));
		System.out.println();
		tree.dfs(2, i -> System.out.println(i));
		System.out.println();
        System.out.println();
        System.out.println();
        tree.elimina(15);
		tree.dfs(2, i -> System.out.println(i));
		System.out.println();
//		System.out.println(tree.predecesor(5));
	}
}