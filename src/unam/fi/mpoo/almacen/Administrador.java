package unam.fi.mpoo.almacen;

import unam.fi.mpoo.almacen.datos.Registro;

import java.io.*;
import java.util.ArrayList;

public class Administrador {

    // definimos y asignamos variables estaticas de los nombres de los archivos a guardar
    public final static String RUTA_CARPETA="./almacen/";
    public final static String NOMBRE_ARCHIVO_PRODUCTOS ="productos.txt";
    public final static String NOMBRE_ARCHIVO_PROVEEDORES ="proveedores.txt";
    public final static String NOMBRE_ARCHIVO_VENTAS ="ventas.txt";
    public final static String NOMBRE_ARCHIVO_COMPRAS ="compras.txt";
    private final static String SEPARADOR_INFORMACION=":";
    File almacen;

    // constructor
    public Administrador() {
        // por defecto se selecciona el almacen 1 que es productos.txt
        seleccionarAlmacen(1);
    }

    // este metodo se selecciona el almacen, es decir selecciona en que archivo se guardarán los datos
    public void seleccionarAlmacen(int almacen) {
        switch (almacen) {
           // almacen 1 de productos
            case 1:
                this.almacen = generarClaseFile(1, NOMBRE_ARCHIVO_PRODUCTOS);
                break;
           // almacen 2 de proveedores
            case 2:
                this.almacen = generarClaseFile(1, NOMBRE_ARCHIVO_PROVEEDORES);
                break;
           // almacen 3 de ventas
            case 3:
                this.almacen = generarClaseFile(1, NOMBRE_ARCHIVO_VENTAS);
                break;
           // almacen 4 de compras
            case 4:
                this.almacen = generarClaseFile(1, NOMBRE_ARCHIVO_COMPRAS);
                break;
        }
    }

    // este metodo guarda la información en el almacen seleccionado
    public void registraInformacion(Registro r) {
        try {
            BufferedWriter bw= new BufferedWriter(new FileWriter(almacen,true));
            bw.write(r.convertirATexto());
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // obtener el ultima registro del almacen
    public int getUltimoIndice() {
        int lineas = 0;
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(almacen));
            while( br.readLine()!=null){
                lineas++;
            }
            br.close();
        } catch (Exception e) {
        }
        return lineas;
    }

    // metodo que crea el archivo si es que no existe del almacen
    public static File generarClaseFile(int opcion, String f){
        String rutaCompleta="";
        switch (opcion) {
            case 1:
                rutaCompleta=RUTA_CARPETA+f;
                break;
        }
        return new File(rutaCompleta);
    }

    // este metodo obtiene la información de una columna del almacen seleccionado
    // NOTA: no ebtiene todo, solo un dato especificado de cada fila
    // por ejemplo si se pasa como parametro el numero 1 y se selecciona el almacen de productos
    // se obtendrá el nombre de todos los prodcutos guardados en forma de arreglo de String
    public String[] getInformacion(int info) {
        String linea;
        ArrayList<String> productos = new ArrayList<>();

        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(almacen));
            while( (linea=br.readLine())!=null){
                String[] separado = linea.split(SEPARADOR_INFORMACION);
                productos.add(separado[info]);
            }
            br.close();
        } catch (Exception e) {}
        String[] stockArr = new String[productos.size()];
        stockArr = productos.toArray(stockArr);
        return stockArr;
    }
}
