package SistemaCorridaTest;

import SistemaCorrida.CadastraCorrida;
import SistemaCorrida.CorridaException;
import SistemaCorrida.SistemaDeCorridas;

public class SistemaDeCorridasTest {
    public static void main(String[] args) throws CorridaException {
        SistemaDeCorridas sistema = new SistemaDeCorridas();

        // Teste 1: Cadastrar uma corrida com sucesso
        CadastraCorrida corrida = new CadastraCorrida("Corrida da Cidade", "São Paulo", "2025-06-10", "07:00", 5.0);
        sistema.cadastraCorrida(corrida);
        System.out.println("Teste 1: Cadastro de corrida bem-sucedido.");

        // Teste 2: Tentar cadastrar uma corrida inválida (sem nome)
        CadastraCorrida corridaInvalida = new CadastraCorrida(null, "São Paulo", "2025-06-10", "07:00", 5.0);
        sistema.cadastraCorrida(corridaInvalida);
        System.out.println("Teste 2: Cadastro de corrida inválido não detectado.");

        // Teste 3: Pesquisar corrida pelo nome
        CadastraCorrida resultado = sistema.pesquisarCorridaPorNome("Corrida da Cidade");
        if (resultado != null && "Corrida da Cidade".equals(resultado.getNome())) {
            System.out.println("Teste 3: Pesquisa de corrida bem-sucedida.");
        } else {
            System.out.println("Teste 3: Pesquisa de corrida falhou.");
        }

        // Teste 4: Listar corridas
        sistema.cadastraCorrida(new CadastraCorrida("Corrida 2", "Rio de Janeiro", "2025-06-15", "08:00", 10.0));
        int totalCorridas = sistema.listarCorridas().size();
        if (totalCorridas == 2) {
            System.out.println("Teste 4: Listagem de corridas bem-sucedida. Total: " + totalCorridas);
        } else {
            System.out.println("Teste 4: Listagem de corridas falhou. Total: " + totalCorridas);
        }
    }
}

