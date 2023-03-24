package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class SimuladorEsperaTest {

    @Test
    //@Disabled("Não é mais aplicável")
    //@EnabledIfEnvironmentVariable(named = "ENV", matches = "PROD")
    void deveEsperarENaoDarTimeout() {
        //Assumptions.assumeTrue("PROD".equals(System.getenv("ENV")), ()-> "Abortando teste: Não deve ser executado em PROD");
        //assertTimeout(Duration.ofSeconds(1), ()-> SimuladorEspera.esperar(Duration.ofSeconds(10)));
        assertTimeoutPreemptively(Duration.ofSeconds(10), ()-> SimuladorEspera.esperar(Duration.ofSeconds(1)));
    }

}