package View;

import java.awt.*;
import javax.swing.*;
import Controller.LoginController;

public class LoginView extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private LoginController loginController;

    public LoginView() {
        loginController = new LoginController();
       
        setTitle("Login");
        setSize(629,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
       
        JLabel backgroundLabel = new JLabel(new ImageIcon("./src/View/imgs/sl.jpeg"));
        backgroundLabel.setLayout(null);  // Define layout nulo para posicionar os componentes sobre a imagem
        setContentPane(backgroundLabel);
        
        // Ajustes para centralizar os componentes
        int centerX = (getWidth() - 300) / 2; // Largura dos campos (80 + 160 + espaçamento)
        int startY = 100; // Distância do topo

        JLabel lblUsuario = new JLabel("Usuário:");
        lblUsuario.setBounds(centerX, startY, 80, 30); // Ajustei o tamanho para acomodar a fonte maior
        lblUsuario.setFont(new Font("Arial", Font.BOLD, 16));  // Define fonte maior e em negrito
        lblUsuario.setForeground(Color.BLACK);  // Cor do texto da label
        add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(centerX + 90, startY, 160, 25);
        add(txtUsuario);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(centerX, startY + 40, 80, 30); // Ajustei o tamanho para acomodar a fonte maior
        lblSenha.setFont(new Font("Arial", Font.BOLD, 16));  // Define fonte maior e em negrito
        lblSenha.setForeground(Color.BLACK);  // Cor do texto da label
        add(lblSenha);

        txtSenha = new JPasswordField();
        txtSenha.setBounds(centerX + 90, startY + 40, 160, 25);
        add(txtSenha);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(centerX + 90, startY + 80, 80, 25);
        add(btnLogin);

        btnLogin.addActionListener(e -> {
            String usuario = txtUsuario.getText();
            String senha = new String(txtSenha.getPassword());

            if (loginController.autenticar(usuario, senha)) {
                // Se a autenticação for bem-sucedida, abre a janela de boas-vindas
                new BoasVindasView("Administrador").setVisible(true);
                dispose(); // Fecha a janela de login
            } else {
                JOptionPane.showMessageDialog(this, "Usuário ou senha inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
