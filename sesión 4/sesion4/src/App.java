/**Sesión # 4: Componente Práctico

Implementar una clase llamada Producto, la cual tenga los siguientes atributos y métodos:

Atributos:
    • Código
    • Precio de compra
    • Cantidad en bodega
    • Cantidad mínima requerida en bodega.

Métodos:
    • Solicitar pedido: devuelva true si debe solicitar el producto al proveedor y false en caso contrario.

Diseñar un programa que:

    • Solicite por consola el código del producto, el precio de compra, la cantidad en bodega y la cantidad mínima requerida.
    • Instancie un producto dentro de la clase principal.
    • Arroje una alerta en caso tal se deba solicitar el pedido al proveedor.
*/

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
       
        Scanner leer= new Scanner(System.in); 
        
        System.out.println("Digite el Codigo del producto: ");
        int cod= leer.nextInt();

        System.out.println("Digite el Precio de compra del producto: ");
        int valor= leer.nextInt();

        System.out.println("Digite la cantidad en bodega del producto: ");
        int cantidadBodega= leer.nextInt();
    
        System.out.println("Digite la cantidad mínima requerida del producto: ");
        int cantidadMinima= leer.nextInt();

        Producto producto = new Producto(cod, valor, cantidadBodega, cantidadMinima);
 
        if(producto.SolicitarPedido()){
            System.out.println("Alerta. se debe solicitar producto al proveedor.");
        }else{
            System.out.println("No se debe solicitar producto al proveedor.");
        }
    }
}


 