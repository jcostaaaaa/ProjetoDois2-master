package com.example.projetodois.JPABLL;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;
import com.example.projetodois.DAL.ClientesEntity;
//import com.example.projetodois.JPABLL.exceptions.IllegalOrphanException;
//import com.example.projetodois.JPABLL.exceptions.NonexistentEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author miguel
 */
public class ClienteJpaController implements Serializable {

    public ClienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ClientesEntity cliente) {
        if (cliente.getAluguerList() == null) {
            cliente.setAluguerList(new ArrayList<Aluguer>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Aluguer> attachedAluguerList = new ArrayList<Aluguer>();
            for (Aluguer aluguerListAluguerToAttach : cliente.getAluguerList()) {
                aluguerListAluguerToAttach = em.getReference(aluguerListAluguerToAttach.getClass(), aluguerListAluguerToAttach.getIdaluguer());
                attachedAluguerList.add(aluguerListAluguerToAttach);
            }
            cliente.setAluguerList(attachedAluguerList);
            em.persist(cliente);
            for (Aluguer aluguerListAluguer : cliente.getAluguerList()) {
                Cliente oldClienteOfAluguerListAluguer = aluguerListAluguer.getCliente();
                aluguerListAluguer.setCliente(cliente);
                aluguerListAluguer = em.merge(aluguerListAluguer);
                if (oldClienteOfAluguerListAluguer != null) {
                    oldClienteOfAluguerListAluguer.getAluguerList().remove(aluguerListAluguer);
                    oldClienteOfAluguerListAluguer = em.merge(oldClienteOfAluguerListAluguer);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ClientesEntity cliente) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente persistentCliente = em.find(Cliente.class, cliente.getIdcliente());
            List<Aluguer> aluguerListOld = persistentCliente.getAluguerList();
            List<Aluguer> aluguerListNew = cliente.getAluguerList();
            List<String> illegalOrphanMessages = null;
            for (Aluguer aluguerListOldAluguer : aluguerListOld) {
                if (!aluguerListNew.contains(aluguerListOldAluguer)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Aluguer " + aluguerListOldAluguer + " since its cliente field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Aluguer> attachedAluguerListNew = new ArrayList<Aluguer>();
            for (Aluguer aluguerListNewAluguerToAttach : aluguerListNew) {
                aluguerListNewAluguerToAttach = em.getReference(aluguerListNewAluguerToAttach.getClass(), aluguerListNewAluguerToAttach.getIdaluguer());
                attachedAluguerListNew.add(aluguerListNewAluguerToAttach);
            }
            aluguerListNew = attachedAluguerListNew;
            cliente.setAluguerList(aluguerListNew);
            cliente = em.merge(cliente);
            for (Aluguer aluguerListNewAluguer : aluguerListNew) {
                if (!aluguerListOld.contains(aluguerListNewAluguer)) {
                    Cliente oldClienteOfAluguerListNewAluguer = aluguerListNewAluguer.getCliente();
                    aluguerListNewAluguer.setCliente(cliente);
                    aluguerListNewAluguer = em.merge(aluguerListNewAluguer);
                    if (oldClienteOfAluguerListNewAluguer != null && !oldClienteOfAluguerListNewAluguer.equals(cliente)) {
                        oldClienteOfAluguerListNewAluguer.getAluguerList().remove(aluguerListNewAluguer);
                        oldClienteOfAluguerListNewAluguer = em.merge(oldClienteOfAluguerListNewAluguer);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cliente.getIdcliente();
                if (findCliente(id) == null) {
                    throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente cliente;
            try {
                cliente = em.getReference(Cliente.class, id);
                cliente.getIdcliente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Aluguer> aluguerListOrphanCheck = cliente.getAluguerList();
            for (Aluguer aluguerListOrphanCheckAluguer : aluguerListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Cliente (" + cliente + ") cannot be destroyed since the Aluguer " + aluguerListOrphanCheckAluguer + " in its aluguerList field has a non-nullable cliente field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(cliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cliente> findClienteEntities() {
        return findClienteEntities(true, -1, -1);
    }

    public List<Cliente> findClienteEntities(int maxResults, int firstResult) {
        return findClienteEntities(false, maxResults, firstResult);
    }

    private List<Cliente> findClienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cliente.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Cliente findCliente(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cliente.class, id);
        } finally {
            em.close();
        }
    }

    public int getClienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cliente> rt = cq.from(Cliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
