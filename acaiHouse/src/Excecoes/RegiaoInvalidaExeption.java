package Excecoes;

public class RegiaoInvalidaExeption extends Exception{
    @Override
    public String getMessage(){
        return "Região fora do alcance de entrega";
    }
}
