import java.util.Scanner;
public class App {
    static int cantidadProductos;
    static PrendasVestir [] vectorPrendasVestir;
    static Calzado [] vectorCalzado;
    static Scanner leer = new Scanner(System.in);
   public static void main(String[] args) throws Exception {
        
        
        //●Consulte el número de productos de tipo de prendas de vestir a manejar.
        System.out.println("Digite el número de productos de tipo de prendas de vestir a manejar: ");
        cantidadProductos = leer.nextInt();

        //●Cree un vector de productos de prendas de vestir en el cual se guardarán las instancias de cada uno de ellos.
        //Creamos un objeto vector apartide la clase PrendasVestir
        vectorPrendasVestir = new PrendasVestir [cantidadProductos];
        llenarInfo(cantidadProductos, true);
        
        
        //●Consulte el número de productos de tipo calzado a manejar.
        System.out.println("Digite el número de productos de tipo calzado a manejar: ");
        cantidadProductos = leer.nextInt();
        
        //●Cree un vector de productos de calzado en el cual se guardarán las instancias decada uno de ellos.
        vectorCalzado = new Calzado [cantidadProductos];
        llenarInfo(cantidadProductos, false);
        
        
        /*Implemente en la clase principal un menú con las siguientes opciones:
        
        ●Verificar productos a pedir: recorrer los vectores de productos y arrojar una alerta encaso tal se deba solicitar el pedido al proveedor.
        ●Calzado con mayor cantidad de unidades: indicar cuál es el código del producto que tiene mayor cantidad de unidades en bodega, si hay varios que cumplen con la condición, indicar el primero de ellos.
        ●Prenda con mayor cantidad de unidades: indicar cuál es el código del producto que tiene mayor cantidad de unidades en bodega, si hay varios que cumplen con la condición, indicar el primero de ellos.
        ●Modificar cantidad mínima requerida en bodega: leer código de producto, el tipo (calzado   o   prenda)   y   el   nuevo   valor   para   la   cantidad   de   unidades   mínimas requeridas, 
        validar en el método set de la variable correspondiente que la nueva cantidad no sea menor a 0, en caso de serlo establecer la cantidad mínima como 0.
        ●Vender producto: solicite el código de un producto a vender, el tipo (calzado o prenda), y   las   unidades   correspondientes,   
        calcule   el   valor   de   la   factura   con descuento y sin descuento. 
        Validar que existan las unidades necesarias para la venta y modificar las unidades existentes después de la venta utilizando el método set de la variable correspondiente.
        Para tener en cuenta: el porcentaje de descuento es el mismo para todos los productos, yes del 1%. */
        String menu = "S";
        while(menu.equals("S")){
           
            menu();
            System.out.println("Dese continuar: ");
            menu = leer.next();
            menu = menu.toUpperCase();
        }
    }


    
    //Método para llenar la información
    public static void llenarInfo(int cantidadProductos,boolean bandera){
        for (int i = 0 ; i < cantidadProductos; i++){
            
            System.out.println("\nDigite el Código del producto "+(i+1)+": ");
            int cod= leer.nextInt();

            System.out.println("\nDigite la descripción del producto "+(i+1)+": ");
            String descripcion= leer.next();
            
            System.out.println("\nDigite el Precio de compra del producto: ");
            int valorCompra= leer.nextInt();
    
            System.out.println("\nDigite el Precio de venta del producto: ");
            int valorVenta= leer.nextInt();
        
            System.out.println("\nDigite la cantidad en bodega del producto: ");
            int cantidadBodega= leer.nextInt();

            System.out.println("\nDigite la cantidad Máxima permitida del producto: ");
            int cantidadMaxima= leer.nextInt();

            System.out.println("\nDigite la cantidad mínima requerida del producto: ");
            int cantidadMinima= leer.nextInt();

            if(bandera){
                vectorPrendasVestir[i] = new PrendasVestir(cod, descripcion, valorCompra, valorVenta, cantidadBodega, cantidadMaxima, cantidadMinima);
                System.out.println("\nDigite la talla de la prenda: ");
                String talla= leer.next();

                System.out.println("\nDigite la prenda se puede planchar S/N: ");
                String planchado= leer.next();
                planchado = planchado.toUpperCase();
                boolean planchar;
                if(planchado.equals("S") || planchado.equals("SI")){
                     planchar = true;
                }else{
                    planchar = false;
                }
                vectorPrendasVestir[i].setTalla(talla);
                vectorPrendasVestir[i].setPlanchado(planchar);
    
            }else{
                vectorCalzado[i]= new Calzado(cod, descripcion, valorCompra, valorVenta, cantidadBodega, cantidadMaxima, cantidadMinima);
                System.out.println("\nDigite la talla del calzado: ");
                int talla= leer.nextInt();
                vectorCalzado[i].setTalla(talla);
            }
        }
    }

