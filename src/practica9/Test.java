package practica9;

public class Test{
	public static void main(String[] args) {
		/**
		int  capacidadInicial = 100;

             double m = Math.log(capacidadInicial)/Math.log(2);
             //int k = (int)Math.ceil(m);
             System.out.println("logaritmo base 2 de la capacidadInicial= "+capacidadInicial);
             int tamano =(int) Math.pow(2,(int)Math.ceil(m));
             //int tamanoF=(int)tamano;
             System.out.println("Tamaño final : "+tamano);*/
             System.out.println("Test de Tabla de dispersion");
             TablaDeDispersion <String,String> tabla = new TablaDeDispersion <String,String>();
             tabla.agrega("hola","ho");
             Lista<String> valores = tabla.getValores();
              Lista<String> llaves = tabla.getLlaves();
             System.out.println("valores: "+valores.toString());
             System.out.println("llaves: "+llaves.toString());
             System.out.println("Total de elementos: "+tabla.getElementos());
	}
}