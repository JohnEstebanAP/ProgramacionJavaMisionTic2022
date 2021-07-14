public class Producto {
    //Atributos
    private int codigo;
    private int precioCompra;
    private int cantidadBodega;
    private int cantidadMinima;
    
    //Constructor
    public Producto(int codigo,int precioCompra, int cantidadBodega, int cantidadMinima){
        this.codigo = codigo;
        this.precioCompra = precioCompra;
        this.cantidadBodega = cantidadBodega;
        this.cantidadMinima = cantidadMinima;
    }

    //Creamos los Get y et para nuestros atributos
    public int getCodigo(){
        return codigo;
    }

    public int getPrecioCompra(){
        return precioCompra;
    }

    public int getCantidadBodega(){
        return cantidadBodega;
    }

    public int getCantidadMinima(){
        return cantidadMinima;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public void setPrecioCompra(int precioCompra){
        this.precioCompra = precioCompra;
    }

    public void setCantidadBodega(int cantidadBodega){
        this.cantidadBodega = cantidadBodega;
    }

    public void setCantidadMinima(int cantidadMinima){
        this.cantidadMinima = cantidadMinima;
    }

    //Metodos
    public boolean solicitarPedido(){
        if(cantidadBodega < cantidadMinima){
            return true;
        }else{
            return false;
        }
    }
    
}
