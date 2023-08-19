package Excecoes;

public class AdicionalInvalidoException extends Exception{
    @Override
    public String getMessage(){
        return "Adicional Inválido. Digite de (1 à 7)";
    }
}
