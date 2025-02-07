package view;
import firebase.*;
import javax.swing.*;
import model.*;

/**
 * @author Alejandra Carreño P
 */
public class VentanaEdición {
    private JTextField txtId, txtNombre, txtCategoría, txtCantidad, txtPrecio;
    private JButton btnGuardar;
    public void MostrarE(Bodega x) {
        JLabel lblId = new JLabel("ID:");
        JLabel lblNombre = new JLabel("Nombre:");
        JLabel lblCategoría = new JLabel("Categoría:");
        JLabel lblCantidad = new JLabel("Cantidad:");
        JLabel lblPrecio = new JLabel("Precio:");
        txtId = new JTextField(4);
        txtNombre = new JTextField(8);
        txtCategoría = new JTextField(8);
        txtCantidad = new JTextField(8);
        txtPrecio = new JTextField(8);
        btnGuardar = new JButton("Guardar");
        JButton Volver = new JButton("Volver");
        JButton Modificar = new JButton("Modificar");
        JFrame ventanaE = new JFrame("Edición de productos");
        ventanaE.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaE.setSize(600, 400);
        ventanaE.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        
        btnGuardar.addActionListener(e -> 
        {
            Bodega lista = x;
            guardarProducto(lista);
        });
        
        Volver.addActionListener(e ->
        {
            ventanaE.setVisible(false);
        });
        Modificar.addActionListener(e->
        {
            Bodega lista = x;
            modificarProducto(lista);
        });
        
        panel.add(lblId);
        panel.add(txtId);
        panel.add(lblNombre);
        panel.add(txtNombre);
        panel.add(lblCategoría);
        panel.add(txtCategoría);
        panel.add(lblCantidad);
        panel.add(txtCantidad);
        panel.add(lblPrecio);
        panel.add(txtPrecio);
        panel.add(btnGuardar);
        panel.add(Modificar);
        panel.add(Volver);
        ventanaE.add(panel);
        ventanaE.setVisible(true);
    }
    private void guardarProducto(Bodega h) {
        Bodega bodega = h;
        String id = txtId.getText();
        String nombre = txtNombre.getText();
        String categoría = txtCategoría.getText();
        int cantidad = Integer.parseInt(txtCantidad.getText());
        double precio = Double.parseDouble(txtPrecio.getText());
        Producto producto = new Producto(id, nombre, categoría, cantidad, precio);
        bodega.agregarProducto(producto);
        FirebasePushProducto.PushProducto(producto);
        JOptionPane.showMessageDialog(null, "Producto guardado correctamente.");
    }

    private void modificarProducto(Bodega h) {
        Bodega bodega = h;
        String id = txtId.getText();
        String nombre = txtNombre.getText();
        String categoría = txtCategoría.getText();
        int cantidad = Integer.parseInt(txtCantidad.getText());
        double precio = Double.parseDouble(txtPrecio.getText());
        Producto producto = new Producto(id, nombre, categoría, cantidad, precio);
        bodega.cambiarProducto(producto);
        FirebaseSaveProducto.SaveProducto(producto);
        JOptionPane.showMessageDialog(null, "Producto modificado correctamente.");
    }
}