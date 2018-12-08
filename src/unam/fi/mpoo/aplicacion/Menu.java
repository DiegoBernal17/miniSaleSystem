package unam.fi.mpoo.aplicacion;

import unam.fi.mpoo.controles.Boton;
import unam.fi.mpoo.controles.Etiqueta;
import unam.fi.mpoo.eventos.ManejadorEventos;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {

    private JPanel panelMenu;
    private Boton ventasBtn;
    private Boton comprasBtn;
    private Boton productosBtn;
    private Boton proveedoresBtn;
    private Boton salirBtn;

    public static final String TITULO_VENTANA = "Menú";
    public static final String MSG_BIENVENIDA = "Bienvenido";
    public static final String VENTAS_BOTON = "Venta de productos";
    public static final String PRODUCTOS_BOTON = "Almacen de productos";
    public static final String COMPRAS_BOTON = "Compras a proveedores";
    public static final String PROVEEDORES_BOTON = "Proveedores";
    public static final String SALIR_BOTON = "Salir";

    private ManejadorEventos me;

    public final int ANCHO_VENTANA_PRINCIPAL=300;
    public final int ALTO_VENTANA_PRINCIPAL=300;

    public Menu() {
        super();
        super.setTitle(TITULO_VENTANA);
        super.setPreferredSize(new Dimension(ANCHO_VENTANA_PRINCIPAL,ALTO_VENTANA_PRINCIPAL));
        this.setLayout(new BorderLayout());

        me = new ManejadorEventos(this);

        construirCabecera();
        construirMenu();

        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        super.pack();
        super.setLocationRelativeTo(null);
        super.setResizable(false);
        super.setVisible(true);
        super.repaint();
    }

    private void construirCabecera() {
        Etiqueta bienvenida = new Etiqueta(MSG_BIENVENIDA);
        Font auxFont = bienvenida.getFont();
        bienvenida.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 24));
        add(bienvenida, BorderLayout.NORTH);
    }

    private void construirMenu() {
        panelMenu = new JPanel();
        panelMenu.setLayout(new GridLayout(0,1,1,10));

        ventasBtn = new Boton(VENTAS_BOTON, me);
        ventasBtn.setBackground(Color.WHITE);
        comprasBtn = new Boton(COMPRAS_BOTON, me);
        comprasBtn.setBackground(Color.WHITE);
        productosBtn = new Boton(PRODUCTOS_BOTON, me);
        productosBtn.setBackground(Color.WHITE);
        proveedoresBtn = new Boton(PROVEEDORES_BOTON, me);
        proveedoresBtn.setBackground(Color.WHITE);
        salirBtn = new Boton(SALIR_BOTON, me);
        salirBtn.setBackground(Color.GRAY);

        panelMenu.add(ventasBtn);
        panelMenu.add(productosBtn);
        panelMenu.add(comprasBtn);
        panelMenu.add(proveedoresBtn);
        panelMenu.add(salirBtn);
        add(panelMenu, BorderLayout.CENTER);
    }
}
