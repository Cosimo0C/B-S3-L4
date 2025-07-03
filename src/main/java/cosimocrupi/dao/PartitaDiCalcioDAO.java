package cosimocrupi.dao;

import cosimocrupi.entities.PartitaDiCalcio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PartitaDiCalcioDAO {
    private EntityManager em;
    public PartitaDiCalcioDAO(EntityManager em){
        this.em=em;
    }
    public void save(PartitaDiCalcio partitaDiCalcio){
        EntityTransaction t= em.getTransaction();
        t.begin();
        em.persist(partitaDiCalcio);
        t.commit();
        System.out.println("Partita di Calcio - " + partitaDiCalcio.getTitolo() + " - creato!");
    }
}

