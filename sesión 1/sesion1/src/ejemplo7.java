/**Ejemplo 7: Integración estructuras condicionales y cíclicas (while if-else) (for if-else)

Como parte de un sistema de facturación es necesario conocer el valor unitario y 
las cantidades a comprar de cada uno de los productos para calcular el total a pagar. 

Se requiere un algoritmo que para un conjunto de clientes, calcule para cada uno de ellos
 el valor a pagar de N tipos de productos comprados de acuerdo a la cantidad a llevar de cada tipo. 
 Al finalizar la atención de los clientes, se debe indicar el total vendido por la empresa.
 Para las compras superiores a 100.000 la empresa ha decido otorgar un 10% de descuento sobre el total de la compra.

Nota: Se deben atender a los clientes hasta que el usuario indique lo contrario.

Ejemplo:
Cliente 1:
Cantidad de tipo de productos: 3
Cantidad del producto 1: 4. Valor del producto 1: 2450
Cantidad del producto 2: 10. Valor del producto 1: 6540
Cantidad del producto 3: 1. Valor del producto 1: 1050
Total de la factura: 76250

Cliente 2:
Cantidad de tipo de productos: 2
Cantidad del producto 1: 5. Valor del producto 1: 10560
Cantidad del producto 2: 7. Valor del producto 1: 650
Total de la factura: 57350

Total vendido:133600
 */

import java.util.Scanner;

public class ejemplo7 {
    public static void main(String[] args) {

        Scanner leer= new Scanner(System.in);
        int cantidadProductos,unidadesProducto, i = 0;
        double total = 0;
        double valor, totalVentas = 0.0;
        String opcion = "S";
        while(opcion.equals("S")){
                    i++;
                    System.out.println("\nCliente "+i+":");
                    System.out.println("Puede ingresar la cantidad de productos a ingresar: ");
                    cantidadProductos = leer.nextInt();
                    
                    System.out.print("Cantidad de tipo de productos: "+cantidadProductos);
                    total = 0;
                    for(int j = 1; j<= cantidadProductos; j++){
                        System.out.print("\nPor favor ingrese la cantidad de unidades para el producto "+ j+": ");
                        unidadesProducto = leer.nextInt();
                        System.out.print("Por favor ingrese el valor unitario  del producto "+ j+": ");
                        valor = leer.nextInt();
                    
                        total = (total + (valor*unidadesProducto));
                        System.out.print("Cantidad del producto "+j+": "+unidadesProducto+". Valor del producto "+j+": "+valor);
                        
                    }
                
                    double descuento = 0;
                    if( total > 100000){
                        descuento = total*0.1;
                        total = total - descuento;
                        System.out.print("\nEl total a pagar es de: "+ total+ " Con un Descuento de: "+descuento+"\n");
                    }else{
                        System.out.println("\nEl total a pagar es de: "+ total+"\n");
                    }
                                    
                    System.out.print("Desea continuar con otro cliente S/N:");
                    opcion = leer.next();
                    opcion = opcion.toUpperCase();
                    
                    if(opcion.equals("SI")){
                        opcion = "S";
                    }

                    totalVentas = totalVentas + total;
        }
        System.out.println("El Total de Ventas es de: "+ totalVentas);
    }
}
