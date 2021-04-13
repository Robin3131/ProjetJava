package personnage;

import vue.Clavier;

public class Heros extends EtreVivant {
	String nom;

	public Heros() {
		super(10, 1);

	}

	public String getNom() {
		return nom;
	}

	public void nommerHeros() {
		System.out.println("Comment vouslez vous appeler votre personnage ?");
		this.nom = Clavier.entrerClavierString();
		System.out.println("Bienvenue dans le labyrinthe " + getNom());
	}

	@Override
	public void attaquer(EtreVivant e) {
		//if(this.equipement.....)
		e.subirAttaque(degat);
	}
}
