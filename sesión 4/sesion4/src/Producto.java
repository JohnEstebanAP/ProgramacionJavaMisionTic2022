public class Producto {
    //Atributos
    int codigo;
    double precioCompra;
    int cantidadBodega;
    int cantidadMinima;
    
    //Constructor
    public Producto(int codigo,double precioCompra, int cantidadBodega, int cantidadMinima){
        this.codigo = codigo;
        this.precioCompra = precioCompra;
        this.cantidadBodega = cantidadBodega;
        this.cantidadMinima = cantidadMinima;
    }
    
    //Metodos
    public boolean SolicitarPedido(){
        if(cantidadBodega < cantidadMinima){
            return true;
        }else{
            return false;
        }
    }
    
}
