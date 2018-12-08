package unam.fi.mpoo.eventos;

import unam.fi.mpoo.almacen.Administrador;
import unam.fi.mpoo.almacen.datos.Registro;
import unam.fi.mpoo.almacen.datos.tipos.*;
import unam.fi.mpoo.aplicacion.*;
import unam.fi.mpoo.controles.botones.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class ManejadorEventos implements ActionListener {

    // Definimos aquí el usuario y contraseña de forma estatica
    private static final String username = "admin";
    private static final String password = "1234";
    // Definimos las variables a utilizar
    private Login login;
    private Menu menu;
    private Ventas ventas;
    private Productos productos;
    private Compras compras;
    private Proveedores proveedores;
    private NuevoProducto nuevoProducto;
    private Administrador admin;
    private int indice;

    // Constructor que recibe el login
    public ManejadorEventos(Login login) {
        this.login = login;
        this.admin = new Administrador();
        indice=0;
    }
    // constructor que recibe como parámetro el menu
    public ManejadorEventos(Menu menu) {
        this.menu = menu;
        this.admin = new Administrador();
    }

    // Este método es capturar las acciones del evento (Como click a un boton por ejemplo)
    public void actionPerformed(ActionEvent e) {
        // Definimos algunas de las variables a utilizar
        Registro registro;
        String nombre;
        String precio;
        String producto;
        String cantidad;
        String total;
        // Capturamos el ActionCommand
        switch (e.getActionCommand()) {
            // En caso que sea igual al nombre del boton de ingresar entonces hace lo siguiente
            case Login.INGRESAR_BOTON:
                // Definimos y asigamos variables
                // Lee el usuario y la contraseña
                String user = login.getUsernameTxtField().getText();
                char[] pass = login.getPasswordTxtField().getPassword();

                // Si el usuario NO está vacio y el tamaño de la contraseña es mayor a cero hace lo siguiente
                if(!user.equals("") && pass.length > 0) {
                    // Si el usuario introducido es igual al usuario definido al principio del archivo
                    if(user.equals(username)) {
                        // Si la contraseña introducida es igual a la definida al principio del archivo
                        if (Arrays.equals( password.toCharArray(), pass)) {
                            // Entonces creará un nuevo objeto para llamar así al menu
                            new Menu();
                            // Y cierra la ventana del login
                            login.dispose();
                        } else {
                            // caso contrario manda como mensaje que la contraseña es incorrecta
                            login.setErrorLbl("Contraseña incorrecta");
                        }
                    } else {
                        // caso contrario manda como mensaje que el usuario es incorrecto
                        login.setErrorLbl("Usuario incorrecto");
                    }
                } else {
                    // caso contrario manda como mensaje que hay uno o los dos campos vacios
                    login.setErrorLbl("Dato(s) vacío(s)");
                }
            break;
            // En caso que que el nombre del boton presionado sea igual al de venta de productos
            case Menu.VENTAS_BOTON:
                ventas = new Ventas(this);
                break;
            // En caso que que el nombre del boton presionado sea igual al de almacen de productos
            case Menu.PRODUCTOS_BOTON:
                productos = new Productos(this);
                break;
            // En caso que que el nombre del boton presionado sea igual al de compras a proveedores
            case Menu.COMPRAS_BOTON:
                compras = new Compras(this);
            break;
            // En caso que que el nombre del boton presionado sea igual al de proveedores
            case Menu.PROVEEDORES_BOTON:
                proveedores = new Proveedores(this);
             break;
            // En caso que que el nombre del boton presionado sea igual al de salir
            case Menu.SALIR_BOTON:
                int opcion = JOptionPane.showConfirmDialog(menu, "¿Seguro que quieres salir?", "Confirma salida", JOptionPane.YES_NO_OPTION);
                if(opcion == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            break;
            // En caso que que el nombre del boton presionado sea igual al de nuevo producto
            case Productos.NUEVO_PRODUCTO_BOTON:
                nuevoProducto = new NuevoProducto(this);
            break;
            // En caso para botón realizar venta
            case Ventas.MSG_BOTON:
                // obtener valores
                producto = ventas.getProductosList().getSelectedItem().toString();
                precio = ventas.getPrecioTxtBox().getText();
                cantidad = ventas.getCantidadTxtBox().getText();
                // Checar que la cantiadd sea mayor a 0
                if(Integer.parseInt(cantidad) > 0) {
                    // obtener valores
                    String subtotal = ventas.getSubtotalLbl().getText();
                    String iva = ventas.getIvaLbl().getText();
                    total = ventas.getTotalLbl().getText();
                    admin.seleccionarAlmacen(3);
                    indice = admin.getUltimoIndice();
                    // generar nuevo registro
                    registro = new Venta(indice, producto, precio, cantidad, subtotal, iva, total);
                    System.out.println(registro.convertirATexto());
                    admin.registraInformacion(registro);
                    JOptionPane.showMessageDialog(ventas,"Se ha registrado la nueva venta");
                    ventas.dispose();
                } else {
                    JOptionPane.showMessageDialog(ventas,"Rellena correctamente todos los campos");
                }
            break;
            // En caso para botón realizar compra
            case Compras.MSG_BOTON:
                try {
                    // obtener valores
                    String proveedor = compras.getProveedoresList().getSelectedItem().toString();
                    producto = compras.getProductosList().getSelectedItem().toString();
                    precio = compras.getPrecioTxtBox().getText();
                    cantidad = compras.getCantidadTxtBox().getText();
                    total = compras.getTotalLbl().getText();
                    total = (Double.parseDouble(precio) * Integer.parseInt(cantidad)) + "";
                    // Checar que no estén vacios los datos obtenidos
                    if(!precio.equals("") && !cantidad.equals("") && !cantidad.equals("0") && !total.equals("")) {
                        admin.seleccionarAlmacen(4);
                        indice = admin.getUltimoIndice();
                        // generar nuevo registro
                        registro = new Compra(indice, proveedor, producto, precio, cantidad, total);
                        System.out.println(registro.convertirATexto());
                        admin.registraInformacion(registro);
                        JOptionPane.showMessageDialog(compras, "Se ha registrado la nueva compra");
                        compras.dispose();
                    } else {
                        JOptionPane.showMessageDialog(compras,"Rellena correctamente todos los campos");
                    }
                } catch (NullPointerException ex) {
                    JOptionPane.showMessageDialog(compras,"Rellena correctamente todos los campos");
                }
            break;
            // En caso para botón agregar producto
            case NuevoProducto.MSG_BOTON:
                // obtener valores
                nombre = nuevoProducto.getNombreTxt().getText();
                String marca = nuevoProducto.getMarcaTxt().getText();
                precio = nuevoProducto.getPrecioTxt().getText();
                // Checar que no estén vacios los datos obtenidos
                if(!nombre.equals("") && !marca.equals("") && !precio.equals("")) {
                    admin.seleccionarAlmacen(1);
                    indice = admin.getUltimoIndice();
                    registro = new Producto(indice, nombre, marca, precio);
                    System.out.println(registro.convertirATexto());
                    admin.registraInformacion(registro);
                    JOptionPane.showMessageDialog(nuevoProducto,"Se ha agregado el nuevo producto");
                    productos.dispose();
                    nuevoProducto.dispose();
                    productos = new Productos(this);

                } else {
                    JOptionPane.showMessageDialog(nuevoProducto,"Rellena correctamente todos los campos");
                }
            break;
            // En caso para botón agregar proveedor
            case Proveedores.MSG_BOTON:
                // obtener valores
                nombre = proveedores.getNombreTxt().getText();
                String direccion = proveedores.getDireccionTxt().getText();
                String telefono = proveedores.getTelefonoTxt().getText();
                // Checar que no estén vacios los datos obtenidos
                if(!nombre.equals("") && !direccion.equals("") && !telefono.equals("")) {
                    admin.seleccionarAlmacen(2);
                    indice = admin.getUltimoIndice();
                    // generar nuevo registro
                    registro = new Proveedor(indice, nombre, direccion, telefono);
                    System.out.println(registro.convertirATexto());
                    admin.registraInformacion(registro);
                    JOptionPane.showMessageDialog(proveedores,"Se ha agregado el proveedor");
                    proveedores.dispose();
                } else {
                    JOptionPane.showMessageDialog(proveedores,"Rellena correctamente todos los campos");
                }
            break;
            // En caso para botón regresar
            case BotonRegresar.MENSAJE:
                // esto lo que hace es cerrar todo porque el botón de regresar se encuentra en varias ventanas
                try {
                    if(ventas != null)
                        ventas.dispose();
                    if(productos != null)
                        productos.dispose();
                    if(compras != null)
                        compras.dispose();
                    if(proveedores != null)
                        proveedores.dispose();
                    if(nuevoProducto != null)
                        nuevoProducto.dispose();
                } catch(NullPointerException ex) { }
            break;
            // En caso que el evento sea que un combobox cambia
            case "comboBoxChanged":
                admin.seleccionarAlmacen(1);
                String[] precios = admin.getInformacion(3);
                ventas.setPrecio(precios[ventas.getProductosList().getSelectedIndex()]);
        }
    }
}
