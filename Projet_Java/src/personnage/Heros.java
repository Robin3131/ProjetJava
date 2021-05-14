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
	private int argent = 0;
	private int[] potion = new int[Potion.values().length];

	/**Cr�� un h�ros (10 pv, 1 d'attaque)
	 */
	public Heros() {
		super(10, 1);
		this.vieMax = vie;
	}
	
	/**Fonction qui retourne le nom du h�ros
	 * @return String
	 */
	public String getNom() {
		return nom;
	}
	
	/**Fonction qui retourne les pv max du h�ros
	 * @return int
	 */
	public int getVieMax() {
		return vieMax;
	}

	/**Fonction qui modifie les pv max du heros
	 * @param vieMax (int)
	 */
	public void setVieMax(int vieMax) {
		this.vieMax = vieMax;
		this.setVie(vieMax);
	}

	/**Fonction qui attribue une arme au heros
	 * @param arme objet de type Arme
	 */
	public void setArme(Arme arme) {
		this.arme = arme;
	}

	/**Fonction qui retourne l'arme du h�ros
	 * @return objet de type Arme
	 */
	public Arme getArme() {
		return arme;
	}
	
	/**Fonction qui attribue une armure au heros
	 * @param armure objet de type Armure
	 */
	public void setArmure(Armure armure) {
		this.armure = armure;
	}

	/**Fonction qui retourne l'armure du h�ros
	 * @return objet de type Armure
	 */
	public Armure getArmure() {
		return armure;
	}
	
	/**Fonction qui retourne l'argent poss�d� par le heros
	 * @return int
	 */
	public int getArgent() {
		return argent;
	}

	/**Fonction qui modifie la quantit� d'argent poss�d� par le heros
	 * @param argent (int)
	 */
	public void setArgent(int argent) {
		this.argent = argent;
	}

	/**Fonction qui retourne le nombre de potions poss�d�es pas le h�ros
	 * @return int
	 */
	public int[] getPotion() {
		return potion;
	}

	/**Fonction pour nommer le heros 
	 */
	public void nommerHeros() {
		System.out.println("Comment voulez vous appeler votre personnage ?");
		this.nom = Clavier.entrerClavierString();
		System.out.println("Bienvenue dans le labyrinthe " + getNom());
	}
	
	/**Fonction qui inflige des d�gats � l'�tre vivant pass� en param�tre en fonction de l'arme du h�ros
	 * @param e , �tre vivant cible de l'attaque
	 */
	@Override
	public void attaquer(EtreVivant e) {
		int degat = this.degat;
		if (this.arme != null) {//si le h�ros a une arme
			degat = degat + this.arme.getDegats();
		}
		System.out.println("\n" + this.getNom() + " attaque le monstre");

		e.setVie(e.getVie() - degat);
		if (e.getVie() <= 0) {//si le monstre est mort
			System.out.println("Vous infligez " + degat + " pts de d�gats" + "\nLe monstre meurt");
		} else {
			System.out.println("Vous infligez " + degat + " pts de d�gats" + "\nLe monstre poss�de maintenant "
					+ e.getVie() + " point de vie");
		}

	}
	/**Fonction qui permet au heros de revenir � son ancienne position
	 * @param lab (de type labyrinthe)
	 */
	public void fuir(Labyrinthe lab) {
		System.out.println("Vous fuyez le combat, vous revennez � la pi�ce pr�c�dante");
		lab.setPosition(lab.getLastPosition());
	}

	/**Fonction qui r�initialise les points de vie maximums du h�ros lorsqu'il meurt
	 */
	public void mourir() {
		setVieMax(10);
	}
	/**Fonction qui permet au h�ros de se d�placer dans le labyrinthe
	 * @return FALSE si le h�ros sort du labyrinthe sans mourir ou TRUE si le h�ros meurt
	 */
	public boolean seDeplacer() {
		Labyrinthe lab = new Labyrinthe();
		Combat combat = new Combat();
		Boutique boutique = new Boutique();
		int result = 0;
		while (result != 2) {// tant que le h�ros n'est pas mort (result = 2)
			System.out.println(
					"Quelle direction voulez-vous prendre ? \nEntrez N pour avancer, S pour reculer, E pour aller � droite, O pour aller � gauche !\n");
			String reponse = Clavier.entrerClavierString();
			switch (reponse.toUpperCase()) {
			case "N":
				if (lab.getPosition().getNord() != null) {//Si un chemin vers le nord existe
					lab.setLastPosition(lab.getPosition());//Atualisation de l'ancienne position
					lab.setPosition(lab.getPosition().getNord());//D�placement vers le nord
					System.out.println("Vous allez au nord\n");
					//Cr�ation d'un combat quand le heros rentre dans la salle et r�cup�ration du r�sultat du combat
					result = combat.battle(this, lab.pieceBoss());
					if (result == 0) {//Si le heros a fuit le combat
						this.fuir(lab);
					}
				} else {//Pas de chemin dans cette direction
					System.out.println("Impossible d'aller dans cette direction");
				}
				break;
			case "S":
				if (lab.getPosition().getSud() != null) {
					lab.setLastPosition(lab.getPosition());
					lab.setPosition(lab.getPosition().getSud());
					System.out.println("Vous allez vers le sud\n");
					result = combat.battle(this, lab.pieceBoss());
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
					System.out.println("Vous allez � l'ouest\n");
					result = combat.battle(this, lab.pieceBoss());
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
					System.out.println("Vous allez � l'est\n");
					result = combat.battle(this, lab.pieceBoss());
					if (result == 0) {
						this.fuir(lab);
					}
				} else {
					System.out.println("Impossible d'aller dans cette direction");
				}
				break;

			default://choix de direction incorrect
				System.out.println("Veuillez entrer les bon caract�res.");
			}
			if (this.getVie() > 0) {//Si le h�ros est en vie
				//si le h�ros est � l'entr�e du labyrinthe il peut acc�der � la boutique
				if (lab.getPosition() == lab.getBoutique()) {
					System.out.println("Voulez-vous entrez dans la boutique ? oui ou non");
					String rep = Clavier.entrerClavierString();
					if (rep.equalsIgnoreCase("oui")) {
						boutique.acheter(this);
					}
				}
				//si le h�ros est � la sortie du labyrinthe il a gagn�
				if (lab.getPosition() == lab.getSortie()) {
					System.out.println("Vous avez gagn� !");
					return false;
				}
			}

		}
		mourir();
		return true;
	}

}
