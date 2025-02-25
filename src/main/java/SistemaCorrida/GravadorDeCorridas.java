package SistemaCorrida;

import java.io.*;
import java.util.*;

public class GravadorDeCorridas {
    private static final String ARQUIVO = "corridas.txt";

    // Método para gravar a lista de corridas no arquivo
    public void gravaCorridas(Collection<CadastraCorrida> corridas) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (CadastraCorrida corrida : corridas) {
                writer.write(corrida.getNome() + "," +
                        corrida.getCidade() + "," +
                        corrida.getData() + "," +
                        corrida.getHorario() + "," +
                        corrida.getDistancia());
                writer.newLine();
            }
        }
    }

    // Método para recuperar as corridas do arquivo
    public Collection<CadastraCorrida> recuperaCorridas() throws IOException {
        List<CadastraCorrida> corridas = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length == 5) {
                    String nome = partes[0];
                    String cidade = partes[1];
                    String data = partes[2];
                    String horario = partes[3];
                    double distancia = Double.parseDouble(partes[4]);

                    CadastraCorrida corrida = new CadastraCorrida(nome, cidade, data, horario, distancia);
                    corridas.add(corrida);
                }
            }
        }
        return corridas;
    }
}

