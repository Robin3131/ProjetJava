package test;

import affrontement.Combat;
//import labyrinthe.java.Labyrinthe;
import personnage.Heros;
import personnage.Monstre;
import vue.Clavier;

public class Test_combat {
	public static void main(String[] args) {
		Heros mec = new Heros();
		mec.nommerHeros();
		//combat commence
		Combat testC = new Combat();
		
		Monstre monstr = new Monstre();
		boolean fuir;
		fuir = false;
		
		while(!fuir) {
			// voulez vous fuir ?
			System.out.println("\n\nVoulez-vous fuir le combat ?\nEntrer 1 pour fuir sinon appuyer sur 0\n");
			int temp = Clavier.entrerClavierInt();
			if(temp == 1) {
				fuir=true;
			}
			System.out.println("Vous ne fuyez pas");
			int num = testC.choixAttaquant();
			if(num== 1) {
				mec.attaquer(monstr);
			}else {
				monstr.attaquer(mec);
			}
		}
		
}
}