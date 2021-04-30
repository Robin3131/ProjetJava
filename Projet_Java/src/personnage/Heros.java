package personnage;

import affrontement.Combat;
import labyrinthe.java.Labyrinthe;
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
		// if(this.equipement.....)
		System.out.println("\n" + this.getNom() + " attaque le monstre");
		e.subirAttaque(this.degat);
	}

	public void subirAttaque(int dmg) {
		this.vie -= dmg;
		this.setVie(this.vie);
		if (vie > 0) {
			System.out.println(
					"Vous subissez " + dmg + " pts de dégats \nIl vous reste " + this.getVie() + " point de vie");
		}
	}

	public void fuir(Labyrinthe lab) {
		System.out.println("Vous fuyez le combat, vous revennez à la pièce précédante");
		System.out.println("Position actuelle:"+lab.getPosition());
		lab.setPosition(lab.getLastPosition());
		System.out.println("Position actuelle:"+lab.getPosition());
	}
	
	public void mourir() {
		setVieMax(10);
		//equipement
	}
	
	
	public boolean seDeplacer() {
		Labyrinthe lab = new Labyrinthe();
		Combat combat = new Combat();
		int result=0;
		while (result!=2) {
			String txt = "Quelle direction voulez-vous prendre ?\n";
			txt += "Entrez N pour avancer, S pour reculer, E pour aller à droite, O pour aller à gauche !\n";
			System.out.println(txt);
			System.out.println(lab.getLastPosition());
			System.out.println(lab.getPosition());
			String reponse = Clavier.entrerClavierString();
			switch (reponse.toUpperCase()) {
			case "N":
				if (lab.getPosition().getNord() != null) {
					lab.setLastPosition(lab.getPosition());
					lab.setPosition(lab.getPosition().getNord());
					System.out.println("Vous allez au nord\n");
					result=combat.battle(this);
					if(result==0) {
						this.fuir(lab);
					}
				} else {
					System.out.println("Impossible d'aller dans cette direction");
				}
				break;
			case "S":
				if (lab.getPosition().getSud() != null) {
					lab.setLastPosition(lab.getPosition());
					lab.setPosition(lab.getPosition().getSud());
					System.out.println("Vous allez vers le sud\n");
					result=combat.battle(this);
					if(result==0) {
						this.fuir(lab);
					}
				} else {
					System.out.println("Impossible d'aller dans cette direction");
				}
				break;

			case "O":
				if (lab.getPosition().getOuest() != null) {
					lab.setLastPosition(lab.getPosition());
					lab.setPosition(lab.getPosition().getOuest());
					System.out.println("Vous allez à l'ouest\n");
					result=combat.battle(this);
					if(result==0) {
						this.fuir(lab);
					}
				} else {
					System.out.println("Impossible d'aller dans cette direction");
				}
				break;

			case "E":
				if (lab.getPosition().getEst() != null) {
					lab.setLastPosition(lab.getPosition());
					lab.setPosition(lab.getPosition().getEst());
					System.out.println("Vous allez à l'est\n");
					result=combat.battle(this);
					if(result==0) {
						this.fuir(lab);
					}
				} else {
					System.out.println("Impossible d'aller dans cette direction");
				}
				break;

			default:
				System.out.println("Veuillez entrer les bon caractères.");
			}

			if (lab.getPosition() == lab.getSortie()) {
				System.out.println("Vous avez gagné !");
				return false;
			}
			
		}
		mourir();
		return true;
	}

}
