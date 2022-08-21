package tienda;

import java.util.ArrayList;
import java.util.Scanner;
import tienda.entidades.Producto;
import tienda.servicios.servis;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

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
            System.out.println("h. Salir");

            String menu = "";
            menu = leer.nextLine();
            System.out.println("");

            if (menu.equals("h")) {
                break;
            }

            switch (menu) {

                case "a":
                    ArrayList<Producto> productos = tablaP.listarNombres();
                    System.out.println("Productos que hay en la tabla producto:\n");
                    for (Producto p : productos) {
                        System.out.println(p.getNombre());
                    }
                    break;

                case "b":
                    ArrayList<Producto> listProdyPre = tablaP.listarNombres();
                    System.out.println("Nombres y precios de productos:\n");
                    for (Producto p : listProdyPre) {
                        System.out.println("Nombre: " + p.getNombre() + "\nPrecio: " + p.getPrecio());
                    }
                    break;

                case "c":
                    ArrayList<Producto> PrecEntre = tablaP.productoPreMayor();
                    System.out.println("Productos con precio entre $120 y $202\n");
                    for (Producto p : PrecEntre) {
                        System.out.println("Nombre: " + p.getNombre() + " Precio: " + p.getPrecio());
                    }
                    break;

                case "d":
                    ArrayList<Producto> ListPortatil = tablaP.nombrePortatil();
                    System.out.println("Lista de Portátiles\n");
                    for (Producto p : ListPortatil) {
                        System.out.println("Nombre: " + p.getNombre());
                    }
                    break;

                case "e":
                    ArrayList<Producto> barato = tablaP.listPreBarato();
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
                /*
                    
                   
                case "g":

                    break;
                 */
                case "h":

                    break;

                default:
                    System.out.println("*****Ha ingresado un letra incorrecta******\n          >>>>VUELVA A INTENTAR<<<<\n");

            }
        }
    }
}
