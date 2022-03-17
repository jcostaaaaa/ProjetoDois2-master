package com.example.projetodois.BLL;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import com.example.projetodois.DAL.Clientes;

public class ClienteBLL {

    private  static final String PERSISTENCE_UNIT_NAME = "default";
        private static EntityManagerFactory factory = null;
        private static EntityManager em = null;

        public static void create(Clientes cli){
            if(factory == null)
                factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

            if (em == null) em = factory.createEntityManager();

            em.getTransaction().begin(); //iniciando a transação com bd
            em.persist(cli); //Persistindo os dados
            em.getTransaction().commit();//guardou
        }

        public static Clientes read(int idCliente){
            Clientes cli = null;
            if(factory == null)
                factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

            if (em == null) em = factory.createEntityManager();

            Query q1 = em.createNamedQuery("Clientes.findByIdcliente");
            q1.setParameter("id_cliente", idCliente);
            Object obj = q1.getSingleResult();

            if(obj != null){
                cli = ((Clientes)obj);
            }
            else
                return null;


            return cli;
        }

        public static List<Clientes> readAll(){
            List<Clientes> listaCli = new ArrayList<> ();
            if(factory == null)
                factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

            if (em == null) em = factory.createEntityManager();

            Query q1 = em.createNamedQuery("Clientes.findAll");
            List<Object> result = q1.getResultList();

            for(Object cli : result){
                listaCli.add((Clientes) cli);
            }

            return listaCli;
        }

        public static List<Clientes> readAll(String nome){
            List<Clientes> listaCli = new ArrayList<>();
            if(factory == null)
                factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

            if (em == null) em = factory.createEntityManager();

            Query q1 = em.createNamedQuery("Clientes.findAllByNome");
            q1.setParameter("nome", "%"+nome+"%");
            List<Object> result = q1.getResultList();

            for(Object cli : result){
                listaCli.add((Clientes) cli);
            }

            return listaCli;
        }

        public static void update(Clientes cli){
            if(factory == null)
                factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

            if (em == null) em = factory.createEntityManager();

            em.getTransaction().begin();
            em.merge(cli);
            em.getTransaction().commit();
        }

        public static void delete(Clientes cli){
            if(factory == null)
                factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

            if (em == null) em = factory.createEntityManager();

            em.getTransaction().begin();
            em.remove(cli);
            em.getTransaction().commit();
        }
    }







