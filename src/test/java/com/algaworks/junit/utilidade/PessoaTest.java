package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

    @Test
    void assercaoAgrupada() {
        Pessoa pessoa = new Pessoa("Eduardo", "Victor");

        assertAll("Asserções de pessoa",
                ()-> assertEquals("Eduardo", pessoa.getNome()),
                ()-> assertEquals("Victor", pessoa.getSobrenome())
            );
    }

}