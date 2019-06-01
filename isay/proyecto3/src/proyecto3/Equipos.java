package proyecto3;

public class Equipos {
    
    private String nombre;
    private int habilidad;
    private String imagen;
    
    
    public Equipos(){
        this.nombre = "";
        this.habilidad = 0;
        this.imagen = "";
        
    }
    
    public Equipos(String nombre, int habilidad,String imagen){
        this.nombre = nombre;
        this.habilidad = habilidad;
        this.imagen = imagen;
        
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setHabilidad(int habilidad){
        this.habilidad = habilidad;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public int getHabilidad(){
        return this.habilidad;
    }
    
    public String getImagen(){
        return this.imagen;
    }
    
    public void setImagen(String imagen){
        this.imagen = imagen;
    }
    
    
}
           
