package personnage;

import vue.Clavier;

public class Heros {
String nom;

public Heros() {

}

public String getNom() {
	return nom;
}

public void nommerHeros() {
	System.out.println("Comment vouslez vous appeler votre personnage ?");
	this.nom = Clavier.entrerClavierString();
	System.out.println("Bienvenue dans le labyrinthe " + getNom() );
}

}
