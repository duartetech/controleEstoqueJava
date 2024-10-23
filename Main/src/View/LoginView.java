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
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblUsuario = new JLabel("Usuário:");
        lblUsuario.setBounds(10, 10, 80, 25);
        add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(100, 10, 160, 25);
        add(txtUsuario);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(10, 50, 80, 25);
        add(lblSenha);

        txtSenha = new JPasswordField();
        txtSenha.setBounds(100, 50, 160, 25);
        add(txtSenha);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(100, 100, 80, 25);
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
