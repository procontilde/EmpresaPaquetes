package org.example;

/**
 *
 * @MrPró
 *
 */

public class Producto {

    private String codigo, descripcion;
    private int cantidad;
    private float peso;

    public Producto(String codigo, String descripcion, int cantidad, float peso) {

        this.codigo = codigo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.peso = peso;

    }

    public String getCodigo() { return codigo; }
    public String getDescripcion() { return descripcion; }
    public int getCantidad() { return cantidad; }
    public float getPeso() { return peso; }

    public void setCodigo(String codigo) { this.codigo = codigo; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public void setPeso(float peso) { this.peso = peso; }

    @Override
    public String toString() {

        return "PRODUCTO:\nCódigo: " + codigo
                + "\nDescripción: " + descripcion
                + "\nCantidad: " + cantidad
                + "\nPeso: " + peso;

    }

}

