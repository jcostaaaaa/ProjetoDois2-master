package com.example.projetodois.DAL;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Vistaestafeta {
    @Basic
    @Column(name = "NOMECLIENTE", nullable = false, length = 100)
    private String nomecliente;
    @Basic
    @Column(name = "RUACLIENTE", nullable = false, length = 100)
    private String ruacliente;
    @Basic
    @Column(name = "CODPOSTALCLIENTE", nullable = false, length = 10)
    private String codpostalcliente;
    @Basic
    @Column(name = "LOCALIDADE", nullable = false, length = 100)
    private String localidade;

    public String getNomecliente() {
        return nomecliente;
    }

    public void setNomecliente(String nomecliente) {
        this.nomecliente = nomecliente;
    }

    public String getRuacliente() {
        return ruacliente;
    }

    public void setRuacliente(String ruacliente) {
        this.ruacliente = ruacliente;
    }

    public String getCodpostalcliente() {
        return codpostalcliente;
    }

    public void setCodpostalcliente(String codpostalcliente) {
        this.codpostalcliente = codpostalcliente;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vistaestafeta that = (Vistaestafeta) o;
        return Objects.equals(nomecliente, that.nomecliente) && Objects.equals(ruacliente, that.ruacliente) && Objects.equals(codpostalcliente, that.codpostalcliente) && Objects.equals(localidade, that.localidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomecliente, ruacliente, codpostalcliente, localidade);
    }
}
