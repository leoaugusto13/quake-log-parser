package com.leonardo.logparser.model;

import java.util.ArrayList;
import java.util.List;

public class TempGame {

    private String nome;

    private List<String> linhas;

    public TempGame() {
        this.linhas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }


    public void setName(String nome) {
        this.nome = nome;
    }

    public List<String> getLinhas() {
        return linhas;
    }


    public void setLinhas(List<String> linhas) {
        this.linhas = linhas;
    }


    public void addLinhas(String linhas) {
        this.linhas.add(linhas);
    }


}

