package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

public class ContaBancariaTest {

    @Test
    public void criarContaBancaria() {
        assertDoesNotThrow(() -> new ContaBancaria(new BigDecimal("1000")));

    }

    @Test
    public void criarContaBancariaLancarException() {
        IllegalArgumentException  illegalArgumentException =
                assertThrows(IllegalArgumentException.class, () -> new ContaBancaria(null));

        assertEquals("Saldo não pode ser nulo", illegalArgumentException.getMessage());

    }

    @Test
    public void saqueTest() {
        var conta = new ContaBancaria(new BigDecimal("1000"));

        assertDoesNotThrow(() -> conta.saque(new BigDecimal("50")));

        System.out.println(conta.saldo());
    }

    @Test
    public void saqueTestLancarException() {
        var conta = new ContaBancaria(new BigDecimal("1000"));

        IllegalArgumentException valorDeSaqueNulo =
                assertThrows(IllegalArgumentException.class, () ->
                        conta.saque(null));

        assertEquals("Valor do saque não pode ser nulo",
                valorDeSaqueNulo.getMessage());

        IllegalArgumentException valorDeSaqueMenorZero =
                assertThrows(IllegalArgumentException.class, () ->
                        conta.saque(new BigDecimal("-10")));

        assertEquals("Valor de saque não pode ser menor ou igual a zero",
                valorDeSaqueMenorZero.getMessage());

        IllegalArgumentException valorDeSaqueIgualZero =
                assertThrows(IllegalArgumentException.class, () ->
                        conta.saque(BigDecimal.ZERO));

        assertEquals("Valor de saque não pode ser menor ou igual a zero",
                valorDeSaqueIgualZero.getMessage());

        RuntimeException valorDeSaldoInsuficiente = assertThrows(RuntimeException.class, ()->
                conta.saque(new BigDecimal("10000")));

        assertEquals("Valor insuficiente para saque",
                valorDeSaldoInsuficiente.getMessage());

    }

    @Test
    public void depositoTest() {
        var conta = new ContaBancaria(new BigDecimal("1000"));

        assertDoesNotThrow(() -> conta.deposito(new BigDecimal("100")));

        System.out.println(conta.saldo());

    }

    @Test
    public void depositoTestLancarException() {
        var conta = new ContaBancaria(new BigDecimal("1000"));

        IllegalArgumentException depositoNulo = assertThrows(IllegalArgumentException.class,
                () -> conta.deposito(null));

        assertEquals("Valor de depósito não pode ser nulo", depositoNulo.getMessage());

        IllegalArgumentException depositoIgualZero = assertThrows(IllegalArgumentException.class,
                () -> conta.deposito(BigDecimal.ZERO));

        assertEquals("Valor de saque não pode ser menor ou igual a zero",
                depositoIgualZero.getMessage());

        IllegalArgumentException depositoMenorZero = assertThrows(IllegalArgumentException.class,
                () -> conta.deposito(new BigDecimal("-100")));

        assertEquals("Valor de saque não pode ser menor ou igual a zero",
                depositoMenorZero.getMessage());
    }

    @Test
    public void saldoTest() {
        var conta = new ContaBancaria(new BigDecimal("1000"));

        assertEquals(new BigDecimal("1000"), conta.saldo());
    }

}
