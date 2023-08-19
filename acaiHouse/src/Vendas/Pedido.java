package Vendas;

import AcaiHouse.Produto;
import Excecoes.RegiaoInvalidaExeption;
import Pessoa.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pedido {
    private List<Produto> pedidosClientList= new ArrayList<>();
    private Produto produto;
    private String nomeCliente;
    private double precoFrete;


    public Pedido(Cliente cliente) throws RegiaoInvalidaExeption {
        this.nomeCliente= cliente.getNome();
        this.precoFrete= cliente.valorFrete();
    }
    public void adicionaProduto(Produto produtoPedido){
        pedidosClientList.add(produtoPedido);
        this.produto=produtoPedido;
    }
    public void removeProduto (Produto produtoPedido){
        pedidosClientList.remove(produtoPedido);
    }
    public String toString(){
        List<String> descricaoDoPedido= new ArrayList<>();
        for(Produto produto: pedidosClientList){
            descricaoDoPedido.add(produto.getDescricao());
        }
        return descricaoDoPedido.toString();
    }

    public Produto getProduto() {
        return produto;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }
    public double calculaValorTotalPedido(){
        double valorTotalPedido=0.0;
        for(Produto produtoCalculaValorPedido: pedidosClientList){
            valorTotalPedido += produtoCalculaValorPedido.calculaPreco()+precoFrete;
        }
        return valorTotalPedido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pedido pedido)) return false;
        return Objects.equals(pedidosClientList, pedido.pedidosClientList) && Objects.equals(getProduto(), pedido.getProduto()) && Objects.equals(getNomeCliente(), pedido.getNomeCliente());
    }

    @Override
    public int hashCode() {
        return Objects.hash(pedidosClientList, getProduto(), getNomeCliente());
    }
}
