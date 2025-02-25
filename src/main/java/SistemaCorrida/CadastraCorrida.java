package SistemaCorrida;

import java.util.Objects;

public class CadastraCorrida {
    private String nome;
    private String cidade;
    private String data;
    private String horario;
    private double distancia; // distância em km

    // Construtor padrão
    public CadastraCorrida() {}

    // Construtor com parâmetros
    public CadastraCorrida(String nome, String cidade, String data, String horario, double distancia) {
        this.nome = nome;
        this.cidade = cidade;
        this.data = data;
        this.horario = horario;
        this.distancia = distancia;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                ", Cidade: " + cidade +
                ", Data: " + data +
                ", Horário: " + horario +
                ", Distância: " + distancia + " km";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CadastraCorrida that = (CadastraCorrida) o;
        return Double.compare(distancia, that.distancia) == 0 && Objects.equals(nome, that.nome) && Objects.equals(cidade, that.cidade) && Objects.equals(data, that.data) && Objects.equals(horario, that.horario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cidade, data, horario, distancia);
    }
}
