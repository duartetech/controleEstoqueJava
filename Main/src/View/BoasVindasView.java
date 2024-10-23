/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// BoasVindasView.java
package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoasVindasView extends JFrame {
    public BoasVindasView(String nomeUsuario) {
        setTitle("Boas Vindas");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblBoasVindas = new JLabel("Bem-vindo, " + nomeUsuario + "!");
        lblBoasVindas.setBounds(10, 10, 200, 25);
        add(lblBoasVindas);

        JButton btnCadastrarFerramenta = new JButton("Cadastrar Ferramenta");
        btnCadastrarFerramenta.setBounds(50, 50, 200, 25);
        add(btnCadastrarFerramenta);

        JButton btnMovimentarEstoque = new JButton("Movimentar Estoque");
        btnMovimentarEstoque.setBounds(50, 80, 200, 25);
        add(btnMovimentarEstoque);

        JButton btnVisualizarEstoque = new JButton("Visualizar Estoque");
        btnVisualizarEstoque.setBounds(50, 110, 200, 25);
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
