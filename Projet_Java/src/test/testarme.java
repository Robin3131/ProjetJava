package test;

import equipement.Arme;

public class testarme {
	public static void main(String[] args) {
		Arme arme = Arme.ARMEB;
		Arme armesuperieure = arme.getArmeSup().getArmeSup();
		System.out.println(arme);
		System.out.println(armesuperieure);
		
	}
}
