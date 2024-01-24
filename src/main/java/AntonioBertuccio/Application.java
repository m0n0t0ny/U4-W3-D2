package AntonioBertuccio;

import AntonioBertuccio.entities.Evento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.UUID;

public class Application {
  private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");

  public static void main(String[] args) {
    try {
      EntityManager em = emf.createEntityManager();
      EventoDAO db = new EventoDAO(em);

//      ---------- Save on DB 💾 ----------
//      Evento capodanno = new Evento("Capodanno", LocalDate.of(2023, 12, 31), "Festeggiamo insieme l'ultimo giorno del 2023 🎉", TipoEvento.PRIVATO, 255);
//      db.save(capodanno);

//      ---------- Search from DB 🔎 ----------
      UUID id = UUID.fromString("6a5b66fc-3561-4954-adcf-8cdfae0da3e5");
      Evento capodannoFromDB = db.findById(id);
      if (capodannoFromDB != null) {
        System.out.println(capodannoFromDB);
      }
      else {
        System.out.println("🔴 L'oggetto con uuid " + id + " non é stato trovato.");
      }

//      ---------- Find and Delete ❌ ----------
//      db.findByIdAndDelete(UUID.fromString("86644ea7-74dc-427f-b0e7-da55e1f72564"));

    } catch (Exception ex) {
      System.err.println(ex.getMessage());

    } finally {
      System.out.println("🟢 Entity manager (em) closed ❌.");
      emf.close();
      System.out.println("🟢 Entity manager factory (emf) closed ❌.");
      System.out.println("🟢 End of all processes from main.");
    }

  }
}
