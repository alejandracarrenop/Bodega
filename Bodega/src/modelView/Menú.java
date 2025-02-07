package modelView;
import javax.swing.*;
import view.*;
/**
 * @author Alejandra Carreño P
 */
public class Menú {
    public static void main(String[] args) {
        Menú inicio = new Menú();
        inicio.iniciarIngreso();
    }

    public void iniciarIngreso() {
        JFrame LogIn = new JFrame("Log in");
        LogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LogIn.setSize(300, 200);
        LogIn.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        JLabel txtU = new JLabel("Nombre de usuario: ");
        JTextField User = new JTextField(8);
        JLabel txtC = new JLabel("Contraseña:        ");
        JPasswordField Password = new JPasswordField(8);
        JButton Acceder = new JButton("Acceder");
        
        Acceder.addActionListener(e -> 
        {
            String user = User.getText();
            char[] contr = Password.getPassword();
            String cont = new String(contr);
            acceder(user, cont);
        });
        
        panel.add(txtU);
        panel.add(User);
        panel.add(txtC);
        panel.add(Password);
        panel.add(Acceder);
        LogIn.add(panel);
        LogIn.setVisible(true);
}

    private void acceder(String u, String c) {
        boolean cuenta = verificarUser(u, c);
        if(cuenta==true){
            VentanaMenú ventana = new VentanaMenú();
            ventana.MostrarM();
        }
    }

    private boolean verificarUser(String u, String c) {
        if("Admin1".equals(u)){
            if("Bodega2025".equals(c)){
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Usuario no reconocido");
        }
        return false;
    }

}