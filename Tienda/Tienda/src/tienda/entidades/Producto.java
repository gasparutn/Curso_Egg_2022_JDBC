
package tienda.entidades;

public class Producto {
    
    private int codigo;
    private String nombre;
    private double precio;
    private int codigoFabricante;
    
    public Producto() {
    }

    public Producto(int codigo, String nombre, double precio, int codigoFabricantel) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.codigoFabricante = codigoFabricantel;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCodigoFabricante() {
        return codigoFabricante;
    }

    public void setCodigoFabricantel(int codigoFabricantel) {
        this.codigoFabricante = codigoFabricantel;
    }

    @Override
    public String toString() {
        return "producto{" + "codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", codigoFabricantel=" + codigoFabricante + '}';
    }
    
}
