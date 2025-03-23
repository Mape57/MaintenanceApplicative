package application;

import evenement.Periodique;
import evenement.RdvPersonnel;
import objet.Frequence;
import objet.Periode;
import objet.Personne;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CalendarManagerTest {
	@Test
	void pas_d_evenement() {
		CalendarManager calendarManager = new CalendarManager();
		Periode periode = new Periode(LocalDateTime.of(2021, 1, 1, 0, 0), 60);
		assertTrue(calendarManager.eventsDansPeriode(periode).getAll().isEmpty());
	}

	@Test
	void jour_different() {
		CalendarManager calendarManager = new CalendarManager();
		Periode periode1 = new Periode(LocalDateTime.of(2021, 1, 2, 0, 0), 60);
		Periode periode2 = new Periode(LocalDateTime.of(2021, 1, 1, 0, 0), 60);
		RdvPersonnel rdvPersonnel = new RdvPersonnel(null, null, periode1);
		calendarManager.ajouterEvent(rdvPersonnel);
		assertTrue(calendarManager.eventsDansPeriode(periode2).getAll().isEmpty());
	}

	@Test
	void heure_different() {
		CalendarManager calendarManager = new CalendarManager();
		Periode periode1 = new Periode(LocalDateTime.of(2021, 1, 1, 1, 1), 60);
		Periode periode2 = new Periode(LocalDateTime.of(2021, 1, 1, 0, 0), 60);
		RdvPersonnel rdvPersonnel = new RdvPersonnel(null, null, periode1);
		calendarManager.ajouterEvent(rdvPersonnel);
		assertTrue(calendarManager.eventsDansPeriode(periode2).getAll().isEmpty());
	}

	@Test
	void heure_debut_egale() {
		CalendarManager calendarManager = new CalendarManager();
		Periode periode1 = new Periode(LocalDateTime.of(2021, 1, 1, 0, 0), 60);
		Periode periode2 = new Periode(LocalDateTime.of(2021, 1, 1, 0, 0), 60);
		RdvPersonnel rdvPersonnel = new RdvPersonnel(null, null, periode1);
		calendarManager.ajouterEvent(rdvPersonnel);
		assertTrue(calendarManager.eventsDansPeriode(periode2).getAll().contains(rdvPersonnel));
	}

	@Test
	void heure_fin_egale() {
		CalendarManager calendarManager = new CalendarManager();
		Periode periode1 = new Periode(LocalDateTime.of(2021, 1, 1, 0, 0), 60);
		Periode periode2 = new Periode(LocalDateTime.of(2021, 1, 1, 0, 0), 60);
		RdvPersonnel rdvPersonnel = new RdvPersonnel(null, null, periode1);
		calendarManager.ajouterEvent(rdvPersonnel);
		assertTrue(calendarManager.eventsDansPeriode(periode2).getAll().contains(rdvPersonnel));
	}

	@Test
	void heure_dans_periode() {
		CalendarManager calendarManager = new CalendarManager();
		Periode periode1 = new Periode(LocalDateTime.of(2021, 1, 1, 0, 30), 60);
		Periode periode2 = new Periode(LocalDateTime.of(2021, 1, 1, 0, 0), 60);
		RdvPersonnel rdvPersonnel = new RdvPersonnel(null, null, periode1);
		calendarManager.ajouterEvent(rdvPersonnel);
		assertTrue(calendarManager.eventsDansPeriode(periode2).getAll().contains(rdvPersonnel));
	}

	@Test
	void periodique_est_dans_periode() {
		CalendarManager calendarManager = new CalendarManager();
		Periode periode1 = new Periode(LocalDateTime.of(2021, 1, 1, 0, 0), 60);
		Periode periode2 = new Periode(LocalDateTime.of(2021, 1, 5, 0, 0), 60);
		Periodique periodique = new Periodique(null, null, periode1, new Frequence(4));
		calendarManager.ajouterEvent(periodique);
		assertTrue(calendarManager.eventsDansPeriode(periode2).getAll().contains(periodique));
	}

	@Test
	void periodique_pas_dans_periode() {
		CalendarManager calendarManager = new CalendarManager();
		Periode periode1 = new Periode(LocalDateTime.of(2021, 1, 1, 0, 0), 60);
		Periode periode2 = new Periode(LocalDateTime.of(2021, 1, 6, 0, 0), 60);
		Periodique periodique = new Periodique(null, null, periode1, new Frequence(4));
		calendarManager.ajouterEvent(periodique);
		assertTrue(calendarManager.eventsDansPeriode(periode2).getAll().isEmpty());
	}
}