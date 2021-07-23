public class Producto {
    //Atributos
    private int codigo;
    private int precioCompra;
    private int precioVenta;
    private int cantidadMinima;
    private int cantidadMaxima;
    private double porcentajeDescuento;

    //Constructor
    public Producto(int codigo,int precioCompra, int cantidadMaxima, int cantidadMinima){
        this.codigo = codigo;
        this.precioCompra = precioCompra;
        this.cantidadMaxima = cantidadMaxima;
        this.cantidadMinima = cantidadMinima;
    }

    //Creamos los Get y et para nuestros atributos
    public int getCodigo(){
        return codigo;
    }

    public int getPrecioCompra(){
        return precioCompra;
    }

    public int getPrecioVenta(){
        return precioVenta;
    }

    public int getCantidadMaxima(){
        return cantidadMaxima;
    }

    public int getCantidadMinima(){
        return cantidadMinima;
    }

    public double getPorcentajeDescuento(){
        return porcentajeDescuento;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public void setPrecioCompra(int precioCompra){
        this.precioCompra = precioCompra;
    }

    public void setPrecioVenta(int precioVenta){
        this.precioVenta = precioVenta;
    }

    public void setCantidadMaxima(int cantidadMaxima){
        this.cantidadMaxima = cantidadMaxima;
    }

    public void setCantidadMinima(int cantidadMinima){
        
        if(cantidadMinima < 0){
            this.cantidadMinima = 0; 
        }else{
            this.cantidadMinima = cantidadMinima;
        }
    }


    public void setPorcentajeDescuento(double porcentajeDescuento){
        this.porcentajeDescuento = porcentajeDescuento;
    }


    //Metodos
    public boolean solicitarPedido(){
        if(cantidadMaxima < cantidadMinima){
            return true;
        }else{
            return false;
        }
    }

    public void calcularTotalPagar(int unidadesComprar){
        double  total = 0;
        porcentajeDescuento = (precioCompra * 0.01);
        total = precioCompra * unidadesComprar;
        System.out.println("Total: "+total);
        total = (precioCompra - porcentajeDescuento)* unidadesComprar;
      System.out.println("Total con descuento: "+total);
    }
    /**Para tener en cuenta: 
     * el porcentaje de descuento es el mismo 
     * para todos los productos, y es del 1%.*/
}
