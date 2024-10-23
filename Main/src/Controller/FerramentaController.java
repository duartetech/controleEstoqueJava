package Controller;

import DAO.FerramentaDAO;
import Modelo.Ferramenta;
import View.FerramentaView;
import javax.swing.JOptionPane;
import java.sql.SQLException;

public class FerramentaController {
    private FerramentaView view;
    private FerramentaDAO dao;

    public FerramentaController(FerramentaView view) {
        this.view = view;
        this.dao = new FerramentaDAO();
    }

    public void cadastrarFerramenta(String nome, String descricao, int quantidade) {
        try {
            // Verifica se já existe uma ferramenta com o mesmo nome
            if (dao.ferramentaExiste(nome)) {
                throw new Exception("Ferramenta '" + nome + "' já existe!");
            }

            // Se não existe, continua com o cadastro
            Ferramenta ferramenta = new Ferramenta(nome, descricao, quantidade);
            dao.cadastrarFerramenta(ferramenta);
            JOptionPane.showMessageDialog(null, "Ferramenta cadastrada com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
