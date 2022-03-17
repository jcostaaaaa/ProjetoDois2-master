package com.example.projetodois.DAL;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Pratos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_PRATO", nullable = false, precision = 0)
    private short idPrato;
    @Basic
    @Column(name = "DESCRICAO", nullable = false, length = 150)
    private String descricao;
    @Basic
    @Column(name = "STOCKDOSES", nullable = false, precision = 0)
    private double stockdoses;
    @Basic
    @Column(name = "PRECOATUAL", nullable = false, precision = 0)
    private double precoatual;

    public short getIdPrato() {
        return idPrato;
    }

    public void setIdPrato(short idPrato) {
        this.idPrato = idPrato;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getStockdoses() {
        return stockdoses;
    }

    public void setStockdoses(double stockdoses) {
        this.stockdoses = stockdoses;
    }

    public double getPrecoatual() {
        return precoatual;
    }

    public void setPrecoatual(double precoatual) {
        this.precoatual = precoatual;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pratos pratos = (Pratos) o;
        return idPrato == pratos.idPrato && Double.compare(pratos.stockdoses, stockdoses) == 0 && Double.compare(pratos.precoatual, precoatual) == 0 && Objects.equals(descricao, pratos.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPrato, descricao, stockdoses, precoatual);
    }
}
