package Controller;

// MovimentacaoController.java

import DAO.MovimentacaoDAO;
import Modelo.Ferramenta;

public class MovimentacaoController {
    private MovimentacaoDAO movimentacaoDAO;

    public MovimentacaoController() {
        this.movimentacaoDAO = new MovimentacaoDAO();
    }

    public void movimentarEstoque(Ferramenta ferramenta, int quantidade, int acao) throws Exception {
        // Verificar se a ferramenta existe
        if (!movimentacaoDAO.ferramentaExiste(ferramenta.getNome())) {
            throw new Exception("Ferramenta '" + ferramenta.getNome() + "' não existe no banco de dados!");
        }
        
        // Caso exista, realiza a movimentação normalmente
        movimentacaoDAO.movimentarEstoque(ferramenta, quantidade, acao);
    }
}