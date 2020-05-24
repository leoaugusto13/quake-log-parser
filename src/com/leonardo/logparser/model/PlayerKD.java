package com.leonardo.logparser.model;

import java.util.HashMap;
import java.util.Map;

public class PlayerKD {


    private Integer mortesValidas;

    private Integer contadorMatar;

    private Integer contadorMortes;

    private final Map<DeathType, Integer> contadorTipoMortes;

    public PlayerKD() {
        this.contadorMatar = 0;
        this.contadorMortes = 0;
        this.setMortesValidas(0);
        this.contadorTipoMortes = new HashMap<>();
    }

    public Integer getContadorMortes() {
        return contadorMortes;
    }

    public void setContadorMortes(Integer contadorMortes) {
        this.contadorMortes = contadorMortes;
    }

    public Integer getContadorMatar() {
        return contadorMatar;
    }

    public void setContadorMatar(Integer contadorMatar) {
        this.contadorMatar = contadorMatar;
    }

    public void adicionarMatarValidas() {
        this.mortesValidas++;
    }

    public void adicionarMatar() {
        this.contadorMatar++;
    }

    public void adicionarMortes() {
        this.contadorMortes++;
    }

    public void punicao() {
        this.contadorMatar--;
    }


    public Map<DeathType, Integer> getContadorTipoMortes() {
        return contadorTipoMortes;
    }

    public void adicionarTiposMorte(final DeathType tipoMorte) {
        if (!this.contadorTipoMortes.containsKey(tipoMorte)) {
            this.contadorTipoMortes.put(tipoMorte, 0);
        }

        final Integer previousValue = this.contadorTipoMortes.get(tipoMorte);
        this.contadorTipoMortes.put(tipoMorte, previousValue + 1);
    }

    public Integer getMortesValidas() {
        return mortesValidas;
    }

    public void setMortesValidas(Integer mortesValidas) {
        this.mortesValidas = mortesValidas;
    }

}
