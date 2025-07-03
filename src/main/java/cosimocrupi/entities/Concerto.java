package cosimocrupi.entities;

import cosimocrupi.enums.GenereConcerto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Concerto extends Event{
    @Id
    @GeneratedValue
    private long id;

    protected GenereConcerto genere;
    protected boolean inStriming;

    public Concerto(GenereConcerto genere, boolean inStriming){
        this.genere=genere;
        this.inStriming=inStriming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "id=" + id +
                ", genere=" + genere +
                ", inStriming=" + inStriming +
                '}';
    }

    @Override
    public long getId() {
        return id;
    }

    public GenereConcerto getGenere() {
        return genere;
    }

    public void setGenere(GenereConcerto genere) {
        this.genere = genere;
    }
    public boolean isInStriming(){
        return inStriming;
    }

    public void setInStriming(boolean inStriming) {
        this.inStriming = inStriming;
    }
}
