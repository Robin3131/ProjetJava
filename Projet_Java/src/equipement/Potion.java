package equipement;

public enum Potion {
	PPOTION("petite potion", 5, 200), POTION("potion", 7, 400), SPOTION("super potion", 10, 800);

	private String nom;
	private int regen;
	private int prix;

	private Potion(String nom, int regen, int prix) {
		this.nom = nom;
		this.regen = regen;
		this.prix = prix;
	}

	public String getNom() {
		return nom;
	}

	public int getRegen() {
		return regen;
	}
	
	public int getPrix() {
		return prix;
	}

}
