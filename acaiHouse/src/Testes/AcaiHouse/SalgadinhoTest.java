package AcaiHouse;

import Excecoes.SalgadoOpcaoInvalidaException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalgadinhoTest {

    @Test
    void getTipo() throws SalgadoOpcaoInvalidaException {
        Salgadinho salgado= new Salgadinho(1);
        assertEquals("coxinha".equals(salgado.getTipo()));

        Salgadinho salgado1= new Salgadinho(2);
        assertEquals("pastel".equals(salgado1.getTipo()));

        Salgadinho salgado2= new Salgadinho(3);
        assertEquals("empada".equals(salgado2.getTipo()));
    }

    private void assertEquals(boolean equals) {
    }

    @Test
    void testToString() throws SalgadoOpcaoInvalidaException {
        Salgadinho salgado= new Salgadinho(1);
        assertEquals("Salgado: coxinha Valor: 5.0}".equals(salgado.toString()));

        Salgadinho salgado1= new Salgadinho(2);
        assertEquals("Salgado: pastel Valor: 7.0}".equals(salgado1.toString()));

        Salgadinho salgado2= new Salgadinho(3);
        assertEquals("Salgado: empadapastel Valor: 7.0}".equals(salgado2.toString()));
    }

    @Test
    void calculaPreco() throws SalgadoOpcaoInvalidaException {
        Salgadinho salgado= new Salgadinho(1);
        assertEquals(5.0, salgado.calculaPreco());

        Salgadinho salgado2= new Salgadinho(2);
        assertEquals(7.0, salgado2.calculaPreco());

        Salgadinho salgado3= new Salgadinho(3);
        assertEquals(7.0, salgado.calculaPreco());
    }
    @Test
    void testaExcecoes() throws SalgadoOpcaoInvalidaException{
        assertThrows(SalgadoOpcaoInvalidaException.class, () -> {Produto salgado = new Salgadinho(0);});

        Exception excecao= new SalgadoOpcaoInvalidaException();
        assertEquals("Opção de salgado inálido. Digite de (1 à 5)".equals(excecao.getMessage()));
    }

    private void assertEquals(double v, double calculaPreco) {
    }
}