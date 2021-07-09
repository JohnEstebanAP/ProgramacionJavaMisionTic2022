/**Ejemplo 6: Estructura cíclica

Como parte de un sistema de facturación es 
necesario conocer el valor unitario y las 
cantidades a comprar de cada uno de los productos 
para calcular el total a pagar. 

Se requiere un algoritmo que para 1 cliente, 
calcule el valor a pagar de N tipos de productos 
comprados de acuerdo a la cantidad a llevar de 
cada tipo.

Ejemplo:
Cantidad de tipo de productos: 3
Cantidad del producto 1: 4. Valor del producto 1: 2450
Cantidad del producto 2: 10. Valor del producto 2: 6540
Cantidad del producto 3: 1. Valor del producto 3: 1050
Total de la factura: 76250 */

import java.util.Scanner;
public class ejemplo6 {
    public static void main(String[] args) {
        Scanner leer= new Scanner(System.in);
        int cantidadProductos,unidadesProducto, valor, total = 0;
        
        System.out.println("Puede ingresar la cantidad de productos a ingresar: ");
        cantidadProductos = leer.nextInt();
        
        System.out.print("Cantidad de tipo de productos: "+cantidadProductos);

        for(int i = 1; i<= 3; i++){
            System.out.print("\nPor favor ingrese la cantidad de unidades para el producto "+ i+": ");
            unidadesProducto = leer.nextInt();
            System.out.print("Por favor ingrese el valor unitario  del producto "+ i+": ");
            valor = leer.nextInt();

            total = total + (valor*unidadesProducto);
            System.out.print("Cantidad del producto "+i+": "+unidadesProducto+". Valor del producto "+i+": "+valor);
        }

        System.out.println("El total a pagar es de: "+ total);
    }
}
