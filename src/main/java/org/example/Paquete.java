package org.example;

import java.util.ArrayList;

/**
 *
 * @MrPró
 *
 */

public class Paquete {

    private String localizador, direccion, fechaEnvio;
    private int diasEntrega;
    private ArrayList<Producto> listaProductos;
    private enum Estados { VACIO, EN_PREPARACION, ENVIADO, ENTREGADO }
    private Estados estado;
    private StringsPaqueteria sP;

    public Paquete(String localizador, String direccion, String fechaEnvio, int diasEntrega) {

        this.localizador = localizador;
        this.direccion = direccion;
        this.fechaEnvio = fechaEnvio;
        this.diasEntrega = diasEntrega;
        this.listaProductos = new ArrayList<>();
        this.estado = Estados.VACIO;
        sP = new StringsPaqueteria();

    }

    public String anyadirProducto(Producto producto) {

        if (estado == Estados.VACIO || estado == Estados.EN_PREPARACION) {

            listaProductos.add(producto);
            return sP.getEXITO_ADD();

        } else {

            return sP.getERROR1();

        }

    }

    public String eliminarProducto(String codigo) {

        Producto productoAEliminar = buscarProducto(codigo);

        if (productoAEliminar != null) {

            listaProductos.remove(productoAEliminar);
            return sP.getEXITO_REMOVE();

        } else {

            return sP.getERROR2();

        }

    }

    public String listado() {

        StringBuilder sb = new StringBuilder();

        for (Producto producto : listaProductos) sb.append(producto.toString()).append("\n");

        return sb.toString();

    }

    public Producto buscarProducto(String codigo) {

        for (Producto producto : listaProductos) {

            if (codigo.equals(producto.getCodigo())) return producto;

        }

        return null;

    }

    public String getLocalizador() { return localizador; }
    public String getDireccion() { return direccion; }
    public String getFechaEnvio() { return fechaEnvio; }
    public int getDiasEntrega() { return diasEntrega; }
    public Estados getEstado() { return estado; }

    public void setLocalizador(String localizador) { this.localizador = localizador; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public void setFechaEnvio(String fechaEnvio) { this.fechaEnvio = fechaEnvio; }
    public void setDiasEntrega(int diasEntrega) { this.diasEntrega = diasEntrega; }
    public void setEstado(Estados estado) { this.estado = estado; }

    @Override
    public String toString() {

        return "PAQUETE:\nLocalizador: " + localizador
                + "\nDirección: " + direccion
                + "\nFecha de Envío: " + fechaEnvio
                + "\nEstado: " + estado
                + "\nDías previstos para Entrega: " + diasEntrega
                + "\nProductos: " + listaProductos;

    }

}






























