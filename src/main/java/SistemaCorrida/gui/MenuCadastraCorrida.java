package SistemaCorrida.gui;

import SistemaCorrida.CadastraCorrida;
import SistemaCorrida.CorridaNaoEncontradaException;
import SistemaCorrida.SistemaDeCorridas;
import SistemaCorrida.gui.controllers.CadastrarCorridaController;

import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuCadastraCorrida extends JFrame {
    JLabel linha1, linha2;
    ImageIcon corridaImg = new ImageIcon("./Img/corrida.jpg");
    SistemaDeCorridas sistema = new SistemaDeCorridas();
    JMenuBar barraDeMenu = new JMenuBar();

    public MenuCadastraCorrida() {
        setTitle("Sistema de Cadastro de Corridas");
        setSize(800, 600);
        setLocation(150, 150);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);

        linha1 = new JLabel("Sistema de Cadastro de Corridas", JLabel.CENTER);
        linha1.setForeground(Color.green);
        linha1.setFont(new Font("Serif", Font.BOLD, 24));

        // Ajustando a imagem
        Image img = corridaImg.getImage().getScaledInstance(800, 450, Image.SCALE_SMOOTH);
        corridaImg = new ImageIcon(img);
        linha2 = new JLabel(corridaImg, JLabel.CENTER);

        // Criando um painel para garantir a exibição da imagem
        JPanel painelImagem = new JPanel(new FlowLayout());
        painelImagem.add(linha2);

        setLayout(new BorderLayout());
        add(linha1, BorderLayout.NORTH);
        add(painelImagem, BorderLayout.CENTER); // Adicionando a imagem dentro do painel

        // Criando a barra de menu
        barraDeMenu = new JMenuBar();

        // Criando os menus principais
        JMenu menuCadastrar = new JMenu("Cadastrar");
        JMenu menuPesquisar = new JMenu("Pesquisar");
        JMenu menuRemover = new JMenu("Remover");
        JMenu menuSair = new JMenu("Sair");

        // Criando os itens do menu
        JMenuItem menuCadastrarCorrida = new JMenuItem("Cadastrar Corrida");
        JMenuItem menuPesquisarPorNome = new JMenuItem("Pesquisar por Nome");
        JMenuItem menuPesquisarPorCidade = new JMenuItem("Pesquisar por Cidade");
        JMenuItem menuRemoverCorrida = new JMenuItem("Remover Corrida");

        // Adicionando os itens ao menu "Cadastrar"
        menuCadastrar.add(menuCadastrarCorrida);

        // Adicionando os itens ao menu "Pesquisar"
        menuPesquisar.add(menuPesquisarPorNome);
        menuPesquisar.add(menuPesquisarPorCidade);

        // Adicionando os itens ao menu "Remover"
        menuRemover.add(menuRemoverCorrida);

        // Adicionando os menus à barra de menu
        barraDeMenu.add(menuCadastrar);
        barraDeMenu.add(menuPesquisar);
        barraDeMenu.add(menuRemover);
        barraDeMenu.add(menuSair);

        // Adicionando ações aos botões
        menuCadastrarCorrida.addActionListener(new CadastrarCorridaController(sistema, this));

        // Ação para pesquisar por nome
        menuPesquisarPorNome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = JOptionPane.showInputDialog("Digite o nome da corrida:");
                CadastraCorrida corrida = sistema.pesquisarCorridaPorNome(nome);
                if (corrida != null) {
                    JOptionPane.showMessageDialog(null, "Corrida encontrada: " + corrida.getNome());
                } else {
                    JOptionPane.showMessageDialog(null, "Corrida não encontrada!");
                }
            }
        });

        // Ação para pesquisar por cidade
        menuPesquisarPorCidade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cidade = JOptionPane.showInputDialog("Digite a cidade da corrida:");
                List<CadastraCorrida> corridasEncontradas = sistema.pesquisarCorridaPorCidade(cidade);

                if (!corridasEncontradas.isEmpty()) {
                    StringBuilder resultado = new StringBuilder("Corridas encontradas:\n");
                    for (CadastraCorrida corrida : corridasEncontradas) {
                        resultado.append(corrida.getNome()).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, resultado.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhuma corrida encontrada para a cidade '" + cidade + "'.");
                }
            }
        });


        // Ação para remover uma corrida
        menuRemoverCorrida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = JOptionPane.showInputDialog("Digite o nome da corrida a ser removida:");
                boolean sucesso = sistema.removerCorrida(nome);
                if (sucesso) {
                    JOptionPane.showMessageDialog(null, "Corrida removida com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Corrida não encontrada!");
                }
            }
        });

        // Ação para sair
        menuSair.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

        // Adicionando a barra de menu ao JFrame
        setJMenuBar(barraDeMenu);
    }

    public static void main(String[] args) {
        MenuCadastraCorrida janela = new MenuCadastraCorrida();
        janela.setVisible(true);
    }
}


