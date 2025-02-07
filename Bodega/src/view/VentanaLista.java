package view;
import javax.swing.*;
import model.*;
/**
 * @author Alejandra Carreño P
 */
public class VentanaLista {
    private JButton Ver;
    private JTextArea areaProductos;
    
    public void MostrarL(Bodega x) {
        Ver = new JButton("Ver productos");
        areaProductos = new JTextArea(30, 30);
        JFrame ventanaL = new JFrame("Lista de productos");
        JButton Volver = new JButton("Volver");
        ventanaL.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaL.setSize(600, 400);
        ventanaL.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        
        JButton ONombre = new JButton ("Mostrar productos en orden alfabético");
        JButton OPrecio = new JButton ("Mostrar productos en orden de precio");
        
        ONombre.addActionListener(e -> 
        {
            areaProductos.setText("");
            Bodega productos = x;
            productos.ordenarPorNombre();
            for (var producto : productos.listarProductos()) {
            areaProductos.append(producto.toString() + "\n");
        }
        });
        
        OPrecio.addActionListener((var e) -> 
        {
            areaProductos.setText("");
            Bodega productos = x;
            productos.ordenarPorPrecio();
            productos.listarProductos().forEach(producto -> {
                areaProductos.append(producto.toString() + "\n");
            });
        });
        
        Ver.addActionListener(e -> 
        {
            panel.add(areaProductos);
        });
        
        Volver.addActionListener(e ->
        {
            ventanaL.setVisible(false);
        });
        
        panel.add(ONombre);
        panel.add(OPrecio);
        panel.add(Ver);
        panel.add(Volver);
        ventanaL.add(panel);
        ventanaL.setVisible(true);
    }
}