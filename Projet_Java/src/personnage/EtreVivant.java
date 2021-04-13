package personnage;

public abstract class EtreVivant {
	protected int vie;
	protected int degat;
	
	public EtreVivant(int vie, int degat) {
		this.vie = vie;
		this.degat = degat;
		degat = 1;

	}
	public abstract void attaquer (EtreVivant e);
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
