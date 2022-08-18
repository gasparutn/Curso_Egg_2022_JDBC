package tienda.servicios;

import java.util.ArrayList;

import tienda.entidades.Producto;
import tienda.persistencia.DAO;

public class servis extends DAO {

    public ArrayList<Producto> listarNombres() throws Exception {

        try {
            String sql;
            sql = "SELECT * FROM producto";

            consultarBase(sql);
            
            Producto todos = null;
            ArrayList<Producto> nombres = new ArrayList();
            while (resultado.next()) {
                todos = new Producto();
                todos.setNombre(resultado.getString("nombre"));
                todos.setPrecio(resultado.getDouble("precio"));
                todos.setCodigoFabricantel(resultado.getInt("Codigo_Fabricante"));
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
                todos.setCodigoFabricantel(resultado.getInt("Codigo_Fabricante"));
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
                todos.setCodigoFabricantel(resultado.getInt("Codigo_Fabricante"));
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
                todos.setCodigoFabricantel(resultado.getInt("Codigo_Fabricante"));
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
   
    
     /*
    
 
    public void agregarProducto(Producto agregar) throws Exception {

        try {
            
           if(agregar == null) {
                throw new Exception("Debe ingresar un producto");
            }
            String sql = "INSERT INTO producto (Codigo, Nombre)" 
                       + 'VALUES ( '"" +  

            insertarModificarEliminar(sql);
            
            
            
        } catch (Exception e) {
           throw e;
        }
   
    }
   */
}