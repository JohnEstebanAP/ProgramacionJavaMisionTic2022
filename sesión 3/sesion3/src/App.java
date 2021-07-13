/**Sesión # 3: Componente Práctico

Una determinada empresa con varias sedes en una ciudad 
tiene dentro de su información 1 lista, y 2 tablas que
  corresponden a:

1: Lista con el código del producto.
2: Tabla con la cantidad en bodega del producto para el conjunto de sedes.
3: Tabla con la cantidad mínima requerida del producto para el mismo conjunto de sedes.

Es decir

A continuación se detallan los datos para 3 productos en 4 sedes.

Lista de códigos
354     256     127

Tabla de la cantidad en bodega
17      34      60
14      31      65
45      2       12
56      43      8

Tabla de la cantidad mínima requerida
14      44      76
10      51      15
46      23      2
89      4       18


Para el sistema de inventario es importante conocer si 
es necesario solicitar un determinado producto a su 
proveedor de acuerdo a la cantidad mínima requerida. 

Se solicita diseñar un algoritmo que:

    • Lea la lista de los códigos.
    • Lea las dos tablas mencionadas.
    • Almacene la lista en un vector y cada tabla en una matriz.
      Una vez leídos los datos:
    • Indique los códigos de los productos de los cuales se deben realizar los pedidos, especificando el número de la sede. El número de sede corresponde al número de la fila en la tabla.
    • El promedio de las cantidades de cada producto en bodega y su respectivo código.

Nota: para facilitar el proceso de lectura, 
leer los códigos en una sola línea separados por coma, 
la tabla de cantidad en bodega leerla en una sola línea 
separando las filas por punto y coma y números por espacio. 
 

Es decir, para el ejemplo anteriormente descrito las entradas serán 3:
354 256 127
17 34 60;14 31 65;45 2 12;56 43 8
14 44 76;10 51 15;46 23 2;89 4 18


Y las salidas serán:

Se debe solicitar producto 256 en sede 0
Se debe solicitar producto 127 en sede 0
Se debe solicitar producto 256 en sede 1
Se debe solicitar producto 354 en sede 2
Se debe solicitar producto 256 en sede 2
Se debe solicitar producto 354 en sede 3
Se debe solicitar producto 127 en sede 3

El promedio de productos del codigo 354 es 33.0
El promedio de productos del codigo 256 es 27.5
El promedio de productos del codigo 127 es 36.25
*/

import java.util.Scanner;
public class App {
  public static void main(String[] args) {

    Scanner leer= new Scanner(System.in);
    double promedio =0;
    String []listaCodigo;

    System.out.print("Por favor ingrese los códigos de los productos separados por espacio: ");
    String linea = leer.nextLine();      
    listaCodigo = linea.split(" ");    
    // Creo una lista con los valores ingresados en linea y separados con espacios con la función split(" ")

    // la función length me devuelve en entero la cantidad de elementos de la listo o vector
    //int [][] matrizCantidadBodega = new int[4][listaCodigo.length];
    //int [][] matrizCantidadMinima = new int[4][listaCodigo.length];

    System.out.print("\nPor favor ingrese la cantidad en bodega separando las filas por punto y coma y números por espacio. ");
    linea = leer.nextLine(); 
    
    //llenamos la matriz de cantidad en bodega con sus filas y columnas
    String [] fila = linea.split(";"); 
    String [] cantidades = fila[0].split(" ");
    int [][] matrizCantidadBodega = new int[fila.length][cantidades.length];
    int [][] matrizCantidadMinima = new int[fila.length][cantidades.length];
   
    for(int i = 0; i< fila.length; i++){ // con length determino la cantidad de sedes.
      cantidades = fila[i].split(" ");
      for(int j = 0; j< listaCodigo.length; j++){// con length determino la cantidad de productos por fila
        matrizCantidadBodega[i][j]= Integer.parseInt(cantidades[j]);
      }
    }

    System.out.print("\nPor favor ingrese la cantidad mínima separando las filas por punto y coma y números por espacio. ");
    linea = leer.nextLine();  
    //llenamos la matriz de cantidad mínima con sus filas y columnas
    fila = linea.split(";"); 
    for(int i = 0; i< fila.length; i++){ // con length determino la cantidad de sedes.
      cantidades = fila[i].split(" ");
      for(int j = 0; j< listaCodigo.length; j++){// con length determino la cantidad de productos por fila
        matrizCantidadMinima[i][j]= Integer.parseInt(cantidades[j]);
      }
    }

    System.out.print("\n\n");
    
    for(int i=0; i< fila.length; i++){
      for(int j=0; j< listaCodigo.length; j++){
        if(matrizCantidadMinima[i][j] > matrizCantidadBodega[i][j]){
          System.out.println("Se debe solicitar producto: "+listaCodigo[j]+" en sede "+i);
        }
      }
    }
    
    for(int j=0; j< listaCodigo.length; j++){
      for(int i=0; i< fila.length; i++){
       promedio = promedio +matrizCantidadBodega[i][j];
      }
      promedio= promedio / fila.length;
      System.out.println("El promedio de productos del código "+listaCodigo[j]+" es "+promedio);
      promedio = 0;
    }
  }

}
