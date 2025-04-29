package SistemaCorrida;

import java.util.Map;

import java.util.*;
import java.util.stream.Collectors;

public class PesquisarCorrida {
    private Map<String, CadastraCorrida> corridas; // Usando nome como chave

    // Construtor recebe o mapa de corridas cadastradas
    public PesquisarCorrida(Map<String, CadastraCorrida> corridas) {
        this.corridas = corridas;
    }

    // Método para pesquisar por nome
    /*public CadastraCorrida pesquisarPorNome(String nome) {
        CadastraCorrida corrida = corridas.get(nome);
        if (corrida == null) {
            System.out.println("Corrida não encontrada com o nome: " + nome);
        }
        return corrida;
    }*/

    public CadastraCorrida pesquisarPorNome(String nome) {
        return corridas.entrySet().stream()
                .filter(entry -> entry.getKey().equals(nome))
                .findFirst()
                .map(Map.Entry::getValue)
                .orElseGet(() -> {
                    System.out.println("Corrida não encontrada com o nome: " + nome);
                    return null;
                });
    }

    // Método para pesquisar por cidade
    /*public List<CadastraCorrida> pesquisarPorCidade(String cidade) {
        List<CadastraCorrida> corridasEncontradas = new ArrayList<>();
        for (Map.Entry<String, CadastraCorrida> entry : corridas.entrySet()) {
            if (entry.getValue().getCidade().equalsIgnoreCase(cidade)) {
                corridasEncontradas.add(entry.getValue());
            }
        }
        return corridasEncontradas;
    }*/

    public List<CadastraCorrida> pesquisarPorCidade(String cidade) {
        if (cidade == null) {
            throw new IllegalArgumentException("Cidade não pode ser nula");
        }
        return corridas.values().stream()
                .filter(corrida -> cidade.equalsIgnoreCase(corrida.getCidade()))
                .collect(Collectors.toList());
    }
}

