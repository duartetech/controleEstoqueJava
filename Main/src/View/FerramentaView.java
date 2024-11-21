package View;

import Controller.FerramentaController;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FerramentaView extends JFrame {
    private JTextField txtNome, txtDescricao, txtQuantidade;
    private JButton btnCadastrar, btnVoltar;

    public FerramentaView() {
        setTitle("Cadastrar Ferramenta");
        setSize(629, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Ajustes para centralizar os componentes
        int centerX = (getWidth() - 200) / 2 + 50; // Largura total dos campos
        int startY = 80; // Distância do topo

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(centerX - 100, startY, 80, 25); // Ajustado para alinhar com os campos de texto
        add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(centerX, startY, 200, 25);
        add(txtNome);

        JLabel lblDescricao = new JLabel("Descrição:");
        lblDescricao.setBounds(centerX - 100, startY + 40, 80, 25);
        add(lblDescricao);

        txtDescricao = new JTextField();
        txtDescricao.setBounds(centerX, startY + 40, 200, 25);
        add(txtDescricao);

        JLabel lblQuantidade = new JLabel("Quantidade:");
        lblQuantidade.setBounds(centerX - 100, startY + 80, 80, 25);
        add(lblQuantidade);

        txtQuantidade = new JTextField();
        txtQuantidade.setBounds(centerX, startY + 80, 200, 25);
        add(txtQuantidade);

        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(centerX - 50, startY + 140, 100, 25); // Centralizado em relação ao campo de texto
        add(btnCadastrar);

        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(centerX + 60, startY + 140, 100, 25); // Colocado ao lado do botão de cadastrar
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
