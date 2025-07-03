package cosimocrupi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "Gara di Atletica")
public class GaraDiAtletica extends Event {
    @Id
    @GeneratedValue
    private long id;
    Persona setAtleti;
    Persona vincitori;

   public GaraDiAtletica(Persona setAtleti, Persona vincitori){
       this.setAtleti=setAtleti;
       this.vincitori=vincitori;
   }

    @Override
    public String toString() {
        return "GaraDiAtletica{" +
                "id=" + id +
                ", setAtleti=" + setAtleti +
                ", vincitori=" + vincitori +
                '}';
    }

    @Override
    public long getId() {
        return id;
    }

    public Persona getSetAtleti() {
        return setAtleti;
    }

    public void setSetAtleti(Persona setAtleti) {
        this.setAtleti = setAtleti;
    }

    public Persona getVincitori() {
        return vincitori;
    }

    public void setVincitori(Persona vincitori) {
        this.vincitori = vincitori;
    }
}
