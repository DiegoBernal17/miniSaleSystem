package unam.fi.mpoo.aplicacion;

import unam.fi.mpoo.controles.CajaTexto;
import unam.fi.mpoo.controles.Etiqueta;
import unam.fi.mpoo.controles.botones.BotonVerde;
import unam.fi.mpoo.controles.botones.BotonRegresar;
import unam.fi.mpoo.eventos.ManejadorEventos;

import javax.swing.*;
import java.awt.*;

public class Proveedores  extends JFrame {

    private JPanel panelNorte;
    private JPanel panelCentro;
    private JPanel panelSur;
    private CajaTexto nombreTxt;
    private CajaTexto direccionTxt;
    private CajaTexto telefonoTxt;
    private BotonVerde aceptarBtn;
    private BotonRegresar cerrarBtn;

    public static final String TITULO_VENTANA = "Proveedores";
    public static final String MSG_BOTON = "Agregar proveedor";

    private ManejadorEventos me;

    public final int ANCHO_VENTANA_PRINCIPAL=300;
    public final int ALTO_VENTANA_PRINCIPAL=300;

    public Proveedores(ManejadorEventos menu) {
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
        Etiqueta titulo = new Etiqueta("Registrar nuevo proveedor");

        panelNorte.add(titulo);
        add(panelNorte, BorderLayout.NORTH);
    }

    private void construirCentro() {
        panelCentro = new JPanel();
        panelCentro.setLayout(new BoxLayout(panelCentro,BoxLayout.Y_AXIS));

        Etiqueta nombreLbl = new Etiqueta("Nombre: ");
        Etiqueta direccionLbl = new Etiqueta("Dirección: ");
        Etiqueta telefonoLbl = new Etiqueta("Teléfono: ");

        nombreTxt = new CajaTexto(10);
        direccionTxt = new CajaTexto(10);
        telefonoTxt = new CajaTexto(10);

        panelCentro.add(nombreLbl);
        panelCentro.add(nombreTxt);
        panelCentro.add(direccionLbl);
        panelCentro.add(direccionTxt);
        panelCentro.add(telefonoLbl);
        panelCentro.add(telefonoTxt);
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

    public CajaTexto getDireccionTxt() {
        return direccionTxt;
    }

    public CajaTexto getTelefonoTxt() {
        return telefonoTxt;
    }
}
