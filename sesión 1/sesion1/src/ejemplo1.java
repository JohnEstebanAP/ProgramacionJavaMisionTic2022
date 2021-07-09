/*
Ejemplo 1: Estructura condicional simple

En un sistema de inventario es importante conocer si es necesario
 solicitar un determinado producto a su proveedor de acuerdo a una
 cantidad mínima requerida en bodega. Se requiere un algoritmo 
 que dada una cantidad en bodega y una cantidad mínima requerida
 indique si es necesario o no solicitar el producto al proveedor.

Ejemplos: 
*Cantidad en bodega: 300, Cantidad mínima requerida 450. Entonces 
si es necesario realizar el pedido al proveedor.

Requerimiento: utilice sólo condicionales simples.
*/

import java.util.Scanner;

public class ejemplo1{
    public static void main(String[] args){
        Scanner leer = new Scanner(System.in);
        
        System.out.println("Ingrese la cantidad mínima requerida: ");
        int cantidadMinima = leer.nextInt();

        System.out.println("Ingrese la cantidad actual en Bodega. ");
        int cantidadBodega = leer.nextInt();

        if(cantidadBodega < cantidadMinima){
            System.out.println("Es necesario solicitar al proveedor");
        }
    }
}