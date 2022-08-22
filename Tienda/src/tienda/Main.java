package tienda;

import java.util.Collection;
import java.util.Scanner;
import tienda.entidades.Producto;
import tienda.persistencia.ProductoDAO;
import tienda.servicios.servis;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        ProductoDAO consultas = new ProductoDAO();
        servis tablaP = new servis();
        while (true) {
            System.out.println("*******INGRESE LA OPCION DE CONSULTA QUE DESEE INDICANDO LA LETRA*******");
            System.out.println("");
            System.out.println("a. Lista el nombre de todos los productos que hay en la tabla producto.");
            System.out.println("b. Nombres y los precios de todos los productos de la tabla producto.");
            System.out.println("c. Listar aquellos productos que su precio esté entre 120 y 202.");
            System.out.println("d. Buscar y listar todos los Portátiles de la tabla producto.");
            System.out.println("e. Listar el nombre y el precio del producto más barato.");
            System.out.println("f. Ingresar un producto a la base de datos.");
            System.out.println("g. Editar un producto con datos a elección.");
            System.out.println("h. Eliminar Producto Fabricante");
            System.out.println("i. Salir");

            String menu = "";
            menu = leer.nextLine();
            System.out.println("");

            if (menu.equals("i")) {
                break;
            }
            switch (menu) {

                case "a":
                    Collection<Producto> listnombres = consultas.listarNombres();
                    System.out.println("Productos que hay en la tabla producto:\n");
                    for (Producto p : listnombres) {
                        System.out.println(p.getNombre());
                    }
                    break;

                case "b":
                    Collection<Producto> listProdyPre = consultas.listarNombres();
                    System.out.println("Nombres y precios de productos:\n");
                    for (Producto p : listProdyPre) {
                        System.out.println("Nombre: " + p.getNombre() + "\nPrecio: " + p.getPrecio());
                    }
                    break;

                case "c":
                    Collection<Producto> PrecEntre = consultas.productoPreMayor();
                    System.out.println("Productos con precio entre $120 y $202\n");
                    for (Producto p : PrecEntre) {
                        System.out.println("Nombre: " + p.getNombre() + " Precio: " + p.getPrecio());
                    }
                    break;

                case "d":
                    Collection<Producto> ListPortatil = consultas.nombrePortatil();
                    System.out.println("Lista de Portátiles\n");
                    for (Producto p : ListPortatil) {
                        System.out.println("Nombre: " + p.getNombre());
                    }
                    break;

                case "e":
                    Collection<Producto> barato = consultas.listPreBarato();
                    System.out.println("Precio del Producto más barato:\n");
                    for (Producto p : barato) {
                        System.out.println("Nombre: " + p.getNombre() + " Precio: " + p.getPrecio());
                    }
                    break;

                case "f":
                    try {
                        Producto agregar = new Producto();
                        System.out.println("Ingrese el nombre del producto que desea agregar a la tabla producto:");
                        agregar.setNombre(leer.nextLine());
                        System.out.println("Ingrese el precio el producto: ");
                        agregar.setPrecio(leer.nextDouble());
                        leer.nextLine();
                        boolean validar = false;
                        System.out.println("Ingrese el numero de fabrincante: ");
                        int codigo = leer.nextInt();
                        do {
                            agregar.setCodigoFabricante(codigo);

                            if (tablaP.buscarcodigoFabricanteDisp(codigo) == null) {
                                System.out.println("*****CODIGO DE FABRICANTE INEXISTENTE*****");
                                System.out.println("");
                                System.out.println("Ingrese un codigo de fabricante existente porfavor: ");
                                codigo = leer.nextInt();
                            } else {
                                validar = true;
                            }

                        } while (validar = false);
                        agregar.setCodigoFabricante(codigo);
                        tablaP.agregarProducto(agregar);

                    } catch (Exception e) {
                        throw e;
                    }
                    break;

                case "g":
                    try {
                        servis modOK = new servis();
                        System.out.println("Ingrese el codigo del producto que desea modificar a la tabla producto:");
                        Producto mod = modOK.buscarcodigoproducto(leer.nextInt());
                        leer.nextLine();
                        if (mod == null) {
                            throw new Exception("No existe producto");
                        } else {
                            while (true) {
                                System.out.println("****USTED SELECCIONÓ****:\n");
                                System.out.println(mod.toString() + "\n");
                                System.out.println("Que columna quiere modificar?");
                                System.out.println("a. Nombre");
                                System.out.println("b. Precio");
                                System.out.println("c. Codigo fabricante");
                                System.out.println("S. SALIR");

                                String submenu = leer.nextLine();
                                if (submenu.equals("salir")) {
                                    break;
                                }
                                switch (submenu) {

                                    case "a":
                                        System.out.println("Ingrese nuevo nombre: ");
                                        mod.setNombre(leer.nextLine());
                                        modOK.editaruProducto(mod);
                                        System.out.println("Se ha actualizado el nombre");
                                        break;
                                    case "b":
                                        System.out.println("Ingrese nuevo precio: ");
                                        mod.setPrecio(leer.nextDouble());
                                        leer.nextLine();
                                        modOK.editaruProducto(mod);
                                        System.out.println("Se ha actualizado el precio");
                                        break;
                                    case "c":
                                        System.out.println("Ingrese nuevo codigo de fabricante: ");
                                        int cod = leer.nextInt();
                                        leer.nextLine();
                                        if (modOK.buscarcodigoFabricanteDisp(cod) != null) {
                                            mod.setCodigoFabricante(cod);
                                            modOK.editaruProducto(mod);
                                            System.out.println("Se ha actualizado el codigo de fabricante");
                                        } else {
                                            System.out.println("El codigo de fabricante no existe");
                                        }
                                        break;
                                    default:
                                        System.out.println("Ha ingresa una letra incorrecta");
                                }
                            }
                        }
                    } catch (Exception e) {
                        throw e;
                    }
                    break;

                case "h":
                    try {
                        servis elimina = new servis();
                        System.out.println("Ingrese el nombre del producto que desea eliminar");
                        elimina.eliminarproducto(leer.nextLine());

                    } catch (Exception e) {
                        throw e;
                    }

                case "i":

                    break;

                default:
                    System.out.println("*****Ha ingresado un letra incorrecta******\n          >>>>VUELVA A INTENTAR<<<<\n");

            }
        }
    }
}
