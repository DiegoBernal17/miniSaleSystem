package unam.fi.mpoo.aplicacion;

import unam.fi.mpoo.almacen.Administrador;
import unam.fi.mpoo.controles.CajaTexto;
import unam.fi.mpoo.controles.Etiqueta;
import unam.fi.mpoo.controles.ListaDesplegable;
import unam.fi.mpoo.controles.botones.BotonVerde;
import unam.fi.mpoo.controles.botones.BotonRegresar;
import unam.fi.mpoo.eventos.ManejadorEventos;

import javax.swing.*;
import java.awt.*;

public class Compras  extends JFrame {

    private JPanel panelNorte;
    private JPanel panelCentro;
    private JPanel panelSur;
    private ListaDesplegable proveedoresList;
    private ListaDesplegable productosList;
    private CajaTexto precioTxtBox;
    private CajaTexto cantidadTxtBox;
    private Etiqueta totalLbl;
    private BotonVerde aceptarBtn;
    private BotonRegresar cerrarBtn;

    public static final String TITULO_VENTANA = "Compra a proveedores";
    public static final String MSG_BOTON = "Realizar compra";

    private ManejadorEventos me;

    public final int ANCHO_VENTANA_PRINCIPAL=300;
    public final int ALTO_VENTANA_PRINCIPAL=300;

    public Compras(ManejadorEventos menu) {
        super();
        super.setTitle(TITULO_VENTANA);
        super.setPreferredSize(new Dimension(ANCHO_VENTANA_PRINCIPAL,ALTO_VENTANA_PRINCIPAL));
        this.setLayout(new BorderLayout());

        me = menu;

        construirNorte();
        construirCentro();
        construirSur();

        super.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        super.pack();
        super.setLocationRelativeTo(null);
        super.setResizable(false);
        super.setVisible(true);
        super.repaint();
    }

    private void construirNorte() {
        panelNorte = new JPanel();
        panelNorte.setBackground(Color.lightGray);
        Etiqueta titulo = new Etiqueta("Compra a proveedores");

        panelNorte.add(titulo);
        add(panelNorte, BorderLayout.NORTH);
    }

    private void construirCentro() {
        panelCentro = new JPanel();
        panelCentro.setLayout(new BoxLayout(panelCentro,BoxLayout.Y_AXIS));
        Administrador adm = new Administrador();
        String[] productos = adm.getInformacion(1);
        adm.seleccionarAlmacen(2);
        String[] proveedores = adm.getInformacion(1);
        Etiqueta proveedorLbl = new Etiqueta("Seleciona el proveedor: ");
        proveedoresList = new ListaDesplegable(proveedores);
        Etiqueta productoLbl = new Etiqueta("Seleciona el producto: ");
        productosList = new ListaDesplegable(productos);
        Etiqueta precioProductoLbl = new Etiqueta("Precio de compra: $");
        precioTxtBox = new CajaTexto(9);
        precioTxtBox.setText("0");
        Etiqueta cantidadLbl = new Etiqueta("Cantidad: ");
        cantidadTxtBox = new CajaTexto(9);
        cantidadTxtBox.setText("0");
        totalLbl = new Etiqueta("Precio total: $0.0");

        panelCentro.add(proveedorLbl);
        panelCentro.add(proveedoresList);
        panelCentro.add(productoLbl);
        panelCentro.add(productosList);
        panelCentro.add(precioProductoLbl);
        panelCentro.add(precioTxtBox);
        panelCentro.add(cantidadLbl);
        panelCentro.add(cantidadTxtBox);
        panelCentro.add(totalLbl);
        add(panelCentro, BorderLayout.CENTER);
    }

    private void construirSur() {
        panelSur = new JPanel();

        aceptarBtn = new BotonVerde(MSG_BOTON, me);
        cerrarBtn = new BotonRegresar(me);

        panelSur.add(aceptarBtn);
        panelSur.add(cerrarBtn);
        add(panelSur, BorderLayout.SOUTH);
    }

    public ListaDesplegable getProveedoresList() {
        return proveedoresList;
    }

    public ListaDesplegable getProductosList() {
        return productosList;
    }

    public CajaTexto getPrecioTxtBox() {
        return precioTxtBox;
    }

    public CajaTexto getCantidadTxtBox() {
        return cantidadTxtBox;
    }

    public Etiqueta getTotalLbl() {
        return totalLbl;
    }
}
