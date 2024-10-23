package DAO;

import Banco.Conexao;
import Modelo.Ferramenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class MovimentacaoDAO {

    public static final int ADICIONAR = 1;
    public static final int REMOVER = 2;
    public static final int DELETAR = 3;
    
    // Verificar se uma ferramenta existe no banco de dados pelo nome
    public boolean ferramentaExiste(String nome) throws SQLException {
        Connection conn = Conexao.getConnection();
        String sql = "SELECT COUNT(*) FROM Ferramentas WHERE nome = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nome);
        
        ResultSet rs = stmt.executeQuery();
        rs.next();
        int count = rs.getInt(1);
        
        rs.close();
        stmt.close();
        conn.close();
        
        return count > 0;  // Retorna true se a ferramenta existir, caso contrário false
    }

    public void movimentarEstoque(Ferramenta ferramenta, int quantidade, int acao) {
        try {
            Connection conn = Conexao.getConnection();
            String sql = null;

            switch (acao) {
                case ADICIONAR:
                    sql = "UPDATE Ferramentas SET quantidade = quantidade + ? WHERE nome = ?";
                    break;
                case REMOVER:
                    sql = "UPDATE Ferramentas SET quantidade = quantidade - ? WHERE nome = ?";
                    break;
                case DELETAR:
                    sql = "DELETE FROM Ferramentas WHERE nome = ?";
                    break;
                default:
                    throw new Exception("Ação inválida: " + acao);
            }

            PreparedStatement stmt = conn.prepareStatement(sql);
            if (acao == DELETAR) {
                stmt.setString(1, ferramenta.getNome()); // Para deletar, apenas o nome é necessário
            } else {
                stmt.setInt(1, quantidade); // Para adicionar ou remover, a quantidade é necessária
                stmt.setString(2, ferramenta.getNome()); // Nome da ferramenta
            }

            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}