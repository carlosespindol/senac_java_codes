package model;

import java.util.Scanner;
import view.AlterarLeao;
import view.CadastrarGolfinho;
import view.CadastrarLeao;
import view.DeletaLeao;
import view.SelectLeao;
import view.DeletaGolfinho;
import view.SelectGolfinho;
import view.AlterarGolfinho;

import javax.swing.*;
import java.awt.*;

public class Pesquisa extends JFrame {
    JButton alterarGolfinhoMenu = new JButton("Alterar Golfinho");
    JButton alterarLeaoMenu = new JButton("Alterar Leão");
    JButton cadastrarAlimentoMenu = new JButton("Cadastrar Alimento");
    JButton cadastrarGolfinhoMenu = new JButton("Cadastrar Golfinho");
    JButton cadastrarLeaoMenu = new JButton("Cadastrar Leão");
    JButton cadastrarTreinamentoMenu = new JButton("Cadastrar Treinamento");
    JButton deletarGolfinhoMenu = new JButton("Deletar Golfinho");
    JButton deletarLeaoMenu = new JButton("Deletar Leão");
    JButton selecionarGolfinhoMenu = new JButton("Selecionar Golfinho");
    JButton selecionarLeaoMenu = new JButton("Selecionar Leão");
    JButton sair = new JButton("Alterar Golfinho");

