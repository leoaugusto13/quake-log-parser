package com.leonardo.logparser.quake;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import br.com.leonardo.logparser.exception.NotFoundLogException;
import br.com.leonardo.logparser.exception.ReadLogException;
import br.com.leonardo.logparser.file.Reader;
import br.com.leonardos.logparser.model.Game;


public class Parser {

    public static void main(String[] args) {

        System.out.println("Escolha o diretorio do arquivo: ");
        @SuppressWarnings("resource")
        final String path = new Scanner(System.in).next();

        // Read all lines from Quake Log
        List<String> lines;
        try {
            lines = Reader.readLines(path);
        } catch (ReadLogException | NotFoundLogException e) {
            System.out.println(e.getMessage());
            return;
        }


        final List<Game> games = GameParser.execute(lines);


        Display.printGames(games);
    }

}

}
