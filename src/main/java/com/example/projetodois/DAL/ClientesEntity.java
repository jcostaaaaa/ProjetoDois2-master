package com.example.projetodois.DAL;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/*
* Tabela clientes
*
* */

@Entity
@Table(name = "CLIENTES")
@XmlRootElement
@NamedQueries ({
        @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM ClientesEntity c"),
        @NamedQuery(name = "Clientes.findAllByNome", query = "SELECT c FROM ClientesEntity c WHERE c.nome LIKE :nome"),
        @NamedQuery(name = "Clientes.findByIdcliente", query = "SELECT c FROM ClientesEntity c WHERE c.idCliente = :id_cliente"),
        @NamedQuery(name = "Clientes.findByNome", query = "SELECT c FROM ClientesEntity c WHERE c.nome = :nome"),
        @NamedQuery(name = "Clientes.findByrua", query = "SELECT c FROM ClientesEntity c WHERE c.rua = :rua"),
        @NamedQuery(name = "Clientes.findByCpostal", query = "SELECT c FROM ClientesEntity c WHERE c.codpostal = :codpostal")

})
//@Table(name = "CLIENTES", schema = "PROJETOBD", catalog = "")


public class ClientesEntity implements Serializable  {
    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
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

/*
public class ClientesEntity {
    private int idCliente;
    private String nome;
    private String nif;
    private String rua;
    private String codpostal;
    private String numtelemovel;
*/


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        ClientesEntity that = (ClientesEntity) o;
        return idCliente == that.idCliente && nif == that.nif && Objects.equals (nome, that.nome) && Objects.equals (rua, that.rua) && Objects.equals (codpostal, that.codpostal) && Objects.equals (numtelemovel, that.numtelemovel);
    }

    @Override
    public int hashCode() {
        return Objects.hash (idCliente, nome, nif, rua, codpostal, numtelemovel);
    }
}








/**
 *
 * CRUD DO CLIENTE
 * **/

/**
 * CRIAR CLIENTE
 * *

public void create () {

    //preparedStatement, vai efetuar a conexao com a bd
    Connection conn = util.criarConexao ();

    String sqlCommand = "INSERT INTO CLIENTES COLUMNS(ID_CLIENTE, NOME, NIF, RUA, CODPOSTAL, NUMTELEMOVEL) VALUES(?, ?, ?, ?,?,?)"; //código sql para a inserção dos dados

    try {
        PreparedStatement st = conn.prepareStatement (sqlCommand);
        st.setInt (1, this.idCliente);
        st.setString (2, this.nome);
        st.setString (3,  (this.nif));
        st.setString (4, this.rua);
        st.setString (5,  (this.codpostal));
        st.setString (6, (this.numtelemovel));
        st.execute ();

    } catch (SQLException ex ) {
        System.out.println("ERRO: " + ex.getMessage()); //retornar a mensagem do utilizador
    }
    }

    /**
     *
     *  Ler apenas o id de um cliente especifico bd


 public void read (int idCliente){
     Connection conn  = util.criarConexao ();

     String sqlCommand = "SELECT * FROM CLIENTES WHERE ID_CLIENTE = ?";

     try {
         PreparedStatement st = conn.prepareStatement (sqlCommand);
         st.setInt(1, idCliente);

         ResultSet rs = st.executeQuery();

         if(rs.next()){
             this.idCliente = idCliente;
             if (rs.getString("NOME") != null) this.nome = rs.getString("NOME");
             else this.nome = "";
             if (rs.getString("RUA") != null) this.rua = rs.getString("RUA");
             else this.rua = "";
             if (rs.getString("CODPOSTAL") != null) this.codpostal = rs.getString("CODPOSTAL");
             else this.codpostal = "";
         }
         else{
             System.out.println("ERRO: Não existe Cliente com o ID definido ");
         }
     } catch (SQLException ex) {
         System.out.println("ERRO: " + ex.getMessage());
     }

 }

/*
 Ler todos os registos de clientes

    public static ListClientesEntity> readAll(String nome ){
        Connection conn = util.criarConexao();

        String sqlCommand = "SELECT ID_CLIENTE, NIF,  NOME, RUA, CODPOSTAL FROM CLIENTES";

        ListClientesEntity> lista = new ArrayList<> ();

        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);


            ResultSet rs = st.executeQuery();

            while(rs.next()){
                ClientesEntity cli = new ClientesEntity();

                cli.setIdCliente((short) rs.getInt("ID_CLIENTE"));
                if (rs.getString("NOME") != null) cli.setNome(rs.getString("NOME"));
                //
                if (rs.getString("RUA") != null) cli.setRua (rs.getString("RUA"));
                //
                if (rs.getString("CODPOSTAL") != null) cli.setCodpostal (rs.getString("CODPOSTAL"));

                lista.add(cli);
            }

        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex.getMessage());
        }

        return lista;
    }


    /**
     *  Update registos de clientes

    public void update(){
        // PreparedStatement
        Connection conn = util.criarConexao();

        String sqlCommand = "UPDATE CLIENTES SET NOME = ?,  RUA = ?, CODPOSTAL = ? NUMTELEMOVEL = ? WHERE ID_CLIENTE = ?";

        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setString(1, this.nome);
            st.setString(2, this.rua);
            st.setString(3, this.codpostal);
            st.setString (4, this.numtelemovel);
            st.setInt(5, this.idCliente);

            st.execute();

        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex.getMessage());
        }
    }

    /**
     *  Apagar registos de clientes

    public void delete(){
        // PreparedStatement
        Connection conn = util.criarConexao();

        String sqlCommand = "DELETE CLIENTES WHERE ID_CLIENTE = ?";

        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setInt(1, this.idCliente);

            st.execute();

        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex.getMessage());
        }
    }
    */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

