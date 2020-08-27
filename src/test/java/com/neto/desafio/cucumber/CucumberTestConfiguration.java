package com.neto.desafio.cucumber;

import com.neto.desafio.DesafioApplication;
import cucumber.api.java.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = DesafioApplication.class, loader = SpringBootContextLoader.class)
public class CucumberTestConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(CucumberTestConfiguration.class);

    @Before
    public void inicializer() {
        logger.info(" ------ Incializando os testes cucumber -------");
    }
}
