package cosimocrupi.entities;

import cosimocrupi.enums.Stato;
import jakarta.persistence.*;

@Entity
@Table(name = "partecipazioni")
public class Attendance {
	@Id
	@GeneratedValue
	private long id;

	@ManyToOne
	@JoinColumn(name = "persona_id")
	private Persona persona;

	@ManyToOne
	@JoinColumn(name = "evento_id")
	private Event evento;
	@Enumerated(EnumType.STRING)
	private Stato stato;

	public Attendance() {
	}

	public Attendance(Persona persona, Event evento) {
		this.persona = persona;
		this.evento = evento;
		this.stato = Stato.DA_CONFERMARE;
	}

	public long getId() {
		return id;
	}


	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Event getEvento() {
		return evento;
	}

	public void setEvento(Event evento) {
		this.evento = evento;
	}

	public Stato getStato() {
		return stato;
	}

	public void setStato(Stato stato) {
		this.stato = stato;
	}

	@Override
	public String toString() {
		return "Partecipazione{" +
				"id=" + id +
				", persona=" + persona +
				", evento=" + evento +
				", stato=" + stato +
				'}';
	}
}
