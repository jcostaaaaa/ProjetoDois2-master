package com.example.projetodois.DAL;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PRATOS_ENCOMENDADOS", schema = "PROJETOBD", catalog = "")
@IdClass(PratosEncomendadosPK.class)
public class PratosEncomendados {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_PRATO", nullable = false, precision = 0)
    private short idPrato;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_ENCOMENDA", nullable = false, precision = 0)
    private short idEncomenda;
    @Basic
    @Column(name = "QTDDOSES", nullable = false, precision = 0)
    private double qtddoses;
    @Basic
    @Column(name = "PRECODOSE", nullable = false, precision = 0)
    private double precodose;

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

    public double getQtddoses() {
        return qtddoses;
    }

    public void setQtddoses(double qtddoses) {
        this.qtddoses = qtddoses;
    }

    public double getPrecodose() {
        return precodose;
    }

    public void setPrecodose(double precodose) {
        this.precodose = precodose;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PratosEncomendados that = (PratosEncomendados) o;
        return idPrato == that.idPrato && idEncomenda == that.idEncomenda && Double.compare(that.qtddoses, qtddoses) == 0 && Double.compare(that.precodose, precodose) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPrato, idEncomenda, qtddoses, precodose);
    }
}
