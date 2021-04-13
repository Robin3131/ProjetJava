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
		System.out.println("Comment voulez vous appeler votre personnage ?");
		this.nom = Clavier.entrerClavierString();
		System.out.println("Bienvenue dans le labyrinthe " + getNom());
	}

	@Override
	public void attaquer(EtreVivant e) {
		//if(this.equipement.....)
		System.out.println("\n"+this.getNom()+" attaque le monstre" );
		e.subirAttaque(this.degat);		
	}
	public void subirAttaque(int dmg) {
		this.vie -=dmg;
		if(vie <= 0 ) {
			System.out.println("Vous mourez");
		}else
		{
			System.out.println("Vous subissez " + dmg + " pts de dégats");
		}
	}
	
}
