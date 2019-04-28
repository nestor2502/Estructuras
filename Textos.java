/**
 * 
 * @author isayd
 *	Se agregan los textos a los cuales 
 *
 */
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
public class Textos {

	//Atributo que tiene la direccion del documento
	public String documento;
	//Constructor 
	public Textos(String ruta){
		documento = ruta;
	}
	
	/**Metodo que agrega al arbol, agarra cierto documento
	 * 
	 */
	public void agregation() {
	try {
		BufferedReader lector = new BufferedReader(new FileReader(documento));//Se usa para leer los documentos
		ArbolAvl<String> avl = new ArbolAvl<String>(); //Creamos con el arbol
		String cadena;
		while((cadena = lector.readLine()) != null){
//			cadena = Transformar.convertir(cadena);// Metodo que convierte el renglon en minusculas
			String [] subcadena = Transformar.arreglo(cadena);// Divide nuestro string en palabras y los mete a un arreglo
			for(String i : subcadena){
				//Aqui va el agrega al arbol
				avl.agrega(i);
			}
		}
		lector.close();

	}catch(FileNotFoundException e){//No encontro el documento
		
		System.out.println("No se encontro el documento");
		
	}catch(IOException e){//Errores varios
		
		System.out.println("Hubo algun problema");
	
	}
}
	
	public static void main(String [] args){
		Textos txt = new Textos("C:\\Users\\isayd\\Documents\\prueba.txt");
		txt.agregation();
	}
	
}
