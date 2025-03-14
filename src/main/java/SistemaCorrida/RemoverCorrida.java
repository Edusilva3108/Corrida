package SistemaCorrida;

public class RemoverCorrida {

    private SistemaDeCorridas sistema;

    public RemoverCorrida(SistemaDeCorridas sistema) {
        this.sistema = sistema;
    }

    public void removerCorrida(String nome) throws CorridaNaoEncontradaException {
        CadastraCorrida corrida = sistema.pesquisarCorridaPorNome(nome); // Busca a corrida pelo nome
        if (corrida == null) {
            throw new CorridaNaoEncontradaException("Corrida com o nome '" + nome + "' não encontrada.");
        }
        sistema.removerCorrida(nome); // Remove a corrida da lista pelo nome
        System.out.println("Corrida '" + nome + "' removida com sucesso.");
    }
}



