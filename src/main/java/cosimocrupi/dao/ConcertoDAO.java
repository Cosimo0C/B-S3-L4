package cosimocrupi.dao;

import cosimocrupi.entities.Concerto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ConcertoDAO {
    private EntityManager em;

    public ConcertoDAO(EntityManager em){
        this.em=em;
    }

    public void save(Concerto concerto){
        EntityTransaction t= em.getTransaction();
        t.begin();
        em.persist(concerto);
        t.commit();
        System.out.println("Concerto - " + concerto.getTitolo() + " - creato!");
    }
}
