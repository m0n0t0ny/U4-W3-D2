package AntonioBertuccio;

import AntonioBertuccio.entities.Evento;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.UUID;

public class EventoDAO {
  private final EntityManager em;

  public EventoDAO(EntityManager em) {
    this.em = em;
  }

  public void save(Evento evento) {
    EntityTransaction transaction = em.getTransaction();
    System.out.println("⚪ Initialising transaction.");
    transaction.begin();
    System.out.println("⚪ Adding new object to Persistence Context.");
    em.persist(evento);
    System.out.println("⚪ Writing on database.");
    transaction.commit();
    System.out.println("🟢 New data added.");
  }

  public Evento findById(UUID id) {
    return em.find(Evento.class, id);
  }

  public void findByIdAndDelete(UUID id) {
    Evento found = em.find(Evento.class, id);
    System.out.println("⚪ Searching object by id 🔎.");
    if (found != null) {
      EntityTransaction transaction = em.getTransaction();
      System.out.println("⚪ Initialising transaction 🔀.");
      transaction.begin();
      System.out.println("⚪ Adding new object to Persistence Context.");
      em.remove(found);
      System.out.println("⚪ Deleting object from database.");
      transaction.commit();
      System.out.println("🟢 Object deleted ❌.");
    } else {
      System.out.println("🔴 L'oggetto con uuid" + id + "non é stato trovato.");
    }
  }
}
