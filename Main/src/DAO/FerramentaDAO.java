/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author 202304392651
 */
// LoginDAO.java
import Banco.Conexao;
import Modelo.Ferramenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// FerramentaDAO.java
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FerramentaDAO {

    public void cadastrarFerramenta(Ferramenta ferramenta) {
        try {
            Connection conn = Conexao.getConnection();
            String sql = "INSERT INTO Ferramentas (nome, descricao, quantidade) VALUES (?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, ferramenta.getNome());
            stmt.setString(2, ferramenta.getDescricao());
            stmt.setInt(3, ferramenta.getQuantidade());

            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para verificar se uma ferramenta com o nome já existe
    public boolean ferramentaExiste(String nome) throws SQLException {
        Connection conn = Conexao.getConnection();
        String sql = "SELECT COUNT(*) FROM Ferramentas WHERE nome = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nome);

        ResultSet rs = stmt.executeQuery();
        boolean exists = false;
        
        if (rs.next()) {
            exists = rs.getInt(1) > 0;  // Se o COUNT > 0, o nome já existe
        }

        rs.close();
        stmt.close();
        conn.close();

        return exists;
    }
}