package AcaiHouse;

public enum Adicional {
    LEITECON(1), LEITEPO(2), AMENDOIN(3), MORANGO(4), KIWI(5), NENHUM(6), SAIR(7);
    private int opcao;
    public int getOpcao() {
        return opcao;
    }
    public double getValorAdicional(){
        double valorAdicional=0.0;
        if(opcao == MORANGO.getOpcao() || opcao== KIWI.getOpcao()){
            valorAdicional= 2.0;
        }
        return valorAdicional;
    }

    Adicional(int opcao){
        this.opcao= opcao;
    }
}
