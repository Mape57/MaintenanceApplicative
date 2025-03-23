package application;

import fr.matheo_pedron.application.CalendarManager;
import fr.matheo_pedron.evenement.Anniversaire;
import fr.matheo_pedron.evenement.Periodique;
import fr.matheo_pedron.evenement.RdvPersonnel;
import fr.matheo_pedron.objet.Frequence;
import fr.matheo_pedron.objet.Periode;
import fr.matheo_pedron.objet.Personne;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CalendarManagerTest {
	// ======================== TEST EVENTS DANS PERIODE ======================== //
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

	// ======================== TEST CONFLIT ======================== //
	@Test
	void pas_de_conflit() {
		CalendarManager calendarManager = new CalendarManager();
		Periode periode1 = new Periode(LocalDateTime.of(2021, 1, 1, 0, 0), 60);
		Periode periode2 = new Periode(LocalDateTime.of(2021, 1, 2, 0, 0), 60);
		RdvPersonnel rdvPersonnel1 = new RdvPersonnel(null, null, periode1);
		RdvPersonnel rdvPersonnel2 = new RdvPersonnel(null, null, periode2);
		calendarManager.ajouterEvent(rdvPersonnel1);
		assertTrue(calendarManager.conflit(rdvPersonnel2).getAll().isEmpty());
	}

	@Test
	void conflit() {
		CalendarManager calendarManager = new CalendarManager();
		Periode periode1 = new Periode(LocalDateTime.of(2021, 1, 1, 0, 0), 60);
		Periode periode2 = new Periode(LocalDateTime.of(2021, 1, 1, 0, 30), 60);
		RdvPersonnel rdvPersonnel1 = new RdvPersonnel(null, null, periode1);
		RdvPersonnel rdvPersonnel2 = new RdvPersonnel(null, null, periode2);
		calendarManager.ajouterEvent(rdvPersonnel1);
		assertTrue(calendarManager.conflit(rdvPersonnel2).getAll().contains(rdvPersonnel1));
	}

	@Test
	void conflit_periodique() {
		CalendarManager calendarManager = new CalendarManager();
		Periode periode1 = new Periode(LocalDateTime.of(2021, 1, 5, 0, 0), 60);
		Periode periode2 = new Periode(LocalDateTime.of(2021, 1, 1, 0, 0), 60);
		RdvPersonnel rdvPersonnel = new RdvPersonnel(null, null, periode1);
		Periodique periodique = new Periodique(null, null, periode2, new Frequence(1));
		calendarManager.ajouterEvent(rdvPersonnel);
		assertTrue(calendarManager.conflit(periodique).getAll().contains(rdvPersonnel));
	}

	@Test
	void conflit_anniversaire() {
		CalendarManager calendarManager = new CalendarManager();
		Periode periode1 = new Periode(LocalDateTime.of(2021, 1, 1, 0, 0), 60);
		Periode periode2 = new Periode(LocalDateTime.of(2021, 1, 1, 0, 0), 60);
		RdvPersonnel rdvPersonnel = new RdvPersonnel(null, null, periode1);
		Anniversaire anniversaire = new Anniversaire(null, null, periode2, new Personne("test"));
		calendarManager.ajouterEvent(rdvPersonnel);
		assertTrue(calendarManager.conflit(anniversaire).getAll().isEmpty());
	}
}