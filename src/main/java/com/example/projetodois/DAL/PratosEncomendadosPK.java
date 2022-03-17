package com.example.projetodois.DAL;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PratosEncomendadosPK implements Serializable {
    @Column(name = "ID_PRATO", nullable = false, precision = 0)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short idPrato;
    @Column(name = "ID_ENCOMENDA", nullable = false, precision = 0)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short idEncomenda;

    public short getIdPrato() {
        return idPrato;
    }

    public void setIdPrato(short idPrato) {
        this.idPrato = idPrato;
    }

    public short getIdEncomenda() {
        return idEncomenda;
    }

    public void setIdEncomenda(short idEncomenda) {
        this.idEncomenda = idEncomenda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PratosEncomendadosPK that = (PratosEncomendadosPK) o;
        return idPrato == that.idPrato && idEncomenda == that.idEncomenda;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPrato, idEncomenda);
    }
}
