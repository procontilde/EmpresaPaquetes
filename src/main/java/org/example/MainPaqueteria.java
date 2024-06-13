package org.example;

import java.util.Scanner;
import java.util.ArrayList;

public class MainPaqueteria {

    private static Scanner miScan = new Scanner(System.in);
    private static ArrayList<Paquete> misPaquetes = new ArrayList<>();
    private static StringsPaqueteria sP;

    public static void main(String[] args) {

        char option;

        do {

            System.out.println("Elija una de las siguientes opciones:\na. Empezar\nb. Info\nc. Salir");
            option = miScan.nextLine().charAt(0);

            switch (option) {

                case 'a':

                    menuPrincipal();
                    break;

                case 'b':

                    System.out.println(sP.getAUTOR());
                    break;

                case 'c':

                    System.out.println(sP.getDESPEDIDA());
                    break;

                default:

                    System.out.println(sP.getOPCION_VALIDA());
                    break;

            }

        } while (option != 'c');

    }

    public static void menuPrincipal() {

        char option;

        do {

            System.out.println("Elija una de las siguientes opciones: \n\na. Dar de alta un paquete\nb. Añadir producto a un paquete\nc. Eliminar producto de un paquete\nd. Buscar producto en un paquete\ne. Listar paquetes\nf. Listar productos de un paquete\ng. Salir");
            option = miScan.nextLine().charAt(0);

            switch (option) {

                case 'a':

                    alta();
                    break;

                case 'b':

                    anyadirProducto();
                    break;

                case 'c':

                    eliminarProducto();
                    break;

                case 'd':

                    buscarProducto();
                    break;

                case 'e':

                    listarPaquetes();
                    break;

                case 'f':

                    listarProductosDePaquete();
                    break;

                case 'g':

                    System.out.println(sP.getMENU_PRINCIPAL());
                    break;

                default:

                    System.out.println(sP.getOPCION_VALIDA());
                    break;

            }

        } while (option != 'g');

    }

    public static void alta() {

        System.out.println("Introduzca el localizador: ");
        String localizador = miScan.nextLine();
        System.out.println("Introduzca la dirección: ");
        String direccion = miScan.nextLine();
        System.out.println("Introduzca la fecha de envío: ");
        String fechaEnvio = miScan.nextLine();
        System.out.println("Introduzca los días de entrega: ");
        int diasEntrega = Integer.parseInt(miScan.nextLine());

        Paquete nuevoPaquete = new Paquete(localizador, direccion, fechaEnvio, diasEntrega);
        misPaquetes.add(nuevoPaquete);
        System.out.println(sP.getEXITO_CREAR_PAQUETE());

    }

    public static void anyadirProducto() {

        System.out.println("Introduzca el localizador del paquete: ");
        String localizador = miScan.nextLine();
        System.out.println("Introduzca el código del producto: ");
        String codigo = miScan.nextLine();
        System.out.println("Introduzca la descripción del producto: ");
        String descripcion = miScan.nextLine();
        System.out.println("Introduzca la cantidad del producto: ");
        int cantidad = Integer.parseInt(miScan.nextLine());
        System.out.println("Introduzca el peso del producto: ");
        float peso = Float.parseFloat(miScan.nextLine());

        Producto nuevoProducto = new Producto(codigo, descripcion, cantidad, peso);

        for (Paquete pq : misPaquetes) {

            if (pq.getLocalizador().equals(localizador)) {

                String resultado = pq.anyadirProducto(nuevoProducto);
                System.out.println(resultado);

                return;

            }

        }

        System.out.println(sP.getERROR3());

    }

    public static void eliminarProducto() {

        System.out.println("Introduzca el localizador del paquete: ");
        String localizador = miScan.nextLine();
        System.out.println("Introduzca el código del producto: ");
        String codigo = miScan.nextLine();

        for (Paquete pq : misPaquetes) {

            if (pq.getLocalizador().equals(localizador)) {

                String resultado = pq.eliminarProducto(codigo);
                System.out.println(resultado);

                return;

            }

        }

        System.out.println(sP.getERROR4());

    }

    public static void buscarProducto() {

        System.out.println("Introduzca el localizador del paquete: ");
        String localizador = miScan.nextLine();
        System.out.println("Introduzca el código del producto: ");
        String codigo = miScan.nextLine();

        for (Paquete p : misPaquetes) {

            if (localizador.equals(p.getLocalizador())) {

                Producto pr = p.buscarProducto(codigo);

                if (pr != null) {

                    System.out.println("Producto encontrado: " + pr);

                } else {

                    System.out.println(sP.getERROR2());

                }

                return;

            }

        }

        System.out.println(sP.getERROR3());

    }

    public static void listarPaquetes() {

        System.out.println("Lista de todos los paquetes:");

        for (Paquete p : misPaquetes) System.out.println(p.toString());

    }

    public static void listarProductosDePaquete() {

        System.out.println("Introduzca el localizador del paquete: ");
        String localizador = miScan.nextLine();

        for (Paquete p : misPaquetes) {

            if (localizador.equals(p.getLocalizador())) {

                String listado = p.listado();
                System.out.println(listado);

                return;

            }

        }

        System.out.println(sP.getERROR3());

    }

}
