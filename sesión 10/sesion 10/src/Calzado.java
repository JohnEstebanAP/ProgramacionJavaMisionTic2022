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

    public String mostrar(){
        return super.mostrar()+"-"+talla;
    }
    
}
