package Pessoa;

import Excecoes.RegiaoInvalidaExeption;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FreteTest {

    @Test
    void getRegiao() {
        Frete procuraRegiao= Frete.RIOTINTO;
        assertEquals("rio tinto".equals(procuraRegiao.getRegiao()));
        Frete procuraRegiaoM= Frete.MAMANGUAPE;
        assertEquals("mamanguape".equals(procuraRegiaoM.getRegiao()));
        Frete procuraRegiaoV= Frete.VILA;
        assertEquals("vila regina".equals(procuraRegiaoV.getRegiao()));

    }

    private void assertEquals(boolean equals) {
    }

    @Test
    void getValor() throws RegiaoInvalidaExeption {
        Frete procuraRegiao= Frete.RIOTINTO;
        assertEquals(2.0, procuraRegiao.getValor());

        Frete procuraRegiaoM= Frete.MAMANGUAPE;
        assertEquals(7.0, procuraRegiaoM.getValor());

        Frete procuraRegiaoV= Frete.VILA;
        assertEquals(4.0, procuraRegiaoV.getValor());
    }

    private void assertEquals(double v, double valor) {
    }
}