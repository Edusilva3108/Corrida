package SistemaCorrida;

public class RemoverCorrida {

    private SistemaDeCorridas sistema;

    public RemoverCorrida(SistemaDeCorridas sistema) {
        this.sistema = sistema;
    }

    public void removerCorrida(String nome) throws CorridaNaoEncontradaException {
        if (sistema.pesquisarCorridaPorNome(nome) == null) {
            throw new CorridaNaoEncontradaException("Corrida com o nome '" + nome + "' não encontrada.");
        }
        sistema.getCorridas().remove();
        System.out.println("Corrida '" + nome + "' removida com sucesso.");
    }
}

