package cosimocrupi;

import cosimocrupi.dao.AttendancesDAO;
import cosimocrupi.dao.EventsDAO;
import cosimocrupi.dao.LocationsDAO;
import cosimocrupi.dao.PeopleDAO;
import cosimocrupi.entities.Attendance;
import cosimocrupi.entities.Event;
import cosimocrupi.entities.Location;
import cosimocrupi.entities.Persona;
import cosimocrupi.enums.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Random;

public class Application {
    private static final EntityManagerFactory emf= Persistence.createEntityManagerFactory("B-S3-L4");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        EventsDAO eventsDAO = new EventsDAO(em);
        LocationsDAO locationsDAO = new LocationsDAO(em);
        PeopleDAO peopleDAO = new PeopleDAO(em);
        AttendancesDAO attendancesDAO = new AttendancesDAO(em);
        Random rndm = new Random();
        LocalDate rndDay = LocalDate.now().plusDays(rndm.nextInt(30));

        // ******************** SALVATAGGIO LOCATIONS, UTENTI E EVENTI ************************

        Location location1= new Location("Gerry", "Roma");
        Location location2= new Location("Black panthers", "Milano");
        locationsDAO.save(location1);
        locationsDAO.save(location2);

        Persona person1 = new Persona("Cosimo", "crupi", "cosimo@libero.it", rndDay, 'M');
        Persona person2 = new Persona("Mike", "juice", "mike@libero.it", rndDay, 'M');
        peopleDAO.save(person1);
        peopleDAO.save(person2);

        Event e1= new Event("White party", rndDay, "costoso", TipoEvento.PRIVATO, 50, location1);
        Event e2= new Event("Black party", rndDay, "costoso", TipoEvento.PRIVATO, 40, location2);
        eventsDAO.save(e1);
        eventsDAO.save(e2);


        // ******************** PARTECIPAZIONE AD UN EVENTO ************************
        Persona person = peopleDAO.findById(person1.getId());
        Event event = eventsDAO.findById(e1.getId());

        Attendance partecipazione = new Attendance(person, event);
        attendancesDAO.save(partecipazione);

        //Stampo eventi a cui partecipa la persona person1
        person.getListaPartecipazioni().forEach(System.out::println);

        // Stampo elenco partecipanti evento 24
        event.getListaPartecipazioni().forEach(System.out::println);

        // ******************** CASCADING ************************

        // Eliminando un evento dovrebbe eliminare anche le partecipazioni ad esso collegate
        eventsDAO.findByIdAndDelete(24);


        em.close();
        emf.close();
    }
}
