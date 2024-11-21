package View;

import Controller.MovimentacaoController;
import DAO.MovimentacaoDAO; // Importação necessária
import Modelo.Ferramenta;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovimentacaoView extends JFrame {
    private JTextField txtNome;
    private JTextField txtQuantidade;
    private JRadioButton rbAdicionar;
    private JRadioButton rbRemover;
    private JRadioButton rbDeletar;
    private JButton btnConfirmar;
    private MovimentacaoController movimentacaoController;

    public MovimentacaoView() {
        movimentacaoController = new MovimentacaoController();

        setTitle("Movimentação de Estoque");
        setSize(629, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Calcula a posição centralizada
        int centerX = (getWidth() - 150) / 2 + 50; // Largura dos campos (80 + 160 + espaçamento)
        int startY = (getHeight() - 250) / 2; // Centraliza verticalmente, levando em conta a altura total dos componentes

        JLabel lblNome = new JLabel("Nome da Ferramenta:");
        lblNome.setBounds(centerX - 130, startY, 150, 25);  // Centraliza a label
        add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(centerX, startY, 140, 25);  // Centraliza o campo de texto
        add(txtNome);

        JLabel lblQuantidade = new JLabel("Quantidade:");
        lblQuantidade.setBounds(centerX - 100, startY + 40, 150, 25); // Centraliza a label
        add(lblQuantidade);

        txtQuantidade = new JTextField();
        txtQuantidade.setBounds(centerX, startY + 40, 120, 25); // Centraliza o campo de texto
        add(txtQuantidade);

        rbAdicionar = new JRadioButton("Adicionar");
        rbAdicionar.setBounds(centerX - 75, startY + 80, 100, 25); // Centraliza o botão
        rbAdicionar.setSelected(true);
        add(rbAdicionar);

        rbRemover = new JRadioButton("Remover");
        rbRemover.setBounds(centerX + 40, startY + 80, 100, 25); // Ajusta o botão
        add(rbRemover);

        rbDeletar = new JRadioButton("Deletar");
        rbDeletar.setBounds(centerX - 75, startY + 110, 100, 25); // Centraliza o botão
        add(rbDeletar);

        ButtonGroup group = new ButtonGroup();
        group.add(rbAdicionar);
        group.add(rbRemover);
        group.add(rbDeletar);

        btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setBounds(centerX - 50, startY + 150, 100, 25); // Centraliza o botão
        add(btnConfirmar);

        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                int quantidade = 0;

                // Verifica se a opção Deletar está selecionada
                if (rbDeletar.isSelected()) {
                    // Não precisa validar a quantidade para deletar
                } else {
                    // Validação da quantidade: verificar se é número positivo e maior que zero
                    try {
                        quantidade = Integer.parseInt(txtQuantidade.getText());
                        if (quantidade <= 0) {
                            throw new Exception("A quantidade deve ser maior que zero!");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Quantidade inválida!");
                        return; 
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                        return;
                    }
                }

                Ferramenta ferramenta = new Ferramenta(nome, null, 0);

                try {
                    if (rbAdicionar.isSelected()) {
                        movimentacaoController.movimentarEstoque(ferramenta, quantidade, MovimentacaoDAO.ADICIONAR);
                        JOptionPane.showMessageDialog(null, "Quantidade adicionada com sucesso!");
                    } else if (rbRemover.isSelected()) {
                        movimentacaoController.movimentarEstoque(ferramenta, quantidade, MovimentacaoDAO.REMOVER);
                        JOptionPane.showMessageDialog(null, "Quantidade removida com sucesso!");
                    } else if (rbDeletar.isSelected()) {
                        movimentacaoController.movimentarEstoque(ferramenta, 0, MovimentacaoDAO.DELETAR);
                        JOptionPane.showMessageDialog(null, "Ferramenta deletada com sucesso!");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

                limparCampos();
            }
        });
    }

    private void limparCampos() {
        txtNome.setText("");
        txtQuantidade.setText("");
    }
}
