package personnage;

import vue.Clavier;

public class Heros extends EtreVivant {
	String nom;
	int vieMax;

	public Heros() {
		super(10, 1);
		this.vieMax = vie;
	}

	public String getNom() {
		return nom;
	}
	
	public int getVieMax() {
		return vieMax;
	}
	
	public void setVieMax(int vieMax) {
		this.vieMax = vieMax;
		this.setVie(vieMax);
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
		this.setVie(this.vie);
		if(vie > 0 ) {
			System.out.println("Vous subissez " + dmg + " pts de d�gats \nIl vous reste " + this.getVie() +" point de vie");
		}
	}
	
}
