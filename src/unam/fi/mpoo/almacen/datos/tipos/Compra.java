package unam.fi.mpoo.almacen.datos.tipos;

import unam.fi.mpoo.almacen.datos.Registro;

public class Compra extends Registro {
    private String proveedor;
    private String producto;
    private String precio;
    private String cantidad;
    private String total;

    public Compra(int indice, String proveedor, String producto, String precio, String cantidad, String total) {
        super.setIndice(indice);
        this.proveedor = proveedor;
        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.total = total;
    }

    public String convertirATexto() {
        return super.getIndice()+":"+proveedor+":"+producto+":"+precio+":"+cantidad+":"+total;
    }
}
