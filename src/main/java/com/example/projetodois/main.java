package com.example.projetodois;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;
import com.example.projetodois.DAL.ClientesEntity;
import com.example.projetodois.BLL.ClienteBLL;
//import com.example.projetodois.JPABLL.ClienteJpaController;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author Utilizador
 */



public class main {

    public static void main(String[] args) {


        ClientesEntity cli = new ClientesEntity ();
        cli.setNome("Jeronimo Mafarrico");
        cli.setRua ("Rua BLALBLA");
        cli.setCodpostal ("7892-674");

        ClienteBLL.create(cli);
        //ou
        //ClienteJpaController cliBll = new ClienteJpaController(factory);
        //cliBll.create(cli);
        //
        //
        System.out.println("ID criado: " + cli.getIdCliente());

        ClientesEntity cl2 = ClienteBLL.read(cli.getIdCliente());

        if (cli.equals(cl2)) System.out.println("É o mesmo cliente!!!");
        else System.out.println("Pois!");


        List<ClientesEntity> lista = ClienteBLL.readAll("Ana");
        for(ClientesEntity cli1 : lista)
            System.out.println("ID " + cli1.getIdCliente() + " chama-se " + cli1.getNome() + " e mora em " + cli1.getRua ());



      /*
        // TODO code application logic here

        ClientesEntity cli = new ClientesEntity ();
        cli.setIdCliente ('6');
        cli.setNome("Alambique de Almeida");
        cli.setNif ("444444");
        cli.setRua ("Rua Alfa  321");
        cli.setCodpostal ("23");
        cli.setNumtelemovel ("33333");
        cli.create();

        System.out.println("ID criado: " + cli.getIdCliente());

        /*
        Cliente cl2 = new Cliente();
        cl2.read(43);
        System.out.println("ID " + cl2.getIdCliente() + " chama-se " + cl2.getNome() + " e mora em " + cl2.getMorada());


        List<ClientesEntity> listaDeClientes = ClientesEntity.readAll( "nome");

        for(ClientesEntity cl : listaDeClientes)
            System.out.println("ID " + cl.getIdCliente() + " chama-se " + cl.getNome() + " e mora em " + cl.getRua ());

        System.out.println("----------------------------------------------------------------------------------------");
        /*
        Cliente cl3 = new Cliente();
        cl3.read(118);
        System.out.println("ID " + cl3.getIdCliente() + " chama-se " + cl3.getNome() + " e mora em " + cl3.getMorada());

        cl3.setNome("Josefina d'Alenquer");
        cl3.setMorada("Praça da Liberdade");
        cl3.update();
        System.out.println("ID " + cl3.getIdCliente() + " chama-se " + cl3.getNome() + " e mora em " + cl3.getMorada());

        cl3.read(118);
        System.out.println("ID " + cl3.getIdCliente() + " chama-se " + cl3.getNome() + " e mora em " + cl3.getMorada());

        cl3.delete();
        */
    }
}
