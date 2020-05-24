package com.leonardo.logparser.model;

import java.util.ArrayList;
import java.util.List;

public class TempGame {

    private String name;

    private List<String> lines;

    public TempGame() {
        this.lines = new ArrayList<>();
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public List<String> getLines() {
        return lines;
    }

     public void setLines(List<String> lines) {
        this.lines = lines;
    }

    public void addLine(String line) {
        this.lines.add(line);
    }


}

