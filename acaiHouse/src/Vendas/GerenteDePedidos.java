package Vendas;

import java.util.ArrayList;
import java.util.List;

public class GerenteDePedidos {
    private List<Pedido> listaDePedidos = new ArrayList<>();
    private InventarioDeVendaa inventarioDeVendaa = new InventarioDeVendaa();
    /*
    O gerente tem a lista de pedidos, Onde ficam todos os pedido feitos pelos clientes

    Após finalizado o gerente adiciona a venda no inventario de vendas, apos o pedido ter sido finalizado
     */
    public void adicionaVenda(int numeroDoPedido){
        Pedido pedidoFinalizado= getPedido(numeroDoPedido);
        removePedidoDaLoja(pedidoFinalizado);
        inventarioDeVendaa.adiciona(pedidoFinalizado);
    }

    public void adicionaPedidoALoja(Pedido pedido){
        listaDePedidos.add(pedido);
    }
    public void removePedidoDaLoja(Pedido pedido){
        listaDePedidos.remove(pedido);
    }
    public void removePedidoDaLoja(int indiceNumerodoPedido){
        listaDePedidos.remove(indiceNumerodoPedido);
    }
    public Pedido getPedido(int idiceNumerodoPedido){
        return listaDePedidos.get(idiceNumerodoPedido);
    }
    public List gerarRelatoriosDePedidos(){
        int numeroPedido=0;
        List<String> relatoriodeVendas=new ArrayList<>();
        for(Pedido pedido: listaDePedidos){
            relatoriodeVendas.add(inventarioDeVendaa.organizadorDeRelatorio(pedido, numeroPedido));
            numeroPedido++;
        }
        return relatoriodeVendas;
    }
    public List geraRelatoriodeVendas(){
        int numeroPedido=0;
        List<String> relatoriodeVendas=new ArrayList<>();
        for(Pedido pedido: inventarioDeVendaa.listaDeVendas){
            relatoriodeVendas.add(inventarioDeVendaa.organizadorDeRelatorio(pedido, numeroPedido));
            numeroPedido++;
        }
        return relatoriodeVendas;
    }

}
