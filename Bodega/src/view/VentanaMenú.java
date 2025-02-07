package view;
import javax.swing.*;
import modelView.*;
import model.*;
/**
 * @author Alejandra Carreño P
 */
public class VentanaMenú {
    JButton IoM;
    JButton Listar;
    public void MostrarM(){
        IoM = new JButton("Ingresar o Modificar Producto");
        Listar = new JButton("Listar Productos en Bodega");
        Bodega lista = new Bodega();
        JButton CS = new JButton("Cerrar Sesión");
        JFrame ventanaM = new JFrame("Menú principal");
        ventanaM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaM.setSize(600, 400);
        ventanaM.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        
        IoM.addActionListener(e -> 
        {
            Bodega Bd = lista;
            
            abrirVentanaEdicion(Bd);
        });
        
        Listar.addActionListener(e -> 
        {
            Bodega B1 = lista;
            abrirVentanaLista(B1);
        });
        
        CS.addActionListener(e ->
        {
            ventanaM.setVisible(false);
            Menú ventana = new Menú();
            ventana.iniciarIngreso();
        });
        
        panel.add(IoM);
        panel.add(Listar);
        panel.add(CS);
        ventanaM.add(panel);
        ventanaM.setVisible(true);
    }

    private void abrirVentanaEdicion(Bodega x) {
        VentanaEdición ventana = new VentanaEdición();
        ventana.MostrarE(x);
    }

    private void abrirVentanaLista(Bodega x) {
        VentanaLista ventana = new VentanaLista();
        ventana.MostrarL(x);
    }
}
