package AcaiHouse;

public enum TipoSalgado {
    coxinha (1), pastel (2), empada (3), finalizar(4);

    private final int opcao;


    public int getOpcao() {
        return opcao;
    }

    TipoSalgado(int opcao) {
        this.opcao = opcao;
    }
    public double getValor(){
        double valorSalgado=0.0;
        switch(getOpcao()){
            case 1:
                valorSalgado = 5.0;
                break;
            case 2:
                valorSalgado = 7.0;
                break;
            case 3:
                valorSalgado = 7.0;
                break;
        }
        return valorSalgado;
    }
}
