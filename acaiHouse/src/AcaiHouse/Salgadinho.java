package AcaiHouse;

import Excecoes.SalgadoOpcaoInvalidaException;

import java.util.Objects;

public class Salgadinho extends Produto{
    private TipoSalgado tipo;

    public Salgadinho(int tipodoSalgado) throws SalgadoOpcaoInvalidaException {
        if(tipodoSalgado<=0 || tipodoSalgado >5)
            throw new SalgadoOpcaoInvalidaException();
        for(TipoSalgado procuraTipo: TipoSalgado.values()){
            if(tipodoSalgado == procuraTipo.getOpcao())
                this.tipo = procuraTipo;
        }
    }

    @Override
    public String getDescricao() {
        return "Salgado: " + tipo;
    }

    @Override
    public double calculaPreco() {
        return tipo.getValor();
    }

    public TipoSalgado getTipo() {
        return tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Salgadinho that)) return false;
        return tipo == that.tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo);
    }
}
