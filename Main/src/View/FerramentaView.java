/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

// FerramentaView.java
import Controller.FerramentaController;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FerramentaView extends JFrame {
    private JTextField txtNome, txtDescricao, txtQuantidade;
    private JButton btnCadastrar, btnVoltar;

    public FerramentaView() {
        setTitle("Cadastrar Ferramenta");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(30, 30, 100, 25);
        add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(140, 30, 200, 25);
        add(txtNome);

        JLabel lblDescricao = new JLabel("Descrição:");
        lblDescricao.setBounds(30, 70, 100, 25);
        add(lblDescricao);

        txtDescricao = new JTextField();
        txtDescricao.setBounds(140, 70, 200, 25);
        add(txtDescricao);

        JLabel lblQuantidade = new JLabel("Quantidade:");
        lblQuantidade.setBounds(30, 110, 100, 25);
        add(lblQuantidade);

        txtQuantidade = new JTextField();
        txtQuantidade.setBounds(140, 110, 200, 25);
        add(txtQuantidade);

        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(140, 160, 100, 25);
        add(btnCadastrar);

        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(250, 160, 100, 25);
        add(btnVoltar);

        // Ação para cadastrar a ferramenta
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                String descricao = txtDescricao.getText();
                int quantidade;
                try {
                    quantidade = Integer.parseInt(txtQuantidade.getText());

                    // Verifica se a quantidade é negativa
                    if (quantidade < 0) {
                        throw new Exception("Quantidade não pode ser negativa!");
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Quantidade inválida!");
                    return;
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    return;
                }

                FerramentaController controller = new FerramentaController(FerramentaView.this);
                try {
                    controller.cadastrarFerramenta(nome, descricao, quantidade);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                limparCampos();
            }
        });

        // Ação para voltar à tela anterior
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BoasVindasView("Administrador");  // Você pode passar o nome do usuário logado
                dispose();
            }
        });

        setVisible(true);
    }

    // Método para limpar os campos após o cadastro
    private void limparCampos() {
        txtNome.setText("");
        txtDescricao.setText("");
        txtQuantidade.setText("");
    }
}
