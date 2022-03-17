package com.example.projetodois.DAL;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PRATOS", schema = "PROJETOBD", catalog = "")
public class PratosEntity {
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
        PratosEntity that = (PratosEntity) o;
        return idPrato == that.idPrato && Double.compare(that.stockdoses, stockdoses) == 0 && Double.compare(that.precoatual, precoatual) == 0 && Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPrato, descricao, stockdoses, precoatual);
    }
}
