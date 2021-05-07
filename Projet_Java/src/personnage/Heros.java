package personnage;

import affrontement.Combat;
import equipement.Arme;
import equipement.Armure;
import equipement.Potion;
import labyrinthe.java.Boutique;
import labyrinthe.java.Labyrinthe;
import vue.Clavier;

public class Heros extends EtreVivant {
	private String nom;
	private int vieMax;
	private Arme arme;
	private Armure armure;
	private int argent = 100000000;
	private int[] potion = new int[Potion.values().length];

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

	public void setArme(Arme arme) {
		this.arme = arme;
	}

	public Arme getArme() {
		return arme;
	}

	public void setArmure(Armure armure) {
		this.armure = armure;
	}

	public Armure getArmure() {
		return armure;
	}

	public int getArgent() {
		return argent;
	}

	public void setArgent(int argent) {
		this.argent = argent;
	}

	public int[] getPotion() {
		return potion;
	}

	/**
	 * nomme le heros
	 */
	public void nommerHeros() {
		System.out.println("Comment voulez vous appeler votre personnage ?");
		this.nom = Clavier.entrerClavierString();
		System.out.println("Bienvenue dans le labyrinthe " + getNom());
	}

	@Override
	public void attaquer(EtreVivant e) {
		int degat = this.degat;
		if (this.arme != null) {
			degat = degat + this.arme.getDegats();
		}
		System.out.println("\n" + this.getNom() + " attaque le monstre");

		e.setVie(e.getVie() - degat);
		if (e.getVie() <= 0) {
			System.out.println("Vous infligez " + degat + " pts de dégats" + "\nLe monstre meurt");
		} else {
			System.out.println("Vous infligez " + degat + " pts de dégats" + "\nLe monstre possède maintenant "
					+ e.getVie() + " point de vie");
		}

	}

	public void fuir(Labyrinthe lab) {
		System.out.println("Vous fuyez le combat, vous revennez à la pièce précédante");
		lab.setPosition(lab.getLastPosition());
	}

	public void mourir() {
		setVieMax(10);
		// equipement
	}

	public boolean seDeplacer() {
		Labyrinthe lab = new Labyrinthe();
		Combat combat = new Combat();
		Boutique boutique = new Boutique();
		int result = 0;
		while (result != 2) {
			System.out.println(
					"Quelle direction voulez-vous prendre ? \nEntrez N pour avancer, S pour reculer, E pour aller à droite, O pour aller à gauche !\n");
			String reponse = Clavier.entrerClavierString();
			switch (reponse.toUpperCase()) {
			case "N":
				if (lab.getPosition().getNord() != null) {
					lab.setLastPosition(lab.getPosition());
					lab.setPosition(lab.getPosition().getNord());
					System.out.println("Vous allez au nord\n");
					result = combat.battle(this);
					if (result == 0) {
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
					result = combat.battle(this);
					if (result == 0) {
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
					result = combat.battle(this);
					if (result == 0) {
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
					result = combat.battle(this);
					if (result == 0) {
						this.fuir(lab);
					}
				} else {
					System.out.println("Impossible d'aller dans cette direction");
				}
				break;

			default:
				System.out.println("Veuillez entrer les bon caractères.");
			}
			
			if(lab.getPosition() == lab.getBoutique() ) {
				System.out.println("Voulez-vous entrez dans la boutique ? oui ou non");
				String rep = Clavier.entrerClavierString();
				if (rep.equalsIgnoreCase("oui")) {
					boutique.acheter(this);
				}
			}

			if (lab.getPosition() == lab.getSortie()) {
				System.out.println("Vous avez gagné !");
				return false;
			}

		}
		mourir();
		return true;
	}

	public void sEquiper(Arme arme) {
		/*
		 * 
		 * System.out.println("Le soldat" + this.nom + "est déjà bien protégé");
		 * 
		 * 
		 * if(e.equals(equipements[0])) { System.out.println("Le soldat" + this.nom +
		 * "possède déjà " + e.toString() + "!"); } else { ajoutEquipement(e); }
		 * 
		 * ajoutEquipement(e);
		 */
	}
	/*
	 * private void ajoutEquipement(Equipement equipement) {
	 * equipements[nbEquipement] = equipement; System.out.println("Le soldat " +
	 * this.nom + " s'équipe avec un " + equipement.toString()); nbEquipement++; }
	 */

}
