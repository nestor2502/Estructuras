package practica5;
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
	

    }

    public ArbolRojinegro(T[] a){
        
        for(int i = 0; i< a.length; i++){

             agrega (a[i]);
        }
    }
    
    protected Color getColor(Vertice v){   
       //implementar un metodo que recorra el arbol y encuentre el vertice

       VerticeRojinegro ve =(VerticeRojinegro) encuentra(v);
       return ve.color;
    }

    protected void setColor(Vertice v){
        
        //metodo pendiente por implementacion
        VerticeRojinegro ve =(VerticeRojinegro) encuentra(ve);

        if(ve.color== Color.ROJO){

             ve.color = Color.NEGRO;
        }

        if(ve.color == Color.NEGRO){

             ve.color = Color.ROJO;
        }
    }

    @Override
    public void agrega(T elemento){
	
             //metodo balancea aun pendiente por implementacion
             balancea();
    }

    @Override
    public boolean elimina(T elemento){
    // Aquí va su código.
    }
}