/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// LoginView.java
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
        setSize(600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        //JPanel mainPanel = new JPanel();
        //Color cor = new Color(255,102,102);
        //mainPanel.setLayout(null);
        //mainPanel.setBackground(cor);  // Define o fundo azul
        //setContentPane(mainPanel);
        JLabel backgroundLabel = new JLabel(new ImageIcon("./src/View/imgs/sl.jpeg"));
        backgroundLabel.setLayout(null);  // Define layout nulo para posicionar os componentes sobre a imagem
        setContentPane(backgroundLabel);
        
        // Ajustes para centralizar os componentes
        int centerX = (getWidth() - 300) / 2; // Largura dos campos (80 + 160 + espaçamento)
        int startY = 100; // Distância do topo

        JLabel lblUsuario = new JLabel("Usuário:");
        lblUsuario.setBounds(centerX, startY, 80, 25);
        add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(centerX + 90, startY, 160, 25);
        add(txtUsuario);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(centerX, startY + 40, 80, 25);
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
