public class Reinas{

     private int[] acomodo;

     public Reinas(int n){

        acomodo = new int [n];
        for(int i =0; i< acomodo.length; i++){
             acomodo[i]=-1;           
         }
    }

     public void acomodaReinas(){


    }
	

     public boolean seAtacan(){


             int cont=1;
             //ciclo que verifica que no tengan el mismo numero por filas
             for (int i = 0; i<acomodo.length-1;i++){

                 if (acomodo[i]==acomodo[i+1])
                     return true;
                 }

                 // ciclo que compara en diagonal hacia la derecha
             for (int i = 0; i<acomodo.length-1;i++){
                 int cont2=0;
                 int j=0;
                 for(  j = cont2+1 ; j <(acomodo.length); j++){        
                     if(j+1!=acomodo.length){
                         int absoluto = Math.abs(acomodo[cont2]-acomodo[j+i]);
                         if(absoluto==cont)
                             return true;
                         }
                      cont2++;
             }
             cont++;


             }
             int cont2=1;
             // ciclo que compara en diagonal hacia la izquierda
             for (int i = acomodo.length-1; i>=0;i--){
                 int j=0;
                 for(  j = cont2-1 ; j <(acomodo.length); j--){                   
                     if(j-1!=0){
                         int absoluto = Math.abs(acomodo[cont2]-acomodo[j+i]);
                         if(absoluto==cont2)
                             return true;
                         }
                      cont2--;
             }
             cont++;
             }

         return false;

        }
	
    }
