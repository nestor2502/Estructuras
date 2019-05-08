package practica9;
/**
 * Clase que define tablas de dispersión.
 */
public class TablaDeDispersion<K, V>{

    private class Entrada{

	public K llave;
	public V valor;

	public Entrada(K llave, V valor){
	     this.llave = llave;
         this.valor = valor;
	}
    }
 
    private Lista<Entrada>[] tabla;  
    private Dispersor<K> dispersor;
    private int elementos;
    public static final int CAPACIDAD_MINIMA = 64;
    private static final double CARGA_MAXIMA = 0.75;

    
    private Lista<Entrada>[] nuevoArreglo(int tamano){
	@SuppressWarnings("unchecked")
	Lista<Entrada>[] arreglo = (Lista<Entrada>[]) new Lista[tamano];
	return arreglo;
    }
     /**
     *Constructor vacio 
     */
     public TablaDeDispersion(){
	     tabla = nuevoArreglo(64*2);
         dispersor = k.hashCode();
         elementos=0;
     }
    
     /**
     *Constructor que recibe ua capacidad
     *@param capacidad
     */
    public TablaDeDispersion(int capacidad){ 
         int capacidadInicial;
         if(capacidad>=64){
             capacidadInicial = capacidad*2;
             int k = Math.log(capacidadInicial)/Math.log(2);
             int tamano = Math.pow(2,Math.ceil(k));
             tabla = nuevoArreglo(tamano);
             dispersor = k.hashCode();
             elementos=0;}
         else{
             System.out.println("La capacidad minima aceptada es 64");
         }
    }
     /**
     *Constructor que recibe un dispersor
     *@param dispersor
     */
    public TablaDeDispersion(Dispersor<K> dispersor){

	     tabla = nuevoArreglo(64*2);
         this.dispersor = dispersor;
         elementos=0;
    }

    public TablaDeDispersion(int capacidad, Dispersor<K> dispersor){
	      int capacidadInicial;
         if(capacidad>=64){
             capacidadInicial = capacidad*2;
             int k = Math.log(capacidadInicial)/Math.log(2);
             int tamano = Math.pow(2,Math.ceil(k));
             tabla = nuevoArreglo(tamano);
             this.dispersor = dispersor;
             elementos=0;}
         else{
             System.out.println("La capacidad minima aceptada es 64");
         }

    }

    public void agrega(K llave, V valor){
	// Aquí va su código.
    }
 
    public V getValor(K llave){
	// Aquí va su código.
    }

    public boolean contieneLlave(K llave){
	// Aquí va su código.
    }

    public boolean contieneValor(V valor){
	// Aquí va su código.
    }

    public boolean esVacia(){
	// Aquí va su código.
    }

    public V elimina(K llave){
	// Aquí va su código.
    }

    public int getElementos(){
	// Aquí va su código.
    }

    public Lista<K> getLlaves(){
	// Aquí va su código.
    }

    public Lista<V> getValores(){
	// Aquí va su código.
    } 
}