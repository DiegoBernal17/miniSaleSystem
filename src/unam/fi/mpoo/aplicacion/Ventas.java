package unam.fi.mpoo.aplicacion;

import unam.fi.mpoo.almacen.Administrador;
import unam.fi.mpoo.controles.CajaTexto;
import unam.fi.mpoo.controles.Etiqueta;
import unam.fi.mpoo.controles.ListaDesplegable;
import unam.fi.mpoo.controles.botones.BotonVerde;
import unam.fi.mpoo.controles.botones.BotonRegresar;
import unam.fi.mpoo.eventos.ManejadorEventos;
import unam.fi.mpoo.eventos.ManejadorTeclas;

import javax.swing.*;
import java.awt.*;

public class Ventas extends JFrame {

    private JPanel panelNorte;
    private JPanel panelCentro;
    private JPanel panelSur;
    private ListaDesplegable productosList;
    private CajaTexto precioTxtBox;
    private CajaTexto cantidadTxtBox;
    private Etiqueta subtotalLbl;
    private Etiqueta ivaLbl;
    private Etiqueta totalLbl;
    private BotonRegresar cerrarBtn;
    private BotonVerde aceptarBtn;

    public static final String TITULO_VENTANA = "Venta de productos";
    public static final String MSG_BOTON = "Realizar venta";

    private ManejadorEventos me;

    public final int ANCHO_VENTANA_PRINCIPAL=300;
    public final int ALTO_VENTANA_PRINCIPAL=300;

    public Ventas(ManejadorEventos menu) {
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
        Etiqueta titulo = new Etiqueta("Registra nueva venta");

        panelNorte.add(titulo);
        add(panelNorte, BorderLayout.NORTH);
    }

    private void construirCentro() {
        panelCentro = new JPanel();
        panelCentro.setLayout(new BoxLayout(panelCentro,BoxLayout.Y_AXIS));
        Administrador adm = new Administrador();
        String[] productos = adm.getInformacion(1);
        String[] precios = adm.getInformacion(3);
        String precio;
        if(precios.length > 0)
            precio = precios[0];
        else
            precio = "0";
        Etiqueta seleccionProductoLbl = new Etiqueta("Seleciona el producto: ");
        productosList = new ListaDesplegable(productos);
        productosList.addActionListener(me);
        Etiqueta precioProductoLbl = new Etiqueta("Precio del producto: $");
        precioTxtBox = new CajaTexto(9);
        precioTxtBox.setText(precio);
        precioTxtBox.setEditable(false);
        Etiqueta cantidadLbl = new Etiqueta("Cantidad: ");
        cantidadTxtBox = new CajaTexto(9);
        cantidadTxtBox.setText("0");
        subtotalLbl = new Etiqueta("Subtotal: $0.0");
        ivaLbl = new Etiqueta("Iva: $0.0");
        totalLbl = new Etiqueta("Total: $0.0");

        cantidadTxtBox.addKeyListener(new ManejadorTeclas(this));

        panelCentro.add(seleccionProductoLbl);
        panelCentro.add(productosList);
        panelCentro.add(precioProductoLbl);
        panelCentro.add(precioTxtBox);
        panelCentro.add(cantidadLbl);
        panelCentro.add(cantidadTxtBox);
        panelCentro.add(subtotalLbl);
        panelCentro.add(ivaLbl);
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

    public CajaTexto getPrecioTxtBox() {
        return precioTxtBox;
    }
    public CajaTexto getCantidadTxtBox() {
        return cantidadTxtBox;
    }

    public void setPrecio(String precio) { this.precioTxtBox.setText(precio); }
    public void setSubtotal(double subtotal) {
        this.subtotalLbl.setText("Subtotal: $"+subtotal);
    }
    public void setIva(double iva) {
        this.ivaLbl.setText("Iva: $"+iva);
    }
    public void setTotal(double total) {
        this.totalLbl.setText("Total: $"+total);
    }

    public ListaDesplegable getProductosList() {
        return productosList;
    }

    public Etiqueta getSubtotalLbl() {
        return subtotalLbl;
    }

    public Etiqueta getIvaLbl() {
        return ivaLbl;
    }

    public Etiqueta getTotalLbl() {
        return totalLbl;
    }
}
