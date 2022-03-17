package com.example.projetodois.DAL;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
public class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_USER", nullable = false, precision = 0)
    private BigInteger idUser;
    @Basic
    @Column(name = "EMAIL", nullable = false, length = 100)
    private String email;
    @Basic
    @Column(name = "PASSWORD", nullable = false, length = 100)
    private String password;
    @Basic
    @Column(name = "IS_ADMIN", nullable = false, precision = 0)
    private boolean isAdmin;
    @Basic
    @Column(name = "IS_GESTOR", nullable = false, precision = 0)
    private boolean isGestor;
    @Basic
    @Column(name = "IS_ESTAFETA", nullable = false, precision = 0)
    private boolean isEstafeta;
    @Basic
    @Column(name = "IS_COZINHEIRO", nullable = false, precision = 0)
    private boolean isCozinheiro;
    @Basic
    @Column(name = "NOMEUSER", nullable = false, length = 20)
    private String nomeuser;

    public BigInteger getIdUser() {
        return idUser;
    }

    public void setIdUser(BigInteger idUser) {
        this.idUser = idUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isGestor() {
        return isGestor;
    }

    public void setGestor(boolean gestor) {
        isGestor = gestor;
    }

    public boolean isEstafeta() {
        return isEstafeta;
    }

    public void setEstafeta(boolean estafeta) {
        isEstafeta = estafeta;
    }

    public boolean isCozinheiro() {
        return isCozinheiro;
    }

    public void setCozinheiro(boolean cozinheiro) {
        isCozinheiro = cozinheiro;
    }

    public String getNomeuser() {
        return nomeuser;
    }

    public void setNomeuser(String nomeuser) {
        this.nomeuser = nomeuser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return isAdmin == users.isAdmin && isGestor == users.isGestor && isEstafeta == users.isEstafeta && isCozinheiro == users.isCozinheiro && Objects.equals(idUser, users.idUser) && Objects.equals(email, users.email) && Objects.equals(password, users.password) && Objects.equals(nomeuser, users.nomeuser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, email, password, isAdmin, isGestor, isEstafeta, isCozinheiro, nomeuser);
    }
}
