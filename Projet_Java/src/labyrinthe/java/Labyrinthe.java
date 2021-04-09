package labyrinthe.java;

import java.util.ArrayList;

public class Labyrinthe {

ArrayList<Piece> cases = new ArrayList<Piece>();


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
	Piece P13 = new Piece();// Début du labyrinthe
	Piece P14 = new Piece();
	Piece P15 = new Piece();
	Piece P16 = new Piece();
	Piece P17 = new Piece();
	Piece P18 = new Piece();
	Piece P19 = new Piece();
	Piece P20 = new Piece();
	Piece P21 = new Piece();
	Piece P22 = new Piece();
	Piece P23 = new Piece();
	Piece P24 = new Piece();
	Piece P25 = new Piece();
	
	//P1
    P1.setSud(P8);
    P1.setOuest(P2);

    //P2
    P2.setEst(P1);

    //P11
    P11.setNord(P12);
    P11.setSud(P10);

    //P6
    P6.setNord(P5);
    P6.setEst(P19);
    P6.setSud(P7);

    //P19
    P19.setSud(P20);
    P19.setOuest(P6);
	
	//P25
	P25.setNord(P10);
    P25.setEst(P24);
    //P24
    P24.setOuest(P25);
    P24.setNord(P9);
    //P23
    P23.setEst(P22);
    //P22
    P22.setOuest(P23);
    P22.setNord(P7);
    //P21
    P21.setNord(P20);
    //P12
    P12.setNord(P13);
    P12.setSud(P11);
    //P3
    P3.setNord(P14);
    P3.setEst(P4);
    //P4
    P4.setOuest(P3);
    //P5
    P5.setNord(P16);
    P5.setEst(P18);
    P5.setSud(P6);
    //P18
    P18.setNord(P17);
	
	//P7
	P7.setSud(P22);
	P7.setNord(P6);
	
	//P8
	P8.setOuest(P9);
	P8.setNord(P1);
	
	//P9
	P9.setSud(P24);
	P9.setEst(P8);
	
	//P10
	P10.setNord(P11);
	P10.setSud(P25);
	
	//P20
	P20.setSud(P21);
	P20.setNord(P19);
			
	
}





public void seDeplacer() {
	String txt = "Quelle direction voulez-vous prendre ?\n";
	txt += " Entrez N pour avancer, S pour reculer, E pour aller à droite, O pour aller à gauche !\n";
	
	
	
	
}


}