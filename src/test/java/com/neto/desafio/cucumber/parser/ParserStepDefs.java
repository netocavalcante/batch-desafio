package com.neto.desafio.cucumber.parser;

import cucumber.api.java.pt.Dado;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

import static com.neto.desafio.shared.ConstatesTest.PATH_IN;

public class ParserStepDefs {

    @Dado("^que exista o arquivo \"([^\"]*)\" com o conteúdo$")
    public void queExistaOArquivoComOConteúdo(String nomeArquivo, String conteudo) throws IOException {

        Path path = Paths.get(PATH_IN , nomeArquivo);

        Files.write(path, Collections.singleton(conteudo));
    }

}
