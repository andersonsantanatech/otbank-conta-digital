package br.zup.com.otbank;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContaTest {

    @Test
    public void deveCreditarValorPositivoComSucesso() {

        Conta conta = getConta();

        conta.creditar(new BigDecimal("50.00"));

        assertEquals(conta.getSaldo(), new BigDecimal("150.00"));
    }

    @Test
    public void naoDeveCreditarValorNegativo() {

        Conta conta = getConta();

        conta.creditar(new BigDecimal("-50.00"));

        assertEquals(conta.getSaldo(), new BigDecimal("100.00"));

    }

    @Test
    public void naoDeveCreditarValorIgualZero() {

        Conta conta = getConta();

        conta.creditar(new BigDecimal("0.0"));

        assertEquals(conta.getSaldo(), new BigDecimal("100.00"));
    }

    private Conta getConta() {
        var idClient = UUID.randomUUID();
        return new Conta("123456-7", idClient, new BigDecimal("100.00"));
    }

}