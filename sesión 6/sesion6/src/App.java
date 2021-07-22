import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner leer = new Scanner(System.in);

        System.out.println("Digite la cantidad de productos: ");
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

        /**Indique cuál es el código del producto que tiene mayor cantidad de unidades 
         * en bodega, si hay varios que cumplen con la condición, indicar el primero de ellos. */
        int cantidadMayorEnBodega =  vectorProductos[0].getCantidadMaxima(); 
        int codigoMayorBodega = vectorProductos[0].getCodigo();
        for(int i = 0; i < cantidadProductos; i++){
            if(cantidadMayorEnBodega <  vectorProductos[i].getCantidadMaxima()){
                cantidadMayorEnBodega =  vectorProductos[i].getCantidadMaxima(); 
                codigoMayorBodega = vectorProductos[i].getCodigo();
      
            }
        }

        System.out.println("\t\t");
        System.out.println("El código del producto con mayor cantidad de unidades en bodega es: "+codigoMayorBodega);
        System.out.println("Con una cantidad en bodega de: "+cantidadMayorEnBodega);
   

        /**Leer un código de producto y una cantidad de unidades de compra, 
         * indicar el total apagar por ese pedido. Para ello utilice el 
         * método creado en la clase Producto pasando por parámetro la 
         * cantidad de unidades de compra. */


        System.out.println("\t\t");
        System.out.println("Realizar pedido de un producto");
        System.out.println("porfavor indique el codigo del producto: ");
        int codigopedido = leer.nextInt();
        System.out.println("porfavor indique la cantidad de unidades a comprar: ");
        int unidadesComprar = leer.nextInt();
         
        for(int i = 0; i < cantidadProductos; i++){
            if(codigopedido == vectorProductos[i].getCodigo()){
                System.out.println("Total a pagar por el producto de codigo "+codigopedido+" Es de: "+vectorProductos[i].calcularTotalPagar(unidadesComprar));
            }
        }
    }
}
