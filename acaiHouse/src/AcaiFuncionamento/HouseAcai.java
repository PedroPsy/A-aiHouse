package AcaiFuncionamento;

import AcaiHouse.Acai;
import AcaiHouse.Produto;
import AcaiHouse.Salgadinho;
import Excecoes.AdicionalInvalidoException;
import Excecoes.RegiaoInvalidaExeption;
import Excecoes.SalgadoOpcaoInvalidaException;
import Excecoes.TamanhoNaoExisteExcepition;
import Pessoa.Cliente;
import Vendas.GerenteDePedidos;
import Vendas.Pedido;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HouseAcai {
    GerenteDePedidos gerencia= new GerenteDePedidos();
    public String relatoriodePedidos() {
        return gerencia.gerarRelatoriosDePedidos().toString();
    }
    public void adicionaVenda(int numeroDoPedido){
        gerencia.adicionaVenda(numeroDoPedido);
    }

    public void salvarRelatorioDeVendas(String nomeArquivo) {
        try {
            FileWriter fileWriter = new FileWriter(nomeArquivo);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String relatorioVendas = gerencia.geraRelatoriodeVendas().toString();
            bufferedWriter.write(relatorioVendas);

            bufferedWriter.close();
            System.out.println("Relatório: \n"+relatorioVendas);

            System.out.println("Relatório de vendas salvo com sucesso no arquivo: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao salvar o relatório de vendas: " + e.getMessage());
        }
    }
    public Cliente criaCliente() throws RegiaoInvalidaExeption {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Seja bem-vindo ao Açaí House.");
        System.out.println("Primeiramente digite seu nome e seu endereço.");
        System.out.println("Nome: ");
        String nome = leitor.nextLine();
        System.out.println("Enderço: (RIO TINTO/ MAMANGUAPE/ VILA");
        String endereco = leitor.nextLine().toUpperCase();
        Cliente cliente = new Cliente(nome, endereco);
        return cliente;
    }
    public Produto criaProduto(int opcao) throws TamanhoNaoExisteExcepition, AdicionalInvalidoException, SalgadoOpcaoInvalidaException {
        Produto produto=null;
        Scanner leitor = new Scanner(System.in);
        switch (opcao){
            case 1:
                System.out.println("'P' para pequeno\n'G' para grande");
                int adicional = 0;
                char tamanho = leitor.nextLine().toUpperCase().charAt(0);
                try {
                    System.out.println("Escolha os adicionais\nDigite:\n1.Leite condensado\n2.Leite em pó\n3.Amendoin\n4.Morango\n5.kiwi\n6.Nenhum\n7.Sair");
                    adicional = leitor.nextInt();
                    leitor.nextLine();
                }catch (IndexOutOfBoundsException exception){
                    System.out.println("CARACTER INVALIDO");
                }
                try {
                    produto = new Acai(tamanho, adicional);
                }catch(TamanhoNaoExisteExcepition excepition){
                    System.out.println(excepition.getMessage());
                }catch (AdicionalInvalidoException exception){
                    System.out.println(exception.getMessage());
                }
                break;
            case 2:
                System.out.println("Escolha o salgado da sua preferência.\nDigite:\n1.Coxinha\n2.Pastel\n3.Empada\n4.Sair");
                int salgado = 0;
                try {
                    salgado = leitor.nextInt();
                    leitor.nextLine();
                }catch(InputMismatchException exception){
                    System.out.println("CARACTER INVALIDO");
                }
                try {
                    produto = new Salgadinho(salgado);
                }catch (SalgadoOpcaoInvalidaException exception){
                    System.out.println(exception.getMessage());
                }
                break;
        }
        return produto;
    }
    public Pedido criaPedido(Cliente cliente) throws RegiaoInvalidaExeption {
        Pedido pedido= new Pedido(cliente);
        return pedido;
    }
    public void adicionaPedidoALoja(Pedido pedido){
        gerencia.adicionaPedidoALoja(pedido);
    }

}
