/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author 202304392651
 */
// EstoqueView.java

import DAO.EstoqueDAO;
import Modelo.Ferramenta;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class EstoqueView extends JFrame {
    public EstoqueView() {
        setTitle("Visualizar Estoque");
        setSize(629, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        EstoqueDAO estoqueDAO = new EstoqueDAO();
        List<Ferramenta> ferramentas = estoqueDAO.visualizarEstoque();

        String[] columnNames = {"Nome", "Descrição", "Quantidade"};
        String[][] data = new String[ferramentas.size()][3];

        for (int i = 0; i < ferramentas.size(); i++) {
            Ferramenta ferramenta = ferramentas.get(i);
            data[i][0] = ferramenta.getNome();
            data[i][1] = ferramenta.getDescricao();
            data[i][2] = String.valueOf(ferramenta.getQuantidade());
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }
}
