/**Ejemplo 4: Estructura condicional anidado

En un sistema de inventario es importante conocer si es 
necesario solicitar un determinado producto a su 
proveedor de acuerdo a una cantidad mínima requerida 
en bodega. Se requiere un algoritmo que dada una 
cantidad en bodega y una cantidad mínima requerida 
indique si es necesario o no solicitar el producto 
al proveedor. 

Adicionalmente, en caso de no ser necesario la solicitud 
del producto, indique cuántas unidades hacen falta 
vender para tener que realizar el pedido y 
genere una alerta cuando estas unidades sean 
menores a 10. 
Por el contrario si se debe realizar el pedido, 
debe solicitar las unidades de compra deseadas, 
el valor de compra del producto y el dinero en 
caja con el fin de validar si es posible realizar 
la compra.

Ejemplos: 
*Cantidad en bodega: 500, Cantidad mínima requerida 100. Entonces no es necesario realizar el pedido al proveedor. Unidades que hacen falta vender: 400. 
*Cantidad en bodega: 55, Cantidad mínima requerida 50. Entonces no es necesario realizar el pedido al proveedor. Unidades que hacen falta vender: 5. Alerta generada.
*Cantidad en bodega: 300, Cantidad mínima requerida 450. Entonces si es necesario realizar el pedido al proveedor. Cantidades de compra deseada: 200. Valor de compra: 3350, Valor en caja: 1.050.000. Si es posible realizar el pedido
*Cantidad en bodega: 300, Cantidad mínima requerida 450. Entonces si es necesario realizar el pedido al proveedor. Cantidades de compra deseada: 200. Valor de compra: 3350, Valor en caja: 400.000. No es posible realizar el pedido

Requerimiento: utilice condicionales anidados.
 */
import java.util.Scanner;
public class ejemplo4 {
    public static void main(String[] args){
        Scanner leer = new Scanner(System.in);
        
        System.out.println("Ingrese la cantidad mínima requerida: ");
        int cantidadMinima = leer.nextInt();

        System.out.println("Ingrese la cantidad actual en Bodega. ");
        int cantidadBodega = leer.nextInt();

        if(cantidadBodega < cantidadMinima){
            System.out.println("Es necesario solicitar al proveedor");
            
            System.out.println("Digite por favor la cantidad de compra deseada: ");
            int cantidadCompradeseada = leer.nextInt();
            
            System.out.println("Digite el valor unitario de cada producto");
            int valorProductoUnitario = leer.nextInt();

            System.out.println("Digite el valor en caja: ");
            int valorCaja = leer.nextInt();

            String imprimir = "Cantidades de compra deseada: "+cantidadCompradeseada+" Valor de compra: "+valorProductoUnitario+", Valor en caja: "+valorCaja+ "Total compra: "+valorProductoUnitario*cantidadCompradeseada;
            if (valorProductoUnitario*cantidadCompradeseada <= valorCaja){                
                System.out.println(imprimir+" Si es posible realizar el pedido");
            }else{
                System.out.println(imprimir +" No es posible realizar el pedido");
            }

        }else{
            int unidadesRestantes = cantidadBodega - cantidadMinima; 
            System.out.println("No es Necesario solicitar al proveedor");
        
            if (unidadesRestantes < 10){
                System.out.println("Unidades que hacen falta vender:"+ unidadesRestantes);
                System.out.println("Alerta Generada");
            }else{
                System.out.println("Unidades que hacen falta vender:"+ unidadesRestantes);
            }
        }
    }
    
}
