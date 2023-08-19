package Vendas;

import java.util.ArrayList;
import java.util.List;

public class InventarioDeVendaa {
    List<Pedido> listaDeVendas= new ArrayList<>();
    public void adiciona(Pedido pedido){
        listaDeVendas.add(pedido);
    }
    public String organizadorDeRelatorio(Pedido pedido, int numeroDePedido){
        String nome= pedido.getNomeCliente();
        String descricao= pedido.toString();
        double valor= pedido.calculaValorTotalPedido();
        return String.format("%d\t\t%s\t\tPedido: %s\t\t Valor total: R$ %.2f\n",numeroDePedido,nome,descricao,valor);
    }
}


