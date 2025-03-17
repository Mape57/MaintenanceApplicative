package src.evenement.valeur;

import java.time.LocalDateTime;

public class Periode {
	private LocalDateTime dateDebut;
	private LocalDateTime dateFin;

	public Periode(LocalDateTime dateDebut, LocalDateTime dateFin) {
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public Periode(LocalDateTime dateDebut, int dureeMinutes) {
		this(dateDebut, dateDebut.plusMinutes(dureeMinutes));
	}

	public LocalDateTime getDateDebut() {
		return dateDebut;
	}

	public LocalDateTime getDateFin() {
		return dateFin;
	}
}
