#EJERCICIOS 

#PRIMERO: 
Como desafió consiste en un arreglo de 100 elementos del 1 al 100, del tipo int, utilizando el api stream se pide eliminar los divisibles en 10, luego convertir los elementos restante del flujo en tipo double y dividirlos en 2, para finalmente devolver la suma total de todos ellos usando el operador terminal reduce. El resultado debería ser 2250.0

#SEGUNDO:
El siguiente ejercicio es obtener el numero mayor de un arreglo pero utilizando programación funcional, implementando la expresión lambda Function<T,R> (que viene predefinida) con el api stream y operador reduce.

#TERCERO:
El siguiente ejercicio es aplanar un arreglo bidimensional en un nivel y eliminar repetidos usando el api stream.

Aplanar un arreglo significa quitar los elementos del arreglo anidado y dejarlos en el arreglo de primer nivel.

Por ejemplo, para el arreglo:

String[][] lenguajes = {{"java", "groovy"}, {"php"}, {"c#", "python", "groovy"}, {"java", "javascript", "kotlin"}, {"javascript"}, {}};

debería quedar:

{"java", "groovy", "php", "c#", "python", "javascript", "kotlin"};

#CUARTO:
El siguiente requerimiento es para una lista de productos List<Producto> , de 3 a 5 elementos, se pide calcular el importe (precio por cantidad) y sumarlos.

La clase Producto debe tener el atributo precio del tipo double y cantidad int, entonces utilizando stream convertir la lista de productos en el gran total del tipo double.
