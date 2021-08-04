public class Calzado extends Producto{
    private int talla = 0;

    public Calzado(int codigo, String descripcion, int precioCompra, int precioVenta, int cantidadBodega, int cantidadMaxima, int cantidadMinima) {
        super(codigo, descripcion, precioCompra, precioVenta, cantidadBodega, cantidadMaxima, cantidadMinima);
    }

    public int getTalla(){
        return talla;
    }

    public void setTalla(int talla){
        this.talla = talla;
    }
    
    /**Solicitar pedido: devuelva true si debe solicitar el producto al proveedor y false encaso contrario. */
    @Override
    public boolean solicitarPedido(){
        if(getCantidadMaxima() < getCantidadMinima()){
            return true;
        }else{
            return false;
        }
    }

    /**Calcular total a pagar : devuelva la cantidad total a pagar al proveedor dado unacantidad de unidades de compra */
    @Override
    public void calcularTotalPagar(int unidadesComprar){
        double  total = 0;
        double porcentajeDescuento = (getPrecioVenta() * 0.01);
        total = getPrecioVenta() * unidadesComprar;
        System.out.println("Total: "+total);
        total = (getPrecioVenta() - porcentajeDescuento)* unidadesComprar;
        System.out.println("Total con descuento: "+total);
    }

   /**Mostrar: devuelva una cadena descriptiva con la información del producto separadapor guión medio (-) */
    @Override
    public String mostrarTodo() {
        return (getCodigo()+"-"+getDescripcion()+"-"+getPrecioCompra()+"-"+getPrecioVenta()+"-"+getCantidadBodega()+"-"+getCantidadMinima()+"-"+getCantidadMaxima()+"-"+(getPorcentajeDescuento()*100)+"-"+talla);
    }

    @Override
    public String mostrarParte1() {
        return (getCodigo()+"-"+getDescripcion());
    }

    @Override
    public String mostrarParte2() {
        return (getCodigo()+"-"+getDescripcion()+"-"+getPrecioCompra()+"-"+getPrecioVenta());
    }

    /**Para tener en cuenta: 
     * el porcentaje de descuento es el mismo 
     * para todos los productos, y es del 1%.*/
    
}
