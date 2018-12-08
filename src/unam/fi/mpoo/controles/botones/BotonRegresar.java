package unam.fi.mpoo.controles.botones;

import unam.fi.mpoo.controles.Boton;
import unam.fi.mpoo.eventos.ManejadorEventos;

import java.awt.*;

public class BotonRegresar extends Boton {
    public static final String MENSAJE = "Cerrar";

    public BotonRegresar(ManejadorEventos me) {
        super(MENSAJE, me);
        super.setBackground(Color.RED);
    }
}
