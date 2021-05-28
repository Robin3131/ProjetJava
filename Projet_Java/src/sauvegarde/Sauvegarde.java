package sauvegarde;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import equipement.Arme;
import equipement.Armure;
import labyrinthe.java.Labyrinthe;
import labyrinthe.java.Piece;
import personnage.Heros;

public class Sauvegarde {
	private static int pos;
	private static int pvmax;
	private static String nom;
	private static Armure armure;
	private static Arme arme;
	private static int argent;
	private static int[] potion;
	private static int superpotion;
	public static int sauvegardejeu(Labyrinthe lab,Heros heros) {
      try {
         
         // Création d'un nouveau flux qui crée un fichier binaire
         FileOutputStream sortie = new FileOutputStream("fichier.bin");
         ObjectOutputStream sortie2 = new ObjectOutputStream(sortie);
         //sortie.close();
         //FileOutputStream sortie = new FileOutputStream("fichier.bin",true);
         
		 pos=lab.getPosition().getId();
		 pvmax=heros.getVieMax();
		 nom=heros.getNom();
		 arme=heros.getArme();
		 argent=heros.getArgent();
		 armure=heros.getArmure();
		 potion=heros.getPotion();

		 
		sortie2.writeObject(pvmax);
		sortie2.writeObject(argent);
		sortie2.writeObject(potion);
		sortie2.writeObject(arme);
		sortie2.writeObject(armure);
		sortie2.writeObject(pos);
		sortie2.writeObject(nom);
		sortie2.close();
		sortie.close();
      	}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      return 3;
   }
	public static String recupSauvegarde(Labyrinthe lab,Heros heros) {
	      try {
	         
	         // Création d'un nouveau flux qui lit un fichier binaire
	    	 FileInputStream entree = new FileInputStream("fichier.bin");
	         ObjectInputStream entree2 = new ObjectInputStream(entree);
	         
	         //récupération des informations contenues dans le fichier
	         try {

	        	pvmax=(int)entree2.readObject();
	        	argent=(int)entree2.readObject();
	        	potion=(int[])entree2.readObject();
	        	arme=(Arme)entree2.readObject();
				armure=(Armure)entree2.readObject();
	        	pos=(int)entree2.readObject();
				nom=(String)entree2.readObject();
				System.out.println("Pvmax : "+pvmax);
				System.out.println("Argent : "+argent);
				/*System.out.println("Petite potion : "+potion[0]);
				System.out.println("Moyenne potion : "+potion[1]);
				System.out.println("Super Potion : "+potion[2]);*/
				System.out.println("Arme sauvegardé : "+arme);
				System.out.println("Armure sauvegardé : "+armure);
				System.out.println("la piece sauvegardé : "+pos);
				System.out.println("le nom sauvegardé : "+nom);

				heros.setVieMax(pvmax);
				heros.setArgent(argent);
				heros.setPotion(potion);
				/*heros.getPotion()[0] = potion[0];
				heros.getPotion()[1] = potion[1];
				heros.getPotion()[2] = potion[2];*/
				heros.setArme(arme);
				heros.setArmure(armure);
				lab.setPosition(Piece.getPieceById(pos));
				lab.setLastPosition(Piece.getPieceById(pos));
				heros.setNom(nom);
				System.out.println(heros.getVieMax());
				System.out.println(heros.getArgent());
				System.out.println(heros.getPotion()[0]);
				System.out.println(heros.getPotion()[1]);
				System.out.println(heros.getPotion()[2]);
				System.out.println(heros.getArme());
				System.out.println(heros.getArmure());
				System.out.println(heros.getNom());
				System.out.println(lab.getPosition());
				
				entree2.close();
				entree.close();
	         } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	         }	
	         
	      	}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	      return "3";// quitter la boucle du main
	   }
	
}
//lance une partie fait un combat ...pause
//après avoir de l'argent on va a la boutique, on achete , on combat avec les nouveaux équipements
//montrer dégats augmenter et dégat subit
//... on se retrouve au boss ... fuit, sauvegarde la partie
// recharge la partie combat boss, potion... gagner 
// cas ou le personnage perds