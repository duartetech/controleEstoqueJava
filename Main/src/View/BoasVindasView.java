/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// BoasVindasView.java
package View;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoasVindasView extends JFrame {
    public BoasVindasView(String nomeUsuario) {
        setTitle("Boas Vindas");
        setSize(629, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        // Ajustes para centralizar os componentes
        int centerX = (getWidth() - 150) / 2; // Largura dos campos (80 + 160 + espaçamento)
        int startY = 100; // Distância do topo
        JLabel backgroundLabel = new JLabel(new ImageIcon("./src/View/imgs/sloganredu.jpeg"));
        backgroundLabel.setLayout(null);  // Define layout nulo para posicionar os componentes sobre a imagem
        setContentPane(backgroundLabel);
        

        JLabel lblBoasVindas = new JLabel("Bem-vindo, " + nomeUsuario + "!");
        lblBoasVindas.setBounds(10, 10, 200, 25);
        add(lblBoasVindas);

        JButton btnCadastrarFerramenta = new JButton("Cadastrar");
        btnCadastrarFerramenta.setBounds(centerX, startY + 5, 125, 30);
        add(btnCadastrarFerramenta);

        JButton btnMovimentarEstoque = new JButton("Movimentar");
        btnMovimentarEstoque.setBounds(centerX, startY + 45, 125, 30);
        add(btnMovimentarEstoque);

        JButton btnVisualizarEstoque = new JButton("Visualizar");
        btnVisualizarEstoque.setBounds(centerX, startY + 85, 125, 30);
        add(btnVisualizarEstoque);

        btnCadastrarFerramenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FerramentaView().setVisible(true);
            }
        });

        btnMovimentarEstoque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MovimentacaoView().setVisible(true);
            }
        });

        btnVisualizarEstoque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EstoqueView().setVisible(true);
            }
        });
    }
}
