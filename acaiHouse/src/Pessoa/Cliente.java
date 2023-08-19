package Pessoa;


import Excecoes.RegiaoInvalidaExeption;


public class Cliente extends Pessoa{
    private Frete frete;

    public Cliente(String nome, String endereco) throws RegiaoInvalidaExeption {
        super(nome, endereco);
        for (Frete procuraFretr : Frete.values()) {
            if (endereco.equals("RIO TINTO") || endereco.equals("MAMANGUAPE") || endereco.equals("VILA")) {
                if(endereco.equals(procuraFretr.getRegiao())) {
                    this.endereco = procuraFretr.getRegiao();
                    this.frete= procuraFretr;
                }
            }
            else
                throw new RegiaoInvalidaExeption();
        }
    }
    public double valorFrete() throws RegiaoInvalidaExeption {
        return  frete.getValor();
    }

}