    public Pesquisa() {
        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(alterarGolfinhoMenu);
        pane.add(alterarLeaoMenu);
        pane.add(cadastrarAlimentoMenu);
        pane.add(cadastrarGolfinhoMenu);
        pane.add(cadastrarLeaoMenu);
        pane.add(cadastrarTreinamentoMenu);
        pane.add(deletarGolfinhoMenu);
        pane.add(deletarLeaoMenu);
        pane.add(selecionarGolfinhoMenu);
        pane.add(selecionarLeaoMenu);
        pane.add(sair);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(250, 400);
        this.setResizable(false);
        this.setVisible(true);

        deletarLeaoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                new DeletaLeao();
            }
        });

        deletarGolfinhoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                new DeletaGolfinho();
            }
        });

        selecionarGolfinhoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                new SelectGolfinho();
            }
        });

        selecionarLeaoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                new SelectLeao();
            }
        });

        cadastrarLeaoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                new CadastrarLeao();
            }
        });

        cadastrarGolfinhoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                new CadastrarGolfinho();
            }
        });

        alterarLeaoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                new AlterarLeao();
            }
        });

        alterarGolfinhoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                new AlterarGolfinho();
            }
        });

    }

    public static void main(String[] args) {

        try {
            Scanner scan1 = new Scanner(System.in);
            int id = 0;
            String nome = "";
            int treinamento = 0;
            int idJaula = 0;
            String descricao = "";
            int escolha;
            int alimentacao = 0;
            int visitantes = 0;
            Golfinho golfinho = new Golfinho(id, nome, treinamento, idJaula, descricao);

            do {
                System.out.println("+--------------------------------+");
                System.out.println("|        CENTRO DE COMANDO       |");
                System.out.println("+--------------------------------+");
                System.out.println("| [1] ->     INSERT Leão         |");
                System.out.println("| [2] ->     UPDATE Leão         |");
                System.out.println("| [3] ->     DELETE Leão         |");
                System.out.println("| [4] ->     SELECT Leão         |");
                System.out.println("| [5] ->   INSERT Golfinho       |");
                System.out.println("| [6] ->   UPDATE Golfinho       |");
                System.out.println("| [7] ->   DELETE Golfinho       |");
                System.out.println("| [8] ->   SELECT Golfinho       |");
                System.out.println("| [9] ->        SAIR             |");
                System.out.println("+--------------------------------+");
                System.out.println(" Escolha uma opção: ");
                escolha = scan1.nextInt();

                switch (escolha) {

                    case 1:
                        System.out.println("+---------------------+");
                        System.out.println("|  CADASTRAR DE LEÃO  |");
                        System.out.println("+---------------------+");
                        System.out.println("--------------------");
                        System.out.println("       NOME:       ");
                        try {
                            nome = scan1.next();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println("--------------------");
                        System.out.println("   ALIMENTAÇÃO:     ");
                        try {
                            alimentacao = scan1.nextInt();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println("--------------------");
                        System.out.println("    VISITANTES :    ");
                        try {
                            visitantes = scan1.nextInt();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println("--------------------");
                        System.out.println(" DESCRIÇÃO DA JAULA: ");
                        try {
                            descricao = scan1.next();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        try {
                            Jaula jaula = new Jaula(idJaula, descricao);
                            Leao leao = new Leao(id, nome, alimentacao, visitantes, idJaula, descricao);
                            CadastrarLeao.InsertLeao(leao, jaula);

                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 2:
                        System.out.println("+---------------------+");
                        System.out.println("|  UPDATE DE LEÃO     |");
                        System.out.println("+---------------------+");
                        System.out.println("ID: ");
                        try {
                            id = scan1.nextInt();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println("--------------------");
                        System.out.println("       NOME:       ");
                        try {
                            nome = scan1.next();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println("--------------------");
                        System.out.println("   ALIMENTAÇÃO:     ");
                        try {
                            alimentacao = scan1.nextInt();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println("--------------------");
                        System.out.println("    VISITANTES :    ");
                        try {
                            visitantes = scan1.nextInt();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        try {
                            Jaula jaula = new Jaula(idJaula, descricao);
                            Leao leao = new Leao(id, nome, alimentacao, visitantes, idJaula, descricao);
                            AlterarLeao.UpdateLeao(leao, jaula);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 3:
                        System.out.println("+----------------+");
                        System.out.println("|  DELETE LEÃO   |");
                        System.out.println("+----------------+");
                        System.out.println("ID: ");
                        try {
                            id = scan1.nextInt();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        try {
                            Jaula jaula = new Jaula(idJaula, descricao);
                            Leao leao = new Leao(id, nome, alimentacao, visitantes, idJaula, descricao);
                            DeletaLeao.deletaLeao(leao, jaula);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 4:
                        System.out.println("+-------------------+");
                        System.out.println("|    SELECT LEÃO    |");
                        System.out.println("+-------------------+");
                        try {
                            Jaula jaula = new Jaula(idJaula, descricao);
                            Leao leao = new Leao(id, nome, alimentacao, visitantes, idJaula, descricao);
                            SelectLeao.selectLeao(leao, jaula);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 5:
                        System.out.println("+---------------------+");
                        System.out.println("|  CADASTRAR GOLFINHO |");
                        System.out.println("+---------------------+");
                        System.out.println("--------------------");
                        System.out.println("       NOME:       ");
                        try {
                            nome = scan1.next();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println("--------------------");
                        System.out.println("   TREINAMENTO:     ");
                        try {
                            treinamento = scan1.nextInt();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println("--------------------");
                        System.out.println(" DESCRIÇÃO DA JAULA: ");
                        try {
                            descricao = scan1.next();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        try {
                            Jaula jaula = new Jaula(idJaula, descricao);
                            golfinho = new Golfinho(id, nome, treinamento, idJaula, descricao);
                            CadastrarGolfinho.InsertGolfinho(golfinho, jaula);

                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 6:
                        System.out.println("+---------------------+");
                        System.out.println("|  UPDATE DE GOLFINHO |");
                        System.out.println("+---------------------+");
                        System.out.println("ID: ");
                        try {
                            id = scan1.nextInt();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println("--------------------");
                        System.out.println("       NOME:       ");
                        try {
                            nome = scan1.next();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println("--------------------");
                        System.out.println("   TREINAMENTO:     ");
                        try {
                            treinamento = scan1.nextInt();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        try {
                            Jaula jaula = new Jaula(idJaula, descricao);
                            golfinho = new Golfinho(id, nome, treinamento, idJaula, descricao);
                            AlterarGolfinho.UpdateGolfinho(golfinho, jaula);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 7:
                        System.out.println("+----------------+");
                        System.out.println("| DELETE GOLFINHO");
                        System.out.println("+----------------+");
                        System.out.println("ID: ");
                        try {
                            id = scan1.nextInt();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        try {
                            Jaula jaula = new Jaula(idJaula, descricao);
                            golfinho = new Golfinho(id, nome, treinamento, idJaula, descricao);
                            DeletaGolfinho.deletaGolfinho(golfinho, jaula);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 8:
                        System.out.println("+-------------------+");
                        System.out.println("|  SELECT GOLFINHO  |");
                        System.out.println("+-------------------+");
                        try {
                            Jaula jaula = new Jaula(idJaula, descricao);
                            golfinho = new Golfinho(id, nome, treinamento, idJaula, descricao);
                            SelectGolfinho.selectGolfinho(golfinho, jaula);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                }

            } while (escolha != 9);
            scan1.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
