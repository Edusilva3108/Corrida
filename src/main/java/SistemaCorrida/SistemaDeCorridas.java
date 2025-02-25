package SistemaCorrida;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SistemaDeCorridas {
    private Map<String, CadastraCorrida> corridas;

    public SistemaDeCorridas() {
        this.corridas = new HashMap<>();
    }

    public void cadastrarCorrida(CadastraCorrida corrida) throws CorridaException {
        if (corrida.getNome() == null || corrida.getCidade() == null ||
                corrida.getData() == null || corrida.getHorario() == null) {
            throw new CorridaException("Erro: Todos os campos devem ser preenchidos!");
        }

        corridas.put(corrida.getNome(), corrida);
        System.out.println("Corrida cadastrada com sucesso: " + corrida.getNome());
    }

    public CadastraCorrida pesquisarCorridaPorNome(String nome) {
        return corridas.get(nome);
    }

    public Map<String, CadastraCorrida> listarCorridas() {
        return corridas;
    }

    public static void main(String[] args) {
        SistemaDeCorridas sistema = new SistemaDeCorridas();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Cadastrar Corrida");
            System.out.println("2. Pesquisar Corrida por Nome");
            System.out.println("3. Listar Todas as Corridas");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao;
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número válido.");
                continue;
            }

            switch (opcao) {
                case 1:
                    try {
                        System.out.println("\nCadastrar Corrida:");
                        System.out.print("Nome da Corrida: ");
                        String nome = scanner.nextLine();
                        System.out.print("Cidade: ");
                        String cidade = scanner.nextLine();
                        System.out.print("Data (DD-MM-YYYY): ");
                        String data = scanner.nextLine();
                        System.out.print("Horário (HH:MM): ");
                        String horario = scanner.nextLine();
                        System.out.print("Distância (km): ");
                        double distancia = Double.parseDouble(scanner.nextLine());

                        CadastraCorrida corrida = new CadastraCorrida(nome, cidade, data, horario, distancia);
                        sistema.cadastrarCorrida(corrida);
                    } catch (CorridaException e) {
                        System.out.println(e.getMessage());
                    } catch (NumberFormatException e) {
                        System.out.println("Erro: A distância deve ser um número.");
                    }
                    break;

                case 2:
                    System.out.print("\nDigite o nome da corrida a ser pesquisada: ");
                    String nomePesquisa = scanner.nextLine();
                    CadastraCorrida corridaEncontrada = sistema.pesquisarCorridaPorNome(nomePesquisa);
                    if (corridaEncontrada != null) {
                        System.out.println("Corrida encontrada: " + corridaEncontrada);
                    } else {
                        System.out.println("Corrida não encontrada.");
                    }
                    break;

                case 3:
                    System.out.println("\nLista de Corridas Cadastradas:");
                    for (CadastraCorrida c : sistema.listarCorridas().values()) {
                        System.out.println(c);
                    }
                    break;

                case 4:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida! Escolha entre 1 e 4.");
            }
        }
    }

    public void cadastraCorrida(CadastraCorrida corrida) {
    }
}

