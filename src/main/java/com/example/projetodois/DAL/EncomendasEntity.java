package com.example.projetodois.DAL;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ENCOMENDAS", schema = "PROJETOBD", catalog = "")
public class EncomendasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_ENCOMENDA", nullable = false, precision = 0)
    private short idEncomenda;
    @Basic
    @Column(name = "VALORTOTAL", nullable = false, precision = 0)
    private double valortotal;
    @Basic
    @Column(name = "ID_CLIENTE", nullable = false, precision = 0)
    private short idCliente;
    @Basic
    @Column(name = "ID_ESTAFETA", nullable = true, precision = 0)
    private Short idEstafeta;
    @Basic
    @Column(name = "TIPOPAGAMENTOID", nullable = false, precision = 0)
    private short tipopagamentoid;

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

    public short getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(short idCliente) {
        this.idCliente = idCliente;
    }

    public Short getIdEstafeta() {
        return idEstafeta;
    }

    public void setIdEstafeta(Short idEstafeta) {
        this.idEstafeta = idEstafeta;
    }

    public short getTipopagamentoid() {
        return tipopagamentoid;
    }

    public void setTipopagamentoid(short tipopagamentoid) {
        this.tipopagamentoid = tipopagamentoid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EncomendasEntity that = (EncomendasEntity) o;
        return idEncomenda == that.idEncomenda && Double.compare(that.valortotal, valortotal) == 0 && idCliente == that.idCliente && tipopagamentoid == that.tipopagamentoid && Objects.equals(idEstafeta, that.idEstafeta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEncomenda, valortotal, idCliente, idEstafeta, tipopagamentoid);
    }
}
