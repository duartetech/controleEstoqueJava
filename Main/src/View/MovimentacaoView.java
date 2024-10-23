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
        setSize(300, 250); 
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblNome = new JLabel("Nome da Ferramenta:");
        lblNome.setBounds(10, 10, 150, 25);
        add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(150, 10, 120, 25);
        add(txtNome);

        JLabel lblQuantidade = new JLabel("Quantidade:");
        lblQuantidade.setBounds(10, 50, 150, 25);
        add(lblQuantidade);

        txtQuantidade = new JTextField();
        txtQuantidade.setBounds(150, 50, 120, 25);
        add(txtQuantidade);

        rbAdicionar = new JRadioButton("Adicionar");
        rbAdicionar.setBounds(10, 90, 100, 25);
        rbAdicionar.setSelected(true);
        add(rbAdicionar);

        rbRemover = new JRadioButton("Remover");
        rbRemover.setBounds(120, 90, 100, 25);
        add(rbRemover);

        rbDeletar = new JRadioButton("Deletar");
        rbDeletar.setBounds(10, 120, 100, 25);
        add(rbDeletar);

        ButtonGroup group = new ButtonGroup();
        group.add(rbAdicionar);
        group.add(rbRemover);
        group.add(rbDeletar);

        btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setBounds(90, 160, 100, 25);
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
