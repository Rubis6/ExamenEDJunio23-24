package ComercioElectronico;

public class lineapedido {

    public String articulo;
    public double precio;
    public int cantidad;

    public lineapedido(String articulo, double precio, int cantidad) {
        this.articulo = articulo;
        this.precio = precio;
        this.cantidad = cantidad;

    }

    @Override
    public String toString() {
        return "Artículo: " + articulo + ", precio: " + precio + ", cantidad: " + cantidad;
    }

}
