package com.algaworks.junit.utilidade;

import java.math.BigDecimal;

public class ContaBancaria {

    private BigDecimal saldo;

    public ContaBancaria(BigDecimal saldo) {
        if (saldo == null) {
            throw new IllegalArgumentException("Saldo não pode ser nulo");
        }
        this.saldo = saldo;
    }

    public void saque(BigDecimal valor) {
        int menorOuIgualZero = 0;

        try {
           menorOuIgualZero = valor.compareTo(BigDecimal.ZERO);
        } catch (NullPointerException e) {
            throw  new IllegalArgumentException("Valor do saque não pode ser nulo");
        }

        if (menorOuIgualZero <= 0) {
            throw new IllegalArgumentException("Valor de saque não pode ser menor ou igual a zero");
        }

        var saldoInsuficiente = this.saldo.compareTo(valor);


        if (saldoInsuficiente <= 0) {
            throw new RuntimeException("Valor insuficiente para saque");
        }

        this.saldo = saldo.subtract(valor);
    }

    public void deposito(BigDecimal valor) {
        int menorOuIgualZero = 0;

        try {
            menorOuIgualZero = valor.compareTo(BigDecimal.ZERO);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Valor de depósito não pode ser nulo");
        }

        if (menorOuIgualZero <= 0) {
            throw new IllegalArgumentException("Valor de saque não pode ser menor ou igual a zero");
        }

        this.saldo = saldo.add(valor);
    }

    public BigDecimal saldo() {
        return this.saldo;
    }
}
