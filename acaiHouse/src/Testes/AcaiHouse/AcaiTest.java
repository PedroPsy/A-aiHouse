package AcaiHouse;

import Excecoes.AdicionalInvalidoException;
import Excecoes.TamanhoNaoExisteExcepition;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AcaiTest {

    @org.junit.jupiter.api.Test
    void testToString() throws TamanhoNaoExisteExcepition, AdicionalInvalidoException {
        Produto produto= new Acai('P', 1);
        assertEquals("Açaí{ Tamanho = P, adicionais = LEITECON Valor final: R$10.0}", produto.toString());

        Produto produto2= new Acai('G', 5);
        assertEquals("Açaí{ Tamanho = G, adicionais = KIWI Valor final: R$17.0}", produto2.toString());

        Produto produto3= new Acai('P', 6);
        assertEquals("Açaí{ Tamanho = P, adicionais = NENHUM Valor final: R$10.0}", produto3.toString());
    }


    @org.junit.jupiter.api.Test
    void calculaPreco() throws TamanhoNaoExisteExcepition, AdicionalInvalidoException {
        Produto produto= new Acai('P', 1);
        assertEquals(10.0, produto.calculaPreco());

        Produto produto2= new Acai('G', 5);
        assertEquals(17.0, produto2.calculaPreco());

        Produto produto3= new Acai('P', 5);
        assertEquals(12.0, produto3.calculaPreco());
    }
    @Test
    void ExceptionTest(){
        assertThrows(TamanhoNaoExisteExcepition.class, () -> {Produto produto = new Acai('j', 1);});

        assertThrows(AdicionalInvalidoException.class, () -> {Produto produtoExcecao = new Acai('P', 0);});

        Exception exceptionTamanho= new TamanhoNaoExisteExcepition();
        assertEquals("Tamanho não encontrado. Escolha entre ('P', 'G')", exceptionTamanho.getMessage());
        Exception exceptionAdicional= new AdicionalInvalidoException();
        assertEquals("Adicional Inválido. Digite de (1 à 7)", exceptionAdicional.getMessage());

    }
}