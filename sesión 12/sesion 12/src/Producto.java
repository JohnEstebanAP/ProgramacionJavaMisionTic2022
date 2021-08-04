public abstract class Producto implements Vista {
    //Atributos
    private int codigo;
    private String descripcion;
    private int precioCompra;
    private int precioVenta;
    private int cantidadBodega;
    private int cantidadMinima;
    private int cantidadMaxima;
    private double porcentajeDescuento= 0.01;

    //Constructor
    public Producto(int codigo,String descripcion,int precioCompra, int precioVenta, int cantidadBodega, int cantidadMaxima, int cantidadMinima){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.cantidadBodega = cantidadBodega;
        this.cantidadMaxima = cantidadMaxima;
        this.cantidadMinima = cantidadMinima;
    } 


    //Creamos los Get y et para nuestros atributos
    public int getCodigo(){
        return codigo;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public int getPrecioCompra(){
        return precioCompra;
    }

    public int getPrecioVenta(){
        return precioVenta;
    }

    public int getCantidadBodega(){
        return cantidadBodega;
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

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public void setPrecioCompra(int precioCompra){
        this.precioCompra = precioCompra;
    }

    public void setPrecioVenta(int precioVenta){
        this.precioVenta = precioVenta;
    }

    public void setCantidadBodega(int cantidadBodega){
        this.cantidadBodega = cantidadBodega;
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
    
    /**Mostrar: devuelva una cadena descriptiva con la información del producto separadapor guión medio (-) */
    //public abstract String mostrar();
    /**Solicitar pedido: devuelva true si debe solicitar el producto al proveedor y false encaso contrario. */
    public abstract boolean solicitarPedido();
    /**Calcular total a pagar : devuelva la cantidad total a pagar al proveedor dado unacantidad de unidades de compra */
    public abstract void calcularTotalPagar(int unidadesComprar);
}
