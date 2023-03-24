package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class SaudacaoUtilTest {

    @Test
    public void saudarTest() {
        //Arrange
        int horaValida = 9;

        //Act
        String saudacao = SaudacaoUtil.saudar(horaValida);

        //Assert
        assertEquals("Bom dia", saudacao, "Saudação incorreta");
    }

    @Test
    public void deveLancarException() {
        //Arrange
        int  horaInvalida = -10;

        //Act
        Executable executable = () -> SaudacaoUtil.saudar(horaInvalida);

        //Assert
        IllegalArgumentException illegalArgumentException = assertThrows(
                IllegalArgumentException.class, executable);

        assertEquals("Hora inválida", illegalArgumentException.getMessage());
    }

    @Test
    public void naoDeveLancarException() {
        assertDoesNotThrow(()-> SaudacaoUtil.saudar(0));
    }

}