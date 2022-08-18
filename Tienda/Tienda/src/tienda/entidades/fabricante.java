
package tienda.entidades;

public class fabricante {
    private int codigo;
    private String nombre;

    public fabricante() {
    }

    public fabricante(int codigo, String fabricante) {
        this.codigo = codigo;
        this.nombre = fabricante;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFabricante() {
        return nombre;
    }

    public void setFabricante(String fabricante) {
        this.nombre = fabricante;
    }
    
    
    
}
