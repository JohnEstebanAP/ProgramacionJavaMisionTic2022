import java.util.Scanner;
public class App {
    static int cantidadProductos;
    static Producto [] vectorProductos;
    static Scanner leer = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        System.out.println("Digite la cantidad de productos: ");
        cantidadProductos = leer.nextInt();
   
        //Creamos un objeto vector apartide la clase producto
        vectorProductos = new Producto [cantidadProductos];

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
            menu();
        }

    }

    /**Implemente en la clase principal un menú*/
    public static void menu(){
        int opcion = 0;

        System.out.println("**Menu de opciones**");
        System.out.println("Opcion 1: Verificar productos");
        System.out.println("Opcion 2: Producto con mayor cantidad de unidades");
        System.out.println("Opcion 3: Total a pagar por pedido a realizar");
        System.out.println("Opcion 4: Modificar cantidad minima requerida en bodega");
        System.out.println("Opcion 5: Vender producto");
        System.out.println("Digite la opcion deseada: ");
        
        opcion= leer.nextInt();
    

        switch(opcion){
            case 1:
                produtosApedir();
                break;
            case 2:
                productoMayorCantidad();
                break;
            case 3:
                comprarProducto();
                break;
            case 4:
                cambiarCantidadMinima();
                break;
            case 5:
                venderProducto();
                break;
        }
    }

    /*Verificar productos a pedir: recorrer el vector de productos y arrojar una alerta encaso tal se deba solicitar el pedido al proveedor */
    public static void produtosApedir(){
        System.out.println("\t");
        for(int i = 0; i < cantidadProductos; i++){
            if(vectorProductos[i].solicitarPedido()){
                System.out.println("Alerta. se debe solicitar producto al proveedor.");
                System.out.println("Para el producto de codigo: "+vectorProductos[i].getCodigo());
            }
        }
    }
        
    /**Indique cuál es el código del producto que tiene mayor cantidad de unidades 
     * en bodega, si hay varios que cumplen con la condición, indicar el primero de ellos. */
   public static void productoMayorCantidad(){
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
    }
        

    /**Leer un código de producto y una cantidad de unidades de compra, 
     * indicar el total apagar por ese pedido. Para ello utilice el 
     * método creado en la clase Producto pasando por parámetro la 
     * cantidad de unidades de compra. */
    public static void comprarProducto(){
        System.out.println("\t\t");
        System.out.println("Realizar pedido de un producto");
        System.out.println("porfavor indique el codigo del producto: ");
        int codigopedido = leer.nextInt();
        System.out.println("porfavor indique la cantidad de unidades a comprar: ");
        int unidadesComprar = leer.nextInt();
        
        for(int i = 0; i < cantidadProductos; i++){
            if(codigopedido == vectorProductos[i].getCodigo()){
                System.out.println("Total a pagar por el producto de codigo "+codigopedido);
                vectorProductos[i].calcularTotalPagar(unidadesComprar);
            }
        }
    }
        
        
    /**Cambiar la cantidad mínima requerida en bodega de un producto (leer código deproducto)
    * validar en el método set de la variable correspondiente que la nuevacantidad no sea menor a 0, 
    * en caso de serlo establecer la cantidad mínima como 0. */
    public static void cambiarCantidadMinima(){
        System.out.println("\t\t");
        System.out.println("Cambiar la cantidad mínima requerida en bodega");
        System.out.println("porfavor indique el codigo del producto: ");
        int codigop = leer.nextInt();
        System.out.println("porfavor indique la cantidad nueva: ");
        int cantidadMinima = leer.nextInt();
        
        for(int i = 0; i < cantidadProductos; i++){
            if(codigop == vectorProductos[i].getCodigo()){
                vectorProductos[i].setCantidadMinima(cantidadMinima);
                System.out.println("El valor de la cantidad minima es: "+vectorProductos[i].getCantidadMinima());
            }
        }
    }    

    /**Vender producto: solicite el código de un producto a vender 
     * y las unidades correspondientes,
     * calcule el valor de la factura con descuento y sin descuento.
     * Validar que existan las unidades necesarias para la venta 
     * y modificar las unidades existentes después de la venta utilizando 
     * el método set de la variable correspondiente */
    public static void venderProducto(){
        System.out.println("\t\t");
        System.out.println("**Vender Producto**");
        System.out.println("porfavor indique el codigo del producto: ");
        int codigoProducto = leer.nextInt();
        System.out.println("porfavor indique la cantidad de unidades: ");
        int cantidadUnidades = leer.nextInt();
        
        venderProducto(codigoProducto,cantidadUnidades);
        if(unidadesNesesarias(codigoProducto,cantidadUnidades)){
            System.out.println("Si hay unidades suficientes");
            cambiarCantidadMaxima( codigoProducto, cantidadUnidades);
        }else{
            System.out.println("No hay unidades suficientes");
        }
    }

    public static void venderProducto(int codigoProducto, int cantidadUnidades){
        for(int i = 0; i < cantidadProductos; i++){
            if(codigoProducto == vectorProductos[i].getCodigo()){
                System.out.println("Total a pagar por el producto de codigo "+codigoProducto);
                vectorProductos[i].calcularTotalPagar(cantidadUnidades);
            }
        }
    }

    public static boolean unidadesNesesarias(int codigoProducto, int cantidadUnidades){
       boolean resultado = false;
        for(int i = 0; i < cantidadProductos; i++){
            if(codigoProducto == vectorProductos[i].getCodigo()){
                if(cantidadUnidades <  vectorProductos[i].getCantidadMaxima()){
                    resultado = true;
                    break;
                }else{
                    resultado = false;
                    break;
                }      
            }
        }
        return resultado;

    }

    public static void cambiarCantidadMaxima(int codigoProducto, int cantidadUnidades){
            
        for(int i = 0; i < cantidadProductos; i++){
            if(codigoProducto == vectorProductos[i].getCodigo()){
                int cantidadActual = vectorProductos[i].getCantidadMaxima() - cantidadUnidades;
                vectorProductos[i].setCantidadMaxima(cantidadActual);
                System.out.println("El valor de la cantidad Maxima es: "+vectorProductos[i].getCantidadMaxima());
            }
        }
    }  
}
