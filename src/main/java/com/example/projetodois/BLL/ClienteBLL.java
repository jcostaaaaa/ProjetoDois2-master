package com.example.projetodois.BLL;

import com.example.projetodois.DAL.ClientesEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ClienteBLL {

    private  static final String PERSISTENCE_UNIT_NAME = "com.example.projetodois";
        private static EntityManagerFactory factory = null;
        private static EntityManager em = null;

        public static void create(ClientesEntity cli){
            if(factory == null)
                factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

            if (em == null) em = factory.createEntityManager();

            em.getTransaction().begin(); //iniciando a transação com bd
            em.persist(cli); //Persistindo os dados
            em.getTransaction().commit();//guardou
        }

        public static ClientesEntity read(int idCliente){
            ClientesEntity cli = null;
            if(factory == null)
                factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

            if (em == null) em = factory.createEntityManager();

            Query q1 = em.createNamedQuery("Clientes.findByIdcliente");
            q1.setParameter("id_cliente", idCliente);
            Object obj = q1.getSingleResult();

            if(obj != null){
                cli = ((ClientesEntity)obj);
            }
            else
                return null;


            return cli;
        }

        public static List<ClientesEntity> readAll(){
            List<ClientesEntity> listaCli = new ArrayList<> ();
            if(factory == null)
                factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

            if (em == null) em = factory.createEntityManager();

            Query q1 = em.createNamedQuery("Clientes.findAll");
            List<Object> result = q1.getResultList();

            for(Object cli : result){
                listaCli.add((ClientesEntity) cli);
            }

            return listaCli;
        }

        public static List<ClientesEntity> readAll(String nome){
            List<ClientesEntity> listaCli = new ArrayList<>();
            if(factory == null)
                factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

            if (em == null) em = factory.createEntityManager();

            Query q1 = em.createNamedQuery("Clientes.findAllByNome");
            q1.setParameter("nome", "%"+nome+"%");
            List<Object> result = q1.getResultList();

            for(Object cli : result){
                listaCli.add((ClientesEntity) cli);
            }

            return listaCli;
        }

        public static void update(ClientesEntity cli){
            if(factory == null)
                factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

            if (em == null) em = factory.createEntityManager();

            em.getTransaction().begin();
            em.merge(cli);
            em.getTransaction().commit();
        }

        public static void delete(ClientesEntity cli){
            if(factory == null)
                factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

            if (em == null) em = factory.createEntityManager();

            em.getTransaction().begin();
            em.remove(cli);
            em.getTransaction().commit();
        }
    }







