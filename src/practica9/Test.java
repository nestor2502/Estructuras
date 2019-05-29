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
             /**
             System.out.println("Test de Tabla de dispersion");
             TablaDeDispersion <String,String> tabla = new TablaDeDispersion <String,String>();
             tabla.agrega("hola","ho");
             Lista<String> valores = tabla.getValores();
              Lista<String> llaves = tabla.getLlaves();
             System.out.println("valores: "+valores.toString());
             System.out.println("llaves: "+llaves.toString());
             System.out.println("Total de elementos: "+tabla.getElementos());
             System.out.println("");
             System.out.println("La tabla contiene la llave hola?: "+tabla.contieneLlave("hola"));
             System.out.println("La tabla contiene el valor ho?: "+tabla.contieneValor("ho"));
             System.out.println("");
             System.out.println("");
             System.out.println("Segunda fase de pruebas");
             System.out.println("");
             System.out.println("");
             TablaDeDispersion <Integer,Integer> tabla2 = new TablaDeDispersion <Integer,Integer>();
             tabla2.agrega(15,15);
             System.out.println("Posicion guardada"+tabla2.posicion(15));
             System.out.println("");
             System.out.println("");
             System.out.println("");
             System.out.println("Prueba de dispersion");
             //Dispersiones dispersa = new Dispersiones();
             String prueba = "Hola";
             System.out.println("Resultado dispersionDJB: "+Dispersiones.dispersionDJB(prueba.getBytes()));
             System.out.println("");
             System.out.println("");
             System.out.println("");*/
             System.out.println("Prueba Tabla de dispersion con dispersor");
             
             System.out.println("");
             System.out.println("");
             System.out.println("");
             System.out.println("Prueba de dispersion");
             TablaDeDispersion <String,String> tabla3 = new TablaDeDispersion <String,String>(70, x -> Dispersiones.dispersionDJB(x.getBytes()));
             tabla3.agrega("hola1","ho1");
             tabla3.agrega("hola2","ho2");
             tabla3.agrega("hola3","ho3");
             tabla3.agrega("hola4","ho4");
             tabla3.agrega("hola5","ho5");
             tabla3.agrega("hola6","ho6");
             Lista<String> valores2 = tabla3.getValores();
              Lista<String> llaves2 = tabla3.getLlaves();
             System.out.println("valores: "+valores2.toString());
             System.out.println("llaves: "+llaves2.toString());
             System.out.println("Total de elementos: "+tabla3.getElementos());
             System.out.println("");
             System.out.println("La tabla contiene la llave hola?: "+tabla3.contieneLlave("hola1"));
             System.out.println("La tabla contiene el valor ho?: "+tabla3.contieneValor("ho3"));


             //System.out.println("valor de la llave hola1 "+tabla3.getValor("hola1"));
             //System.out.println("Se elimina llave hola3: "+tabla3.elimina("hola3"));
             Lista<String> valores3 = tabla3.getValores();
              Lista<String> llaves3 = tabla3.getLlaves();
             System.out.println("valores: "+valores3.toString());
             System.out.println("llaves: "+llaves3.toString());
             System.out.println("");
             System.out.println("");
             System.out.println("SE agrega un elemento con la misma llave pero distinto elemento");
             tabla3.agrega("hola3","se cambia3");
             Lista<String> valores4 = tabla3.getValores();
             Lista<String> llaves4 = tabla3.getLlaves();
             System.out.println("valores: "+valores4.toString());
             System.out.println("llaves: "+llaves4.toString());
             System.out.println("");
             System.out.println("");
              System.out.println("factor de carga: "+tabla3.getCarga());
              System.out.println("tamaño de la tabla: "+tabla3.getTamaño());


    }      


}