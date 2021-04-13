package personnage;

public class Monstre extends EtreVivant {

	public Monstre() {
		super(5, 1);

	}
	public void attaquer(EtreVivant e) {
		System.out.println("\nLe monstre vous attaque" );
		e.subirAttaque(degat);
	}
	public void subirAttaque(int dmg) {
		this.vie -=dmg;
		if(vie <= 0 ) {
			System.out.println("Le monstre meurt");
		}else
		{
			System.out.println("Vous infligez " + dmg + " pts de dégats");
		}
	}
	
}
