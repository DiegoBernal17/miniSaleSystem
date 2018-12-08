package unam.fi.mpoo.aplicacion;

import unam.fi.mpoo.controles.Boton;
import unam.fi.mpoo.controles.CajaContrasenia;
import unam.fi.mpoo.controles.CajaTexto;
import unam.fi.mpoo.controles.Etiqueta;
import unam.fi.mpoo.eventos.ManejadorEventos;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    private JPanel panelNorte;
    private JPanel panelCentro;
    private JPanel panelSur;
    private Boton botonIngresar;
    private CajaTexto usernameTxtField;
    private CajaContrasenia passwordTxtField;
    private Etiqueta errorLbl;

    private ManejadorEventos me;

    public static final String INGRESAR_BOTON = "Ingresar";
    public static final String MENSAJE_INICIO = "Ingresa al sistema";

    public final int ANCHO_VENTNA_PRINCIPAL=300;
    public final int ALTO_VENTNA_PRINCIPAL=200;

    public Login() {
        super();
        super.setTitle(INGRESAR_BOTON);
        super.setPreferredSize(new Dimension(ANCHO_VENTNA_PRINCIPAL,ALTO_VENTNA_PRINCIPAL));
        this.setLayout(new BorderLayout());

        me = new ManejadorEventos(this);

        this.construirPanelNorte();
        this.construirPanelCentro();
        this.construirPanelSur();

        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        super.pack();
        super.setLocationRelativeTo(null);
        super.setResizable(false);
        super.setVisible(true);
        super.repaint();
    }

    private void construirPanelNorte() {
        panelNorte = new JPanel();

        Etiqueta textoArriba = new Etiqueta(MENSAJE_INICIO);
        Font auxFont = textoArriba.getFont();
        textoArriba.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 24));

        panelNorte.add(textoArriba);
        this.add(panelNorte, BorderLayout.NORTH);
    }

    private void construirPanelCentro() {
        panelCentro = new JPanel();
        JPanel panelUsername = new JPanel();
        JPanel panelPassword = new JPanel();
        errorLbl = new Etiqueta("");
        errorLbl.setForeground(Color.RED);

        Etiqueta usernameLbl = new Etiqueta("Usuario: ");
        usernameTxtField = new CajaTexto(10);
        Etiqueta passwordLbl = new Etiqueta("Contraseña");
        passwordTxtField =  new CajaContrasenia(10);

        panelUsername.add(usernameLbl);
        panelUsername.add(usernameTxtField);
        panelPassword.add(passwordLbl);
        panelPassword.add(passwordTxtField);
        panelCentro.add(panelUsername);
        panelCentro.add(panelPassword);
        panelCentro.add(errorLbl);

        add(panelCentro, BorderLayout.CENTER);
    }

    private void construirPanelSur() {
        this.panelSur = new JPanel();

        botonIngresar = new Boton(INGRESAR_BOTON, me);

        panelSur.add(botonIngresar);
        this.add(panelSur, BorderLayout.SOUTH);
    }

    public CajaTexto getUsernameTxtField() { return usernameTxtField; }
    public CajaContrasenia getPasswordTxtField() { return passwordTxtField; }
    public Etiqueta getErrorLbl() { return errorLbl; }

    public void setErrorLbl(String text) {
        errorLbl.setText(text);
    }
}
