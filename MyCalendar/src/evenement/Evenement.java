package src.evenement;

import src.evenement.valeur.Personne;
import src.evenement.valeur.Periode;
import src.evenement.valeur.Titre;

public abstract class Evenement {
    protected Titre titre;
    protected Personne proprietaire;
    protected Periode periode;

    public Evenement(Titre titre, Personne proprietaire, Periode periode) {
        this.titre = titre;
        this.proprietaire = proprietaire;
        this.periode = periode;
    }

    public abstract String description();

    public Titre getTitre() {
        return titre;
    }

    public Personne getProprietaire() {
        return proprietaire;
    }

    public Periode getPeriode() {
        return periode;
    }
}