package labyrinthe.java;


import java.util.ArrayList;

import vue.Clavier;

public class Labyrinthe {

	ArrayList<Piece> cases = new ArrayList<Piece>();
	protected Piece position;
	protected Piece sortie; // Piece du boss aussi
	protected Piece lastPosition;
	protected Piece boutique;
	/**
	 * Cr?ation du labyrinthe 
	 */
	public Labyrinthe() {
		Piece P1 = new Piece();
		Piece P2 = new Piece();
		Piece P3 = new Piece();
		Piece P4 = new Piece();
		Piece P5 = new Piece();
		Piece P6 = new Piece();
		Piece P7 = new Piece();
		Piece P8 = new Piece();
		Piece P9 = new Piece();
		Piece P10 = new Piece();
		Piece P11 = new Piece();
		Piece P12 = new Piece();
		Piece P13 = new Piece();// D?but du labyrinthe
		Piece P14 = new Piece();
		Piece P15 = new Piece();
		Piece P16 = new Piece();
		Piece P17 = new Piece();// Sortie du labyrinthe
		Piece P18 = new Piece();
		Piece P19 = new Piece();
		Piece P20 = new Piece();
		Piece P21 = new Piece();
		Piece P22 = new Piece();
		Piece P23 = new Piece();
		Piece P24 = new Piece();
		Piece P25 = new Piece();

		P1.setOuest(P2);
		P2.setEst(P1);

		P1.setSud(P8);
		P8.setNord(P1);

		P8.setOuest(P9);
		P9.setEst(P8);

		P9.setSud(P24);
		P24.setNord(P9);

		P24.setOuest(P25);
		P25.setEst(P24);

		P25.setNord(P10);
		P10.setSud(P25);

		P10.setNord(P11);
		P11.setSud(P10);

		P11.setNord(P12);
		P12.setSud(P11);

		P12.setNord(P13);
		P13.setSud(P12);

		P13.setEst(P14);
		P14.setOuest(P13);

		P14.setSud(P3);
		P3.setNord(P14);

		P3.setEst(P4);
		P4.setOuest(P3);

		P4.setNord(P15);
		P15.setSud(P4);

		P15.setEst(P16);
		P16.setOuest(P15);

		P16.setSud(P5);
		P5.setNord(P16);

		P5.setEst(P18);
		P18.setOuest(P5);

		P18.setNord(P17);
		P17.setSud(P18);

		P5.setSud(P6);
		P6.setNord(P5);

		P6.setEst(P19);
		P19.setOuest(P6);

		P19.setSud(P20);
		P20.setNord(P19);

		P20.setSud(P21);
		P21.setNord(P20);

		P6.setSud(P7);
		P7.setNord(P6);

		P7.setSud(P22);
		P22.setNord(P7);

		P22.setOuest(P23);
		P23.setEst(P22);

		this.lastPosition = P13;
		this.position = P13;
		this.sortie = P17;
		this.boutique = P13;
	}
	/**
	 * Retourne la Piece de sortie
	 * @return object de type Piece
	 */
	public Piece getSortie() {
		return sortie;
	}

	/**
	 * Retourne la positon du joueur (Piece)
	 * @return object de type Piece
	 */
	public Piece getPosition() {
		return position;
	}
	
	/**
	 * Modifie la position du heros par la position voulue du joueur (pass?e en param?tre)
	 * @param position Objet de type piece
	 */
	public void setPosition(Piece position) {
		this.position = position;
	}

	/**
	 * Retourne la derni?re pi?ce emprunt?e par le heros
	 * @return Objet de type piece
	 */
	public Piece getLastPosition() {
		return lastPosition;
	}
	
	/**
	 * Modifie la position de la derni?re pi?ce emprunt?e par le heros
	 * @param lastPosition objet de type pi?ce	
	 */
	public void setLastPosition(Piece lastPosition) {
		this.lastPosition = lastPosition;
	}

	/**
	 * Retourne la position de la boutique
	 * @return Objet de type piece
	 */
	public Piece getBoutique() {
		return boutique;
	}
	
	/**
	 * Retourne si la pi?ce actuelle est la salle du boss
	 * @return True (boolean) si la piece actuelle est la salle du boss
	 */
	public boolean pieceBoss() {
		if (this.position.getId() == this.sortie.getId()) {
			return true;
		} else {
			return false;
		}

	}
}