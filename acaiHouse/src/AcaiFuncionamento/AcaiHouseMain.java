package AcaiFuncionamento;

import AcaiHouse.Produto;
import Excecoes.RegiaoInvalidaExeption;
import Pessoa.Cliente;
import Vendas.Pedido;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AcaiHouseMain {
    public static void main(String[] args) throws Exception {
        Scanner leitor= new Scanner(System.in);
        HouseAcai gerencia = new HouseAcai();
        final String senha= "111"; //SENHA PARA LOGAR COMO FUNCIONARIO É: 111
        int opcao = 0;
        String senhaDeAcesso;


        //METODO PARA SALVAR EM ARQUIVO

        String nomeArquivo = "relatorio_vendas.txt";

        try {
            File arquivo = new File(nomeArquivo);

            if (arquivo.createNewFile()) {
                System.out.println("Arquivo criado: " + nomeArquivo);
            } else {
                System.out.println("O arquivo já existe: " + nomeArquivo);
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao criar o arquivo: " + e.getMessage());
        }


        while(opcao>=0) {
            System.out.println("---------------Bem vindo ao AçaiHouse--------------------");
            try {
                System.out.println("Digite:\n1. Funcionario\n2. Cliente");
                opcao = leitor.nextInt();
                leitor.nextLine();
                if (opcao <= 0 || opcao >= 3)
                    throw new Exception("OPCAO INVÁLIDA");
            } catch (InputMismatchException exception) {
                System.out.println("CARACTER INVÁLIDO");
                opcao = 3; // Para sair
                return;
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
                return;
            }
            switch (opcao) {
                case 1:
                    do {
                        System.out.println("Digite sua senha");
                        senhaDeAcesso = leitor.nextLine();
                        if (senhaDeAcesso.equals(senha)) {
                            try {
                                System.out.println("Menu do funionário:\n1.Ver lista de pedido\n2.Editar estado do pedido\n3.Emitir relatório geral\n4.Sair..");
                                opcao = leitor.nextInt();
                                leitor.nextLine();
                                if(opcao<=0 || opcao>5)
                                    throw new Exception("OPCAO IVALIDA");
                            }catch(InputMismatchException exception){
                                System.out.println("CARACTER INVALIDO");
                                return;
                            }catch(Exception exception){
                                System.out.println(exception.getMessage());
                                return;
                            }
                            switch (opcao) {
                                case 1:
                                    // Ver todos os pedidos
                                    System.out.println(gerencia.relatoriodePedidos());
                                    break;
                                case 2:
                                    //Adiciona venda mundando da lista de pedidos para a lista de Vendas
                                    System.out.println(gerencia.relatoriodePedidos());
                                    System.out.println("Qual pedido finalizar a venda? ");
                                    int numeroDoPedido = leitor.nextInt();
                                    leitor.nextLine();
                                    try {
                                        gerencia.adicionaVenda(numeroDoPedido);
                                    }catch(NullPointerException exception){
                                        System.out.println("NENHUM PEDIDO REALIZADO: "+exception.getMessage());
                                        return;
                                    }
                                    break;
                                case 3:
                                    // gera um relatorio de vendas
                                    try {
                                        gerencia.salvarRelatorioDeVendas(nomeArquivo);
                                    }catch(NullPointerException exeption){
                                        System.out.println("NENHUMA VENDA REGISTRADA "+exeption.getMessage());
                                        return;
                                    }
                                    break;
                                case 4:
                                    break;
                            }
                        } else {
                            System.out.println("SENHA INVÁLIDA");
                        }
                    } while (!senhaDeAcesso.equals(senha));
                    break;
                case 2:
                    Cliente cliente= null;
                    try {
                         cliente = gerencia.criaCliente();//cliente para ser usado
                    }catch(RegiaoInvalidaExeption exeption){
                        System.out.println(exeption.getMessage());
                        return;
                    }
                    Pedido pedidoFinalCliente;
                    List<Produto> produtosDoPedidoDoCliente = new ArrayList<>();//lista para os produtos do cliente
                    Produto produtoCliente;
                    try {
                        System.out.println("Escolha seu pedido:\nDigite:\n1.Para Açaí\n2.Salgados\n3.Para finalizar pedido.");
                        opcao = leitor.nextInt();
                        leitor.nextLine();
                        if (opcao <= 0 || opcao >= 4)
                            throw new Exception("OPCAO INVÁLIDA");
                    } catch (InputMismatchException exception) {
                        System.out.println("CARACTER INVÁLIDO");
                        opcao = 3; // Para sair
                    } catch (Exception exception) {
                        System.out.println(exception.getMessage());
                    }
                    while (opcao != 3) {
                        // Cria os produtos e adiciona no pedido do cliente
                        produtoCliente = gerencia.criaProduto(opcao);
                        produtosDoPedidoDoCliente.add(produtoCliente);

                        try {
                            System.out.println("Escolha seu pedido:\nDigite:\n1.Para Açaí\n2.Salgados\n3.Para finalizar pedido.");
                            opcao = leitor.nextInt();
                            leitor.nextLine();
                            if (opcao <= 0 || opcao >= 4)
                                throw new Exception("OPCAO INVÁLIDA");
                        } catch (InputMismatchException exception) {
                            System.out.println("CARACTER INVÁLIDO");
                            opcao = 3; // Para sair
                        } catch (Exception exception) {
                            System.out.println(exception.getMessage());
                        }
                    }
                    pedidoFinalCliente = gerencia.criaPedido(cliente);//cria o pedid
                    for (Produto produtosDoPedido : produtosDoPedidoDoCliente) {
                        pedidoFinalCliente.adicionaProduto(produtosDoPedido);//adiciona os produtos da lista no pedido do cliente
                    }
                    try {
                        gerencia.adicionaPedidoALoja(pedidoFinalCliente);
                        System.out.printf("----------PEDIDO FINALIZADO-------------\nValor total do pedido R$ %.2f\n", pedidoFinalCliente.calculaValorTotalPedido());
                        //Valor final do pedido
                    } catch (NullPointerException exception) {
                        System.out.println("PEDIDO INVÁLIDO OU CANCELADO");
                    }
                    break;
            }
        }
        System.out.println("\n---------------FIM----------------");
        leitor.close();
    }

}
