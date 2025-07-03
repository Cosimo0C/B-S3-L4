package cosimocrupi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="Partita di calcio")
public class PartitaDiCalcio extends Event{
    @Id
    @GeneratedValue
    private long id;
    protected String squadraCasa;
    protected String squadraOspite;
    protected String vincente;
    protected int golCasa;
    protected int golOspite;

 public PartitaDiCalcio(String squadraCasa, String squadraOspite, String vincente, int golCasa, int golOspite){
     this.squadraCasa=squadraCasa;
     this.squadraOspite=squadraOspite;
     this.vincente=vincente;
     this.golCasa=golCasa;
     this.golOspite=golOspite;
 }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "squadraCasa='" + squadraCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", vincente='" + vincente + '\'' +
                ", golCasa=" + golCasa +
                ", golOspite=" + golOspite +
                '}';
    }

    @Override
    public long getId() {
        return id;
    }

    public String getSquadraCasa() {
        return squadraCasa;
    }
    public void setSquadraCasa(String squadraCasa) {
        this.squadraCasa = squadraCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }
    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getVincente() {
        String risultato = "";
        if (getGolCasa() > getGolOspite()) {
            risultato = "Vincente squadra di casa!";
        } else if (getGolOspite() > getGolCasa()) {
            risultato = "Vincente squadra ospite!";
        } else if (getGolCasa() == getGolOspite()) {
            return null;
        }
        return risultato;
    }

    public int getGolCasa() {
        return golCasa;
    }
    public void setGolCasa(int golCasa) {
        this.golCasa = golCasa;
    }

    public int getGolOspite() {
        return golOspite;
    }
    public void setGolOspite(int golOspite) {
        this.golOspite = golOspite;
    }
}