    /**Implemente en la clase principal un menú*/
    public static void menu(){
        int opcion = 0;

        System.out.println("**Menu de opciones**");
        System.out.println("Opcion 1: Verificar productos a pedir");
        System.out.println("Opcion 2: Calzado con mayor cantidad de unidades");
        System.out.println("Opcion 3: Prenda con mayor cantidad de unidades");
        //System.out.println("Opcion 4: Total a pagar por pedido a realizar");
        System.out.println("Opcion 4: Modificar cantidad minima requerida en bodega");
        System.out.println("Opcion 5: Vender producto");
        System.out.println("Digite la opción deseada: ");
        
        opcion= leer.nextInt();
    
        switch(opcion){
            case 1:
                produtosApedir();
                break;
            case 2:
                CalzadoMayorCantidad();
                break;
            case 3:
                PrendaMayorCantidad();
                break;
          //  case 4:
          //      comprarProducto();
          //      break;
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
        //.length para saver el tañao de los vectores
        System.out.println("\n************Prendas de vestir************");
        for(int i = 0; i <  vectorPrendasVestir.length ; i++){
            if(vectorPrendasVestir[i].solicitarPedido()){
                System.out.println("Alerta. se debe solicitar producto al proveedor.");
                System.out.println("Para el producto de codigo: "+vectorPrendasVestir[i].getCodigo());
            }
        }

        System.out.println("\n************Calzado************");
        for(int i = 0; i <  vectorCalzado.length; i++){
            if(vectorCalzado[i].solicitarPedido()){
                System.out.println("Alerta. se debe solicitar producto al proveedor.");
                System.out.println("Para el producto de codigo: "+vectorCalzado[i].getCodigo());
            }
        }
    }
        
    /**Indique cuál es el código del producto que tiene mayor cantidad de unidades 
     * en bodega, si hay varios que cumplen con la condición, indicar el primero de ellos. */
   public static void CalzadoMayorCantidad(){
       int cantidadMayorEnBodega =  vectorCalzado[0].getCantidadMaxima(); 
       int codigoMayorBodega = vectorCalzado[0].getCodigo();
       for(int i = 0; i < vectorCalzado.length; i++){
           if(cantidadMayorEnBodega <  vectorCalzado[i].getCantidadMaxima()){
               cantidadMayorEnBodega =  vectorCalzado[i].getCantidadMaxima(); 
               codigoMayorBodega = vectorCalzado[i].getCodigo();
               
            }
        }
        System.out.println("\t\t");
        System.out.println("El código del producto con mayor cantidad de unidades en bodega es: "+codigoMayorBodega);
        System.out.println("Con una cantidad en bodega de: "+cantidadMayorEnBodega);
    }
       
    /**Indique cuál es el código del producto que tiene mayor cantidad de unidades 
     * en bodega, si hay varios que cumplen con la condición, indicar el primero de ellos. */
   public static void PrendaMayorCantidad(){
    int cantidadMayorEnBodega =  vectorPrendasVestir[0].getCantidadMaxima(); 
    int codigoMayorBodega = vectorPrendasVestir[0].getCodigo();
    for(int i = 0; i < cantidadProductos; i++){
        if(cantidadMayorEnBodega <  vectorPrendasVestir[i].getCantidadMaxima()){
            cantidadMayorEnBodega =  vectorPrendasVestir[i].getCantidadMaxima(); 
            codigoMayorBodega = vectorPrendasVestir[i].getCodigo();
            
         }
     }
     System.out.println("\t\t");
     System.out.println("El código del producto con mayor cantidad de unidades en bodega es: "+codigoMayorBodega);
     System.out.println("Con una cantidad en bodega de: "+cantidadMayorEnBodega);
 }
               
    /**Cambiar la cantidad mínima requerida en bodega de un producto (leer código deproducto)
    * validar en el método set de la variable correspondiente que la nuevacantidad no sea menor a 0, 
    * en caso de serlo establecer la cantidad mínima como 0. */
    public static void cambiarCantidadMinima(){
        System.out.println("\t\t");
        System.out.println("Cambiar la cantidad mínima requerida en bodega");
        System.out.println("por favor indique el codigo del producto: ");
        int codigop = leer.nextInt();
        System.out.println("por favor indique el tipo del producto si es (Prenda o calsado) P/C: ");
        String tipoProducto = leer.next();
        tipoProducto = tipoProducto.toUpperCase(); // convertir el texto a mayúsculas
        System.out.println("porfavor indique la cantidad nueva: ");
        int cantidadMinima = leer.nextInt();
        
        if(tipoProducto.equals("P")){
            for(int i = 0; i < vectorPrendasVestir.length; i++){
                if(codigop == vectorPrendasVestir[i].getCodigo()){
                    vectorPrendasVestir[i].setCantidadMinima(cantidadMinima);
                    System.out.println("El valor de la cantidad minima es: "+vectorPrendasVestir[i].getCantidadMinima());
                }
            }
        }else if(tipoProducto.equals("C")){
            for(int i = 0; i < vectorCalzado.length; i++){
                if(codigop == vectorCalzado[i].getCodigo()){
                    vectorCalzado[i].setCantidadMinima(cantidadMinima);
                    System.out.println("El valor de la cantidad minima es: "+vectorCalzado[i].getCantidadMinima());
                }
            }
        }
    }    
   /**Leer un código de producto y una cantidad de unidades de compra, 
     * indicar el total apagar por ese pedido. Para ello utilice el 
     * método creado en la clase Producto pasando por parámetro la 
     * cantidad de unidades de compra. */
 /*   public static void comprarProducto(){
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
*/
    /**Vender producto: solicite el código de un producto a vender 
     * y las unidades correspondientes,
     * calcule el valor de la factura con descuento y sin descuento.
     * Validar que existan las unidades necesarias para la venta 
     * y modificar las unidades existentes después de la venta utilizando 
     * el método set de la variable correspondiente */
    public static void venderProducto(){
        System.out.println("\t\t");
        System.out.println("**Vender Producto**");
        System.out.println("por favor indique el codigo del producto: ");
        int codigoProducto = leer.nextInt();
        System.out.println("Por favor digite el tipo, si es Prenda de vestir o Calzado P/C:");
        String tipo = leer.next();
        System.out.println("por favor indique la cantidad de unidades: ");
        int cantidadUnidades = leer.nextInt();
        tipo = tipo.toUpperCase();
 
        venderProductoTotal(codigoProducto,cantidadUnidades, tipo);
        if(unidadesNesesarias(codigoProducto,cantidadUnidades, tipo )){
            System.out.println("Si hay unidades suficientes");
            cambiarCantidadMaxima( codigoProducto, cantidadUnidades, tipo);
        }else{
            System.out.println("No hay unidades suficientes");
        }
    }

      
    public static void venderProductoTotal(int codigoProducto, int cantidadUnidades, String tipo){
       
        if(tipo.equals("P")){
            for(int i = 0; i < vectorPrendasVestir.length; i++){
                if(codigoProducto == vectorPrendasVestir[i].getCodigo()){
                    System.out.println("Total a pagar por el producto de codigo "+codigoProducto);
                    vectorPrendasVestir[i].calcularTotalPagar(cantidadUnidades);
                }
            }
        }else if(tipo.equals("C")){
            for(int i = 0; i < vectorCalzado.length; i++){
                if(codigoProducto == vectorCalzado[i].getCodigo()){
                    System.out.println("Total a pagar por el producto de codigo "+codigoProducto);
                    vectorCalzado[i].calcularTotalPagar(cantidadUnidades);
                }
            }
        }
    }

    public static boolean unidadesNesesarias(int codigoProducto, int cantidadUnidades, String tipo){
       boolean resultado = false;
      
       if(tipo.equals("P")){
           for(int i = 0; i < vectorPrendasVestir.length; i++){
                if(codigoProducto == vectorPrendasVestir[i].getCodigo()){
                    if(cantidadUnidades <  vectorPrendasVestir[i].getCantidadBodega()){
                        resultado = true;
                        break;
                    }else{
                        resultado = false;
                        break;
                    }      
                }
            }
        }else if(tipo.equals("C")){
           for(int i = 0; i < vectorCalzado.length; i++){
               if(codigoProducto == vectorCalzado[i].getCodigo()){
                   if(cantidadUnidades <  vectorCalzado[i].getCantidadBodega()){
                       resultado = true;
                       break;
                   }else{
                       resultado = false;
                       break;
                   }      
               }
           }
        }
        return resultado;
    }

    public static void cambiarCantidadMaxima(int codigoProducto, int cantidadUnidades, String tipo){
           
        if(tipo.equals("P")){
            for(int i = 0; i < vectorPrendasVestir.length; i++){
                if(codigoProducto == vectorPrendasVestir[i].getCodigo()){
                    int cantidadActual = vectorPrendasVestir[i].getCantidadBodega() - cantidadUnidades;
                    vectorPrendasVestir[i].setCantidadBodega(cantidadActual);
                    System.out.println("La cantidad actual en bodega es: "+vectorPrendasVestir[i].getCantidadBodega());
                }
            }
        }else if(tipo.equals("C")){
            for(int i = 0; i < vectorCalzado.length; i++){
                if(codigoProducto == vectorCalzado[i].getCodigo()){
                    int cantidadActual = vectorCalzado[i].getCantidadBodega() - cantidadUnidades;
                    vectorCalzado[i].setCantidadBodega(cantidadActual);
                    System.out.println("La cantidad actual en bodega es: "+vectorCalzado[i].getCantidadBodega());
                }
            }
        }
    
    }  
}
