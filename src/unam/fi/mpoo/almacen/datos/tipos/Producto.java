package unam.fi.mpoo.almacen.datos.tipos;

import unam.fi.mpoo.almacen.datos.Registro;

public class Producto extends Registro {
    private String nombre;
    private String marca;
    private String precio;

    public Producto(int indice, String nombre, String marca, String precio) {
        super.setIndice(indice);
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
    }

    public String convertirATexto() {
        return super.getIndice()+":"+nombre+":"+marca+":"+precio;
    }
}
