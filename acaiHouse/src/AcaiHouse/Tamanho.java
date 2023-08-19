package AcaiHouse;


public enum Tamanho  {
    P('P'), G('G');
    private char tamanho;
    public char getTamanho(){
        return tamanho;
    }
    Tamanho(char tamanho){
        this.tamanho = tamanho;
    }
    public double getValor() {
        double valor=0.0;
        switch (getTamanho()){
            case 'P':
                valor= 10.0;
                break;
            case 'G':
                valor= 15.0;
                break;
        }
        return valor;
    }



}
