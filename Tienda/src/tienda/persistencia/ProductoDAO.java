package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Producto;
import tienda.entidades.Fabricante;

public class ProductoDAO extends DAO {

    public ProductoDAO() {
    }

    public Collection<Producto> listarNombres() throws Exception {
        Collection<Producto> nombres = new ArrayList();
        try {
            String sql;
            sql = "SELECT * FROM producto p LEFT JOIN fabricante f ON f.codigo = p.codigo_fabricante;";

            consultarBase(sql);
            Producto todosp = null;
            Fabricante todosf = null;
            while (resultado.next()) {
                todosp = new Producto();
                todosf = new Fabricante();
                todosp.setCodigo(resultado.getInt("Codigo"));
                todosp.setNombre(resultado.getString("nombre"));
                todosp.setPrecio(resultado.getDouble("precio"));
                todosp.setCodigoFabricante(resultado.getInt("Codigo_Fabricante"));
                todosf.setCodigo(resultado.getInt(5));
                todosf.setNombre(resultado.getString(6));
                nombres.add(todosp);
            }
            desconectarBase();
            return nombres;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error de sistema");
        }
    }

    public ArrayList<Producto> productoPreMayor() throws Exception {

        try {
            String sql;
            sql = "SELECT * FROM producto where precio BETWEEN 120 and 202 ";

            consultarBase(sql);
            Producto todos = null;
            ArrayList<Producto> nombres = new ArrayList();
            while (resultado.next()) {
                todos = new Producto();
                todos.setNombre(resultado.getString("nombre"));
                todos.setPrecio(resultado.getDouble("precio"));
                todos.setCodigoFabricante(resultado.getInt("Codigo_Fabricante"));
                todos.setCodigo(resultado.getInt("Codigo"));
                nombres.add(todos);
            }
            desconectarBase();
            return nombres;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error de sistema");
        }
    }

    public ArrayList<Producto> nombrePortatil() throws Exception {

        try {
            String sql;
            sql = "SELECT * from producto where nombre like '%Portatil%'";

            consultarBase(sql);
            Producto todos = null;
            ArrayList<Producto> portatil = new ArrayList();
            while (resultado.next()) {
                todos = new Producto();
                todos.setNombre(resultado.getString("nombre"));
                todos.setPrecio(resultado.getDouble("precio"));
                todos.setCodigoFabricante(resultado.getInt("Codigo_Fabricante"));
                todos.setCodigo(resultado.getInt("Codigo"));
                portatil.add(todos);
            }
            desconectarBase();
            return portatil;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error de sistema");
        }
    }

    public ArrayList<Producto> listPreBarato() throws Exception {

        try {
            String sql;
            sql = "select * from producto order by precio asc limit 1";

            consultarBase(sql);
            Producto todos = null;
            ArrayList<Producto> preBarato = new ArrayList();
            while (resultado.next()) {
                todos = new Producto();
                todos.setNombre(resultado.getString("nombre"));
                todos.setPrecio(resultado.getDouble("precio"));
                todos.setCodigoFabricante(resultado.getInt("Codigo_Fabricante"));
                todos.setCodigo(resultado.getInt("Codigo"));
                preBarato.add(todos);
            }
            desconectarBase();
            return preBarato;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error de sistema");
        }
    }
}
