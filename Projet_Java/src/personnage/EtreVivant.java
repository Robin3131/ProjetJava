package personnage;

public abstract class EtreVivant {
	protected int vie;
	protected int degat;
	
	public EtreVivant(int vie, int degat) {
		this.vie = vie;
		this.degat = degat;
		degat = 1;

	}
	public int getVie() {
		return vie;
	}
	public abstract void attaquer (EtreVivant e);
	public abstract void subirAttaque(int dmg);
}
