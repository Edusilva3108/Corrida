package SistemaCorridaTest;

import SistemaCorrida.CadastraCorrida;
import SistemaCorrida.GravadorDeCorridas;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ProgramaGravacaoTest {
    public static void main(String[] args) {
        CadastraCorrida corrida1 = new CadastraCorrida("Corrida da Cidade", "São Paulo", "2025-06-10", "07:00", 5.0);
        CadastraCorrida corrida2 = new CadastraCorrida("Maratona do Rio", "Rio de Janeiro", "2025-09-20", "06:30", 42.195);

        List<CadastraCorrida> corridas = new LinkedList<>();
        corridas.add(corrida1);
        corridas.add(corrida2);

        GravadorDeCorridas gravadorDeCorridas = new GravadorDeCorridas();

        System.out.println("Recuperando corridas...");
        try {
            Collection<CadastraCorrida> corridasAchadas = gravadorDeCorridas.recuperaCorridas();
            System.out.println("Corridas encontradas:");
            for (CadastraCorrida c : corridasAchadas) {
                System.out.println(c);
            }

            System.out.println("\nGravando novas corridas...");
            gravadorDeCorridas.gravaCorridas(corridas);
            System.out.println("Corridas gravadas com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
