package unam.fi.mpoo.aplicacion;

import unam.fi.mpoo.controles.CajaTexto;
import unam.fi.mpoo.controles.Etiqueta;
import unam.fi.mpoo.controles.botones.BotonVerde;
import unam.fi.mpoo.controles.botones.BotonRegresar;
import unam.fi.mpoo.eventos.ManejadorEventos;

import javax.swing.*;
import java.awt.*;

public class NuevoProducto extends JFrame {
    public static final String TITULO_VENTANA = "Productos en almacen";

    private JPanel panelNorte;
    private JPanel panelCentro;
    private CajaTexto nombreTxt;
    private CajaTexto precioTxt;
    private CajaTexto marcaTxt;
    private JPanel panelSur;
    private BotonVerde aceptarBtn;
    private BotonRegresar cerrarBtn;
    private ManejadorEventos me;

    public final int ANCHO_VENTANA_PRINCIPAL=300;
    public final int ALTO_VENTANA_PRINCIPAL=300;

    public static final String MSG_BOTON = "Agregar producto";

    public NuevoProducto(ManejadorEventos menu) {
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
        Etiqueta titulo = new Etiqueta("Agregar nuevo producto");

        panelNorte.add(titulo);
        add(panelNorte, BorderLayout.NORTH);
    }

    private void construirCentro() {
        panelCentro = new JPanel();
        panelCentro.setLayout(new BoxLayout(panelCentro,BoxLayout.Y_AXIS));

        Etiqueta nombreLbl = new Etiqueta("Nombre:");
        nombreTxt = new CajaTexto(10);
        Etiqueta marcaLbl = new Etiqueta("Marca:");
        marcaTxt = new CajaTexto(10);
        Etiqueta precioLbl = new Etiqueta("Precio de venta: $");
        precioTxt = new CajaTexto(10);

        panelCentro.add(nombreLbl);
        panelCentro.add(nombreTxt);
        panelCentro.add(marcaLbl);
        panelCentro.add(marcaTxt);
        panelCentro.add(precioLbl);
        panelCentro.add(precioTxt);
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

    public CajaTexto getNombreTxt() {
        return nombreTxt;
    }

    public CajaTexto getMarcaTxt() {
        return marcaTxt;
    }

    public CajaTexto getPrecioTxt() {
        return precioTxt;
    }
}
