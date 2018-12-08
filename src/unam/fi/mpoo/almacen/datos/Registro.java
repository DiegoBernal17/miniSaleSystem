package unam.fi.mpoo.almacen.datos;

public abstract class Registro {
	private int indice;
	
	public abstract String convertirATexto();

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

}
