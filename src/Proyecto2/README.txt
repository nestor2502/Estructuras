

Proyecto 2: "Motor de busqueda"

Por:
    -Nestor Semer Vazquez Cordero
    -Isay Balderas Salomon

¿Como funciona?
     
     El arcivo a correr es -Ventana1.java-, se abrirá una ventana donde se tienen que
     seguir los siguientes pasos:

     1)Ingresa la frase
     2)Presiona "ingresar"
     3)Ingresa la ruta del documento
     4)Presiona añadir "documento"
     *El paso 3 y cuatro se realiza cada vez que ingreses un documento
     *En el ComboBox se encuentra cada una de las rutas
     5)Presiona "Mostrar coincidencias"
     *Te abrirá una ventana donde estararan tus documentos 
      ordenados de mayor a menor similitud segun la frase ingresada
     6)en la segunda ventana presiona regresar
     7)Presiona "Nueva consulta" para poder realizar una nueva busqueda

   

Observaciones:
     -No se pueden añadir documentos repetidos
      -Se pueden añadir documentos una vez obtenida los resultados de la busqueda anterior
     -Al presionar "Nueva consulta" se limpia el sistema perdiendo los archivos ya ingresados


Precaucion:

     El documento TextPrompt.java debe estar en la misma carpeta que Ventana1.java y Ventana3.java, 
     pero en una carpeta distinta a Color.java ya que la clase  Color que utiliza TextPrompt es
     perteneciente a javax.swing.*; por lo tanto no compilará si estan en la misma carpeta, es por eso que tienen
     distinto package;