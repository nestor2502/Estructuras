package arboles;
/**
 * Implementación de árboles rojinegros.
 */
public class ArbolRojinegro<T extends Comparable<T>> extends ArbolBinarioBusqueda<T>{

    protected class VerticeRojinegro extends Vertice{
	
	public VerticeRojinegro(T elemento){
	   

       super(elemento);


       

	}
	
	public Color color;
	
    }

    public ArbolRojinegro(){
	
      raiz = null;

    }

    public ArbolRojinegro(T[] a){
        
        for(int i = 0; i< a.length; i++){

             agrega (a[i]);
             //metodo balancea aun pendiente por implementacion
             balancea();
        }
    }
    
    protected Color getColor(Vertice v){   
       //implementar un metodo que recorra el arbol y encuentre el vertice

       Vertice ve = encuentra(v);
       return ve.color;
    }

    protected void setColor(Vertice v){
        
        //metodo pendiente por implementacion
        Vertive ve = encuentra(ve);
        if(ve.color== Color.ROJO){

             ve.color = Color.NEGRO;
        }

        if(ve.color == Color.NEGRO){

             ve.color = Color.ROJO;
        }
    }

    @Override
    public void agrega(T elemento){
	
    }

    @Override
    public boolean elimina(T elemento){
    // Aquí va su código.
    }
}