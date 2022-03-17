package com.example.projetodois.DAL;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@IdClass(EncomendaestadosPK.class)
public class Encomendaestados {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_ENCOMENDA", nullable = false, precision = 0)
    private short idEncomenda;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_ESTADOENCOMENDA", nullable = false, precision = 0)
    private short idEstadoencomenda;
    @Basic
    @Column(name = "DATA", nullable = false)
    private Date data;

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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Encomendaestados that = (Encomendaestados) o;
        return idEncomenda == that.idEncomenda && idEstadoencomenda == that.idEstadoencomenda && Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEncomenda, idEstadoencomenda, data);
    }
}
