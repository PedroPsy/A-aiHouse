package Excecoes;

public class SalgadoOpcaoInvalidaException extends Exception{
    @Override
    public String getMessage(){
        return "Opção de salgado inálido. Digite de (1 à 5)";
    }
}
