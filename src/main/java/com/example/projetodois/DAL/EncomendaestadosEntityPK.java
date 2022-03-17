package com.example.projetodois.DAL;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class EncomendaestadosEntityPK implements Serializable {
    @Column(name = "ID_ENCOMENDA", nullable = false, precision = 0)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short idEncomenda;
    @Column(name = "ID_ESTADOENCOMENDA", nullable = false, precision = 0)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short idEstadoencomenda;

    public short getIdEncomenda() {
        return idEncomenda;
    }

    public void setIdEncomenda(short idEncomenda) {
        this.idEncomenda = idEncomenda;
    }

    public short getIdEstadoencomenda() {
        return idEstadoencomenda;
    }

    public void setIdEstadoencomenda(short idEstadoencomenda) {
        this.idEstadoencomenda = idEstadoencomenda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EncomendaestadosEntityPK that = (EncomendaestadosEntityPK) o;
        return idEncomenda == that.idEncomenda && idEstadoencomenda == that.idEstadoencomenda;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEncomenda, idEstadoencomenda);
    }
}
