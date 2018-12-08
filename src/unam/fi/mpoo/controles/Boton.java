package unam.fi.mpoo.controles;

import javax.swing.JButton;

import unam.fi.mpoo.eventos.ManejadorEventos;

public class Boton extends JButton {
	
	public Boton(String texto, ManejadorEventos me){
		super(texto);
		this.addActionListener(me);
	}	
}
