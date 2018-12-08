package unam.fi.mpoo.controles;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import javax.imageio.ImageIO;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class Imagen extends JPanel{

	Image i;
	 
	public Imagen(File archivo, Dimension d){
		try {
			BufferedImage bi = ImageIO.read(archivo);
			i = (new ImageIcon(bi)).getImage();
			setPreferredSize(d);
			setMinimumSize(d);
			setMaximumSize(d);
			setSize(d);
			setLayout(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(i, 0, 0, null);		
	}
}
