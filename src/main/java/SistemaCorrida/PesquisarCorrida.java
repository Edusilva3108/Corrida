package SistemaCorrida;

import java.util.Map;

public class PesquisarCorrida {
    private Map<String, CadastraCorrida> corridas; // Usando nome como chave

    // Construtor recebe o mapa de corridas cadastradas
    public PesquisarCorrida(Map<String, CadastraCorrida> corridas) {
        this.corridas = corridas;
    }

    // Método para pesquisar por nome
    public CadastraCorrida pesquisarPorNome(String nome) {
        return corridas.get(nome);
    }

    // Método para pesquisar por cidade
    public void pesquisarPorCidade(String cidade) {
        for (Map.Entry<String, CadastraCorrida> entry : corridas.entrySet()) {
            if (entry.getValue().getCidade().equalsIgnoreCase(cidade)) {
                System.out.println("Corrida encontrada: " + entry.getValue().getNome());
            }
        }
    }
}
