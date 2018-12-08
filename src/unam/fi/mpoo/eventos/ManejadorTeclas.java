package unam.fi.mpoo.eventos;

import unam.fi.mpoo.aplicacion.Ventas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Esta clase sirve para la ventana de ventas
 * cuando se cambia el valor de cantidad el subtotal , iva y total se actualiza
 */
public class ManejadorTeclas implements KeyListener {

    private Ventas ventas;

    public ManejadorTeclas(Ventas ventas){
        this.ventas = ventas;
    }

    public void keyPressed(KeyEvent e) {
        // Verificar que la tecla presionada sea un número
        if((e.getKeyChar() >= 48 && e.getKeyChar() <= 57) || e.getKeyChar() == 8) {

            // obtener valor
            String cant, cantidadTxt = ventas.getCantidadTxtBox().getText();
            // en caso de presionar la tecla retroceso y el valor esté vacio termina aquí
            if(e.getKeyChar() == 8 && cantidadTxt.equals(""))
                return;

            // Se realizan los calculos del producto como subtotal, iva y total
            int cantidad;
            double precio, subtotal, iva, total;
            // calcular precio
            precio = Double.parseDouble(ventas.getPrecioTxtBox().getText());
            // si presiona la tecla retroceso
            if(e.getKeyCode() == 8) {
                cant = cantidadTxt.substring(0, cantidadTxt.length()-1);
            } else {
                cant = cantidadTxt + (e.getKeyChar()-48);
            }

            // si la cantidad está vacia entonces los valores se actualizarán con 0
            if(cant.equals("")){
                cant = 0+"";
            }
            // convertir a numereo la cantidad
            cantidad = Integer.parseInt(cant);
            // hacer las operaciones
            subtotal = precio * cantidad;
            iva = subtotal * 0.10;
            total = subtotal - iva;
            // actualizar en la ventana el subtotal, iva y total
            ventas.setSubtotal(subtotal);
            ventas.setIva(iva);
            ventas.setTotal(total);
        }
    }

    public void keyReleased(KeyEvent arg0) {
    }

    public void keyTyped(KeyEvent keyEvent) {

    }
}
