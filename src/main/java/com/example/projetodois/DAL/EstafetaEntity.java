package com.example.projetodois.DAL;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ESTAFETA", schema = "PROJETOBD", catalog = "")
public class EstafetaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_ESTAFETA", nullable = false, precision = 0)
    private short idEstafeta;
    @Basic
    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;
    @Basic
    @Column(name = "NUMTELEFONE", nullable = true, length = 20)
    private String numtelefone;
    @Basic
    @Column(name = "NIF", nullable = false, precision = 0)
    private int nif;
    @Basic
    @Column(name = "EMAIL", nullable = true, length = 20)
    private String email;

    public short getIdEstafeta() {
        return idEstafeta;
    }

    public void setIdEstafeta(short idEstafeta) {
        this.idEstafeta = idEstafeta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumtelefone() {
        return numtelefone;
    }

    public void setNumtelefone(String numtelefone) {
        this.numtelefone = numtelefone;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstafetaEntity that = (EstafetaEntity) o;
        return idEstafeta == that.idEstafeta && nif == that.nif && Objects.equals(nome, that.nome) && Objects.equals(numtelefone, that.numtelefone) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEstafeta, nome, numtelefone, nif, email);
    }
}
