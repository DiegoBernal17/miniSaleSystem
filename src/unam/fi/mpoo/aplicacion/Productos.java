package unam.fi.mpoo.aplicacion;

import unam.fi.mpoo.almacen.Administrador;
import unam.fi.mpoo.controles.Boton;
import unam.fi.mpoo.controles.Etiqueta;
import unam.fi.mpoo.controles.botones.BotonVerde;
import unam.fi.mpoo.controles.botones.BotonRegresar;
import unam.fi.mpoo.eventos.ManejadorEventos;

import javax.swing.*;
import java.awt.*;

public class Productos extends JFrame {

    private JPanel panelNorte;
    private JPanel panelCentro;
    private JPanel panelProductos;
    private JPanel panelSur;
    private Boton nuevoProducto;
    private BotonRegresar cerrarBtn;

    public static final String TITULO_VENTANA = "Productos en almacen";
    public static final String NUEVO_PRODUCTO_BOTON = "Nuevo Producto";

    private ManejadorEventos me;

    public final int ANCHO_VENTANA_PRINCIPAL=300;
    public final int ALTO_VENTANA_PRINCIPAL=300;

    public Productos(ManejadorEventos menu) {
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
        Etiqueta titulo = new Etiqueta("Todos los productos");

        panelNorte.add(titulo);
        add(panelNorte, BorderLayout.NORTH);
    }

    private void construirCentro() {
        panelCentro = new JPanel();
        nuevoProducto = new Boton(NUEVO_PRODUCTO_BOTON, me);
        panelProductos = new JPanel();

        Etiqueta cabeceraProductosLbl = new Etiqueta("Nombre | Marca | Precio ");
        JTextArea productosView = new JTextArea(10, 22);
        productosView.setText(stringProductosView());

        productosView.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(productosView, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panelProductos.setPreferredSize(new Dimension(300, 170));
        panelProductos.add(scrollPane);

        panelCentro.add(nuevoProducto);
        panelCentro.add(cabeceraProductosLbl);
        panelCentro.add(panelProductos);
        add(panelCentro, BorderLayout.CENTER);
    }

    private String stringProductosView() {
        Administrador admin = new Administrador();
        String[] nombres = admin.getInformacion(1);
        String[] marcas = admin.getInformacion(2);
        String[] precios = admin.getInformacion(3);
        String contenido = "";
        for(int i=0; i<nombres.length; i++) {
            contenido += nombres[i] + " | " + marcas[i] + " | $"+precios[i]+"\n";
        }
        return contenido;
    }

    private void construirSur() {
        panelSur = new JPanel();

        cerrarBtn = new BotonRegresar(me);

        panelSur.add(cerrarBtn);
        add(panelSur, BorderLayout.SOUTH);
    }
}
