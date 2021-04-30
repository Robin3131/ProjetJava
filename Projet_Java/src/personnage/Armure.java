package personnage;

public enum Armure {
	ARMUREC("cuir"),
	ARMUREF("fer"),
	ARMUREO("or"),
	ARMURES("saphir"),
	ARMURER("rubis"),
	ARMURED("diamant");
	private String nom;
	Armure(String nom){
		this.nom = nom;
	}
}
