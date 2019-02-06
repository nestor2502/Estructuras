/**
*@author Nestor Semer Vazquez Cordero
*@author Isay Balderas Salomon
*@version 1.0
*Clase que implementa un subconjunto de metodos de la clase String
*
*/

public class MyString {

	public char [] caracteres;


	/** Constructor para generar una cadena vacia */

	 public MyString(){
	 	caracteres = new char [] {0};

	  } 

	/** Constructor a partir de un string */

	 public MyString (String cadena){

		 longitud = cadena.length();

		 caracteres = new char [longitud];

		 for(int i = 0 ; i < longitud ; i++){

		 	 caracteres [i] = cadena.charAt(i);
		 }
     
       

	  }

	/** Constructor a partir de un arreglo de caracteres */

	 public MyString (char [] caracteres){

	 	 int cont =0;

         this.caracteres = new char[caracteres.length+1]; //+1 para que cree un espacio vacío en el arreglo

         for(int i=0 ; i < caracteres.length; i++){
           
             this.caracteres[i]= caracteres[i];

             cont++;

             }

	  }
     
     /**
     *
     *Metodo que devuelve un string con los mismos caractyeres que nuestra cadena
     *@param string
     *@return cadena
     *
     */
	 @Override
     public String toString(){
for(int i=0;i<this.caracteres.length;i++){
	String str = "" + this.caracteres[i];
}
	return str;
}
     /**
     *
     *Metodo que recibe un indice i y nos regresa un MyString con los caracteres del intervalo [i, longitud-1]
     * de la cadena original
     *@param indice
     *@return MyString
     *
     */
     public MyString subString (String cadena){}

     /**
     *
     *Toma un indice i y nos regresa el caracter en la posicion i de nuestra cadena
     *@param indice
     *@return caracter
     *@throws IndexOutOfBoundsException
     *
     */
     public char charAt( int index) throws IndexOutOfBoundsException{
      
         char caracter = ' ';

         try{  

         	 for (i =0 ; i < caracteres.length; i++){

         	 	 if ( i == index ){
                     
                     caracter = caracteres [i];

         	 	} return caracter; 
         	 }


             }
         
         catch( IndexOutOfBoundsException e ){

             System.out.println("El indice no fue encontrado");

             }

         return ' ';
     }

     /**
     *
     *Metodo que nos dice si dos objetos son iguales
     *
     */
     public void equals ( String cadena){}

     /**
     *
     *Metodo que devuelve true cuando la cadena recibida es sufijo de la nuestra
     *@param Mystring
     *@return boolean
     *
     */
     public boolean endsWith ( String cadena){}

     /**
     *
     *Metodo que quita espacios alrededor de nuestra cadena
     *@param string
     *@return cadena
     *
     */
     public String trim(){}

     /**
     *
     *Metodo que toma un caracter y nos regresa la primera posicion en la que dicho caracter aparece
     *@param caracter
     *@return posicion
     *
     */
     public int indexOf( char caracter){
            
         for(int i =0 ; i < caractres.length; i++){

         	 if( caracteres [i] == caracter ){
                 
                 return i;

         	 }

         }
         	
         return -1; 

     }

     /**
     *
     *Metodo que devuelve un string con los miosmos caractyeres que nuestra cadena
     *@param string
     *@return cadena
     *
     */
     public String concat( String cadena){}

     /**
     *
     *Metodo que devuelve un string con los miosmos caractyeres que nuestra cadena
     *@param string
     *@return cadena
     *
     */
     public boolean isEmpty(){

     	int cont = 0;

     	for (int i = 0; i < caracteres.length; i++){

     		 if( caracteres [i] == 0)
     		 	 cont ++;

     		 }

         if (cont == caracteres.length)
             return true;

         else
             return false; 


     	}
     

     /**
     *
     *Metodo que nos regrese la longitud de nuestra cadena.
     *@param string
     *@return cadena
     *
     */
     public int length (){
     
         int tamaño =0;

         for(int i=0;caracteres[i]!= 0 ; i++){
    
             tamaño++;   

             }
         return tamaño   ;

      }





     public static void main (String [] args ){

	  char [] cadena = new char [7];
	  cadena[0]='d';
	  cadena[1]='i';
	  cadena[2]='a';
	  cadena[3]='n';
	  cadena[4]='a';
	  cadena[5]='h';
	  cadena[6]='8';

	  Mystring obj = new Mystring(cadena); //entra como parametro arreglo de caracteres

	  
	  int a = obj.length();
	 
	  System.out.println(a);
	}
 
 }
