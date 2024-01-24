package AntonioBertuccio.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "Eventi")
public class Evento {

  @Id
  @GeneratedValue
  private UUID id;
  @Column(name = "title")
  private String title;
  @Column(name = "data_evento")
  private LocalDate dataEvento;
  @Column(name = "descrizione")
  private String descrizione;
  @Column(name = "evento")
  private TipoEvento evento;
  @Column(name = "numero_massimo_partecipanti")
  private int numeroMassimoPartecipanti;

  public Evento(){}

  public Evento(String title, LocalDate dataEvento, String descrizione, TipoEvento evento, int numeroMassimoPartecipanti) {
    this.title = title;
    this.dataEvento = dataEvento;
    this.descrizione = descrizione;
    this.evento = evento;
    this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
  }

  public UUID getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public LocalDate getDataEvento() {
    return dataEvento;
  }

  public void setDataEvento(LocalDate dataEvento) {
    this.dataEvento = dataEvento;
  }

  public TipoEvento getEvento() {
    return evento;
  }

  public void setEvento(TipoEvento evento) {
    this.evento = evento;
  }

  public String getDescrizione() {
    return descrizione;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  public int getNumeroMassimoPartecipanti() {
    return numeroMassimoPartecipanti;
  }

  public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
    this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
  }

  @Override
  public String toString() {
    return "Evento{" +
            "title='" + title + '\'' +
            ", dataEvento=" + dataEvento +
            ", descrizione='" + descrizione + '\'' +
            ", evento=" + evento +
            ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
            '}';
  }
}
