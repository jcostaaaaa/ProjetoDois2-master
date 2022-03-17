package com.example.projetodois.DAL;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq")
    @SequenceGenerator(name="cliente_seq", sequenceName = "cliente_seq", allocationSize = 1)
    @Column(name = "ID_CLIENTE", nullable = false, precision = 0)
    private short idCliente;
    @Basic
    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;
    @Basic
    @Column(name = "NIF", nullable = false, precision = 0)
    private int nif;
    @Basic
    @Column(name = "RUA", nullable = false, length = 100)
    private String rua;
    @Basic
    @Column(name = "CODPOSTAL", nullable = false, length = 10)
    private String codpostal;
    @Basic
    @Column(name = "NUMTELEMOVEL", nullable = false, length = 20)
    private String numtelemovel;

    public short getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(short idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(String codpostal) {
        this.codpostal = codpostal;
    }

    public String getNumtelemovel() {
        return numtelemovel;
    }

    public void setNumtelemovel(String numtelemovel) {
        this.numtelemovel = numtelemovel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clientes clientes = (Clientes) o;
        return idCliente == clientes.idCliente && nif == clientes.nif && Objects.equals(nome, clientes.nome) && Objects.equals(rua, clientes.rua) && Objects.equals(codpostal, clientes.codpostal) && Objects.equals(numtelemovel, clientes.numtelemovel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCliente, nome, nif, rua, codpostal, numtelemovel);
    }
}
