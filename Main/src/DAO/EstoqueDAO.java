/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author 202304392651
 */
// EstoqueDAO.java

import Banco.Conexao;
import Modelo.Ferramenta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstoqueDAO {
    public List<Ferramenta> visualizarEstoque() {
        List<Ferramenta> ferramentas = new ArrayList<>();
        try {
            Connection conn = Conexao.getConnection();
            String sql = "SELECT * FROM Ferramentas";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                int quantidade = rs.getInt("quantidade");
                ferramentas.add(new Ferramenta(nome, descricao, quantidade));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ferramentas;
    }
}
