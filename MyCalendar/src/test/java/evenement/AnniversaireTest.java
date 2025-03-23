package evenement;

import fr.matheo_pedron.evenement.Anniversaire;
import fr.matheo_pedron.objet.Periode;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnniversaireTest {
	@Test
	void anniversaire_zero_jour() {
		Periode periode1 = new Periode(LocalDateTime.of(2025, 3, 2, 0, 0), 60*24);
		Periode periode2 = new Periode(LocalDateTime.of(2025, 3, 1, 0, 0), 60*24*2);
		Anniversaire anniversaire = new Anniversaire(null, null, periode1, null);

		assertTrue(anniversaire.evenementDansPeriode(periode2));
	}

	@Test
	void anniversaire_un_an() {
		Periode periode1 = new Periode(LocalDateTime.of(2025, 3, 2, 0, 0), 60*24);
		Periode periode2 = new Periode(LocalDateTime.of(2026, 3, 1, 0, 0), 60*24*2);
		Anniversaire anniversaire = new Anniversaire(null, null, periode1, null);

		assertTrue(anniversaire.evenementDansPeriode(periode2));
	}

	@Test
	void anniversaire_moins_un_an() {
		Periode periode1 = new Periode(LocalDateTime.of(2025, 3, 2, 0, 0), 60*24);
		Periode periode2 = new Periode(LocalDateTime.of(2024, 3, 1, 0, 0), 60*24*2);
		Anniversaire anniversaire = new Anniversaire(null, null, periode1, null);

		assertFalse(anniversaire.evenementDansPeriode(periode2));
	}
}
