public class PrendasVestir extends Producto{
    private String talla = " ";
    private boolean planchado = true;
    public PrendasVestir(int codigo, String descripcion, int precioCompra, int precioVenta, int cantidadBodega,int cantidadMaxima, int cantidadMinima) {
        super(codigo, descripcion, precioCompra, precioVenta, cantidadBodega, cantidadMaxima, cantidadMinima);
        //TODO Auto-generated constructor stub
    }

    public String getTalla(){
        return talla;
    }

    public boolean getPlanchado(){
        return planchado;
    }
    public void setTalla(String talla){
        this.talla= talla;
    }

    public void setPlanchado(boolean planchado){
        this.planchado = planchado;
    }

    public String mostrar(){
        return super.mostrar()+"-"+talla+"-"+planchado;
    }
}

