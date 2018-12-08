package unam.fi.mpoo.almacen.datos.tipos;

import unam.fi.mpoo.almacen.datos.Registro;

public class Proveedor extends Registro {
    private String nombre;
    private String direccion;
    private String telefono;

    public Proveedor(int indice, String nombre, String direccion, String telefono) {
        super.setIndice(indice);
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String convertirATexto() {
        return super.getIndice()+":"+nombre+":"+direccion+":"+telefono;
    }
}
