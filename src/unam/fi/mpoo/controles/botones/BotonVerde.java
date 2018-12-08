package unam.fi.mpoo.controles.botones;

import unam.fi.mpoo.controles.Boton;
import unam.fi.mpoo.eventos.ManejadorEventos;

import java.awt.*;

public class BotonVerde extends Boton {

    public BotonVerde(String mensaje, ManejadorEventos me) {
        super(mensaje, me);
        super.setBackground(Color.GREEN);
    }
}
