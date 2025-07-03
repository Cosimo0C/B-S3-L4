package cosimocrupi.dao;

import cosimocrupi.entities.GaraDiAtletica;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class GaraDiAtleticaDAO {
    private EntityManager em;

    public GaraDiAtleticaDAO( EntityManager em){
        this.em=em;
    }

    public void save( GaraDiAtletica garaDiAtletica){
        EntityTransaction t= em.getTransaction();
        t.begin();
        em.persist(garaDiAtletica);
        t.commit();
        System.out.println("Gara di atletica - " + garaDiAtletica.getTitolo() + " - creato!");
    }
}
