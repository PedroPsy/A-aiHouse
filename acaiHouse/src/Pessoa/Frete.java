package Pessoa;

import Excecoes.RegiaoInvalidaExeption;

public enum Frete {
    RIOTINTO("RIO TINTO"), MAMANGUAPE("MAMANGUAPE"), VILA("VILA");
    // QUANDO FOR USAR, SELEÇAO POR NUMERO PARA DAR CERTO
    private String regiao;

    public String getRegiao() {
        return regiao;
    }
    Frete(String regiao){
        this.regiao=regiao;
    }
    public double getValor() throws RegiaoInvalidaExeption {
        double valor = 0.0;
        switch (getRegiao()){
            case "RIO TINTO":
                valor=2.0;
                break;
            case "MAMANGUAPE":
                valor=7.0;
                break;
            case "VILA":
                valor= 4.0;
                break;
            default:
                throw new RegiaoInvalidaExeption();
        }
        return valor;
    }
}
