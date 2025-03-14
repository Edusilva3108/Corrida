package SistemaCorrida.gui.controllers;

import SistemaCorrida.SistemaDeCorridas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarCorridaController implements ActionListener {

    private SistemaDeCorridas sistema;
    private JFrame frame;

    public CadastrarCorridaController(SistemaDeCorridas sistema, JFrame frame) {
        this.sistema = sistema;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Obtendo dados da corrida via JOptionPane
            String nome = JOptionPane.showInputDialog(frame, "Nome da Corrida:");
            if (nome == null || nome.trim().isEmpty()) return;

            String cidade = JOptionPane.showInputDialog(frame, "Cidade:");
            if (cidade == null || cidade.trim().isEmpty()) return;

            String data = JOptionPane.showInputDialog(frame, "Data (dd/MM/yyyy):");
            if (data == null || data.trim().isEmpty()) return;

            String horario = JOptionPane.showInputDialog(frame, "Horário (HH:mm):");
            if (horario == null || horario.trim().isEmpty()) return;

            String distanciaStr = JOptionPane.showInputDialog(frame, "Distância (km):");
            if (distanciaStr == null || distanciaStr.trim().isEmpty()) return;

            double distancia = Double.parseDouble(distanciaStr);

            // Cadastrando a corrida no sistema
            sistema.cadastrarCorrida(nome, cidade, data, horario, distancia);

            JOptionPane.showMessageDialog(frame, "Corrida cadastrada com sucesso!");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Erro: Distância deve ser um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Erro ao cadastrar corrida: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
