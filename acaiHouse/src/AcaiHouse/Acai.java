package AcaiHouse;
import Excecoes.AdicionalInvalidoException;
import Excecoes.TamanhoNaoExisteExcepition;
import java.util.Objects;

public class Acai extends Produto {
    private Tamanho tamanho;
    private Adicional adicional;

    @Override
    public String toString() {
        return "Açaí{ " +
                "Tamanho = " + tamanho +
                ", adicionais = " + adicional +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Acai acai)) return false;
        return tamanho == acai.tamanho && adicional == acai.adicional;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tamanho, adicional);
    }

    public Acai(char tamanho, int adicional) throws TamanhoNaoExisteExcepition, AdicionalInvalidoException {
        for( Tamanho procuraTamanho: Tamanho.values()){
            if(tamanho == 'P'|| tamanho== 'G') {
                if (tamanho == procuraTamanho.getTamanho()) {
                    this.tamanho = procuraTamanho;
                }
            }
            else{
                throw new TamanhoNaoExisteExcepition();
            }
        }
        for(Adicional procuraAdicional: Adicional.values()){
            if(adicional<=0 || adicional>7){
                throw new AdicionalInvalidoException();
            }
            if(adicional == procuraAdicional.getOpcao()){
                this.adicional= procuraAdicional;
            }
        }
       valor= calculaPreco();
        descricao= toString();
    }

    @Override
    public double calculaPreco() {
        return tamanho.getValor()+ adicional.getValorAdicional();
    }

}
