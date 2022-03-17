package com.example.projetodois.DAL;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Detalhesencomenda {
    @Basic
    @Column(name = "ID_ENCOMENDA", nullable = false, precision = 0)
    private short idEncomenda;
    @Basic
    @Column(name = "VALORTOTAL", nullable = false, precision = 0)
    private double valortotal;
    @Basic
    @Column(name = "NOMECLIENTE", nullable = false, length = 100)
    private String nomecliente;

    public short getIdEncomenda() {
        return idEncomenda;
    }

    public void setIdEncomenda(short idEncomenda) {
        this.idEncomenda = idEncomenda;
    }

    public double getValortotal() {
        return valortotal;
    }

    public void setValortotal(double valortotal) {
        this.valortotal = valortotal;
    }

    public String getNomecliente() {
        return nomecliente;
    }

    public void setNomecliente(String nomecliente) {
        this.nomecliente = nomecliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Detalhesencomenda that = (Detalhesencomenda) o;
        return idEncomenda == that.idEncomenda && Double.compare(that.valortotal, valortotal) == 0 && Objects.equals(nomecliente, that.nomecliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEncomenda, valortotal, nomecliente);
    }
}
