package Excecoes;

public class TamanhoNaoExisteExcepition extends Exception{
    @Override
    public String getMessage(){
        return "Tamanho não encontrado. Escolha entre ('P', 'G')";
    }

}
