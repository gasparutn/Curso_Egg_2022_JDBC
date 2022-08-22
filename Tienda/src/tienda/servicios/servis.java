package tienda.servicios;

import tienda.entidades.Producto;
import tienda.entidades.Fabricante;
import tienda.persistencia.DAO;

public class servis extends DAO {

    public void agregarProducto(Producto agregar) throws Exception {

        try {

            if (agregar == null) {
                throw new Exception("Debe ingresar un producto");
            }
            //INSERT INTO Producto (nombre,precio,codigo_fabricante VALUES ('compu', 200 , 2);
            String sql = "INSERT INTO producto (nombre,precio,codigo_fabricante) VALUES "
                    + "('" + agregar.getNombre() + "', " + agregar.getPrecio() + " ," + agregar.getCodigoFabricante() + ");";

            insertarModificarEliminar(sql);

        } catch (Exception e) {
            throw e;
        }
    }

    public Fabricante buscarcodigoFabricanteDisp(int codigo) throws Exception {
        try {

            String sql = "Select * from fabricante where codigo=" + codigo + ";";

            consultarBase(sql);
            Fabricante f = null;
            while (resultado.next()) {
                f = new Fabricante();
                f.setCodigo(resultado.getInt("codigo"));
                f.setNombre(resultado.getString("nombre"));
            }
            desconectarBase();
            return f;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public void editaruProducto(Producto modificar) throws Exception {

        try {
            if (modificar == null) {
                throw new Exception("Debe indicar el producto que desea modificar");
            }

            String sql = "UPDATE Producto SET "
                    + "nombre = '" + modificar.getNombre() + "' , precio = '"
                    + modificar.getPrecio() + "' , codigo_fabricante = '"
                    + modificar.getCodigoFabricante()
                    + "' WHERE (codigo = '" + modificar.getCodigo() + "');";

            insertarModificarEliminar(sql);

        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarproducto(String nombre) throws Exception {

        try {

            String sql = "DELETE FROM Producto where nombre = '" + nombre + "';";

            insertarModificarEliminar(sql);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al eliminar producto");
        }
    }

    public Producto buscarcodigoproducto(int codigo) throws Exception {
        try {

            String sql = "Select * from Producto where codigo=" + codigo + ";";

            consultarBase(sql);
            Producto p = null;
            while (resultado.next()) {
                p = new Producto();
                p.setCodigo(resultado.getInt("codigo"));
                p.setNombre(resultado.getString("nombre"));
                p.setPrecio(resultado.getDouble("precio"));
                p.setCodigoFabricante(resultado.getInt("codigo_fabricante"));
            }
            desconectarBase();
            return p;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
}
