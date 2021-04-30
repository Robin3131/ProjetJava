package personnage;

public enum Arme {
	ARMEB("bois"),
	ARMEF("fer"),
	ARMEO("or"),
	ARMES("saphir"),
	ARMER("rubis"),
	ARMED("diamant");
	private String nom;
	Arme(String nom){
		this.nom = nom;
	}
}
