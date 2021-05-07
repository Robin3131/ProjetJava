package test;
import equipement.Arme;
import equipement.Armure;
import equipement.Potion;
import labyrinthe.java.Boutique;
import personnage.Heros;

public class testBoutique {
	public static void main(String[] args) {
		Heros h = new Heros();
		h.setArgent(1000);
		Boutique b = new Boutique();
		b.acheter(h);
}
}
