package fr.matheo_pedron.objet;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record Periode(LocalDateTime dateDebut, LocalDateTime dateFin) {
	public Periode(LocalDateTime dateDebut, int dureeMinutes) {
		this(dateDebut, dateDebut.plusMinutes(dureeMinutes));
	}

	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		return "du " + dateDebut.format(formatter) + " au " + dateFin.format(formatter);
	}
}
