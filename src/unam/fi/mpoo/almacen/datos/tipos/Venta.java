package unam.fi.mpoo.almacen.datos.tipos;

import unam.fi.mpoo.almacen.datos.Registro;

public class Venta extends Registro {
    private String producto;
    private String precio;
    private String cantidad;
    private String subtotal;
    private String iva;
    private String total;

    public Venta(int indice, String producto, String precio, String cantidad, String subtotal, String iva, String total) {
        super.setIndice(indice);
        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
    }

    public String convertirATexto() {
        return super.getIndice()+":"+producto+":"+precio+":"+cantidad+":"+subtotal+":"+iva+":"+total;
    }
}
