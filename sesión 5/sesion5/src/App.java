/**Sesión # 5: Componente Práctico

Implementar una clase llamada Producto, la cual tenga los siguientes atributos y métodos:

Atributos:
    • Código
    • Precio de compra
    • Cantidad en bodega
    • Cantidad mínima requerida en bodega.

Métodos:
    • Solicitar pedido: devuelva true si debe solicitar el producto al proveedor y false en caso contrario.

Diseñar un programa que:

    • Consulte el número de productos a manejar.
    • Cree una vector de productos en el cual se guardarán las instancias de cada uno de ellos.
    • Solicite por consola el código, el precio de compra, la cantidad en bodega y la cantidad mínima requerida para cada uno de los productos a manejar.
    • Recorra el vector de productos y arroje una alerta en caso tal se deba solicitar el pedido al proveedor.
    • Indique cuál es el código del producto que tiene menor cantidad de unidades en bodega, si hay varios que cumplen con la condición, indicar el primero de ellos.


Recuerde:
    • Implementar buenas prácticas de programación declarando los atributos privados y creando los métodos get y set para cada uno de ellos.
 */
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
       
        Scanner leer= new Scanner(System.in); 

        System.out.println("Digite el numeor de productos: ");
        int cantidadProductos = leer.nextInt();
        //Creamos un objeto vector apartide la clase producto
        Producto [] vectorProductos = new Producto [cantidadProductos];

        for (int i = 0 ; i < cantidadProductos; i++){
            
            System.out.println("\nDigite el Codigo del producto "+(i+1)+": ");
            int cod= leer.nextInt();
    
            System.out.println("\nDigite el Precio de compra del producto: ");
            int valor= leer.nextInt();
    
            System.out.println("\nDigite la cantidad en bodega del producto: ");
            int cantidadBodega= leer.nextInt();
        
            System.out.println("\nDigite la cantidad mínima requerida del producto: ");
            int cantidadMinima= leer.nextInt();

            vectorProductos[i] = new Producto(cod, valor, cantidadBodega, cantidadMinima);
        }

        System.out.println("\t");
        for(int i = 0; i < cantidadProductos; i++){
            if(vectorProductos[i].solicitarPedido()){
                System.out.println("Alerta. se debe solicitar producto al proveedor.");
                System.out.println("Para el producto de codigo: "+vectorProductos[i].getCodigo());
            }
        }

        int MenorBodega  = vectorProductos[0].getCantidadBodega();
        int codigoMenorBodega = 0;
        for(int i = 0; i < cantidadProductos; i++){
            if(MenorBodega > vectorProductos[i].getCantidadBodega()){
                MenorBodega  = vectorProductos[i].getCantidadBodega();
                codigoMenorBodega = vectorProductos[i].getCodigo();
            }
        }
        System.out.println("\t\t");
        System.out.println("El código del producto menor en bodega es: "+codigoMenorBodega);
        System.out.println("Con una cantidad en bodega de: "+MenorBodega);
    }
}

