package labyrinthe.java;


import java.util.ArrayList;

public class Piece{
	protected Piece nord;
	protected Piece sud;
	protected Piece est;
	protected Piece ouest;
	private static ArrayList<Piece> lesPieces = new ArrayList<>();
	protected int id;
	/**
	 * Cr�e un pi�ce
	 * 
	 */
	public Piece() {
		id=lesPieces.size();
		lesPieces.add(this);
		
	}

	/**
	 * Retourne la pi�ce au nord
	 * @return Objet de type piece
	 */
	public Piece getNord() {
		return nord;
	}

	public static Piece getPieceById(int id) {
		return lesPieces.get(id);
	}

	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Numero "+ id;
	}
	/**
	 * Cr�e un lien avec la pi�ce du nord pass�e en param�tre
	 * @param nord Objet de type piece
	 */
	public void setNord(Piece nord) {
		this.nord = nord;
	}

	/**
	 * Retourne la pi�ce au sud
	 * @return Objet de type piece
	 */
	public Piece getSud() {
		return sud;
	}

	/**
	 * Cr�e un lien avec la pi�ce du sud pass�e en param�tre
	 * @param sud Objet de type piece
	 */
	public void setSud(Piece sud) {
		this.sud = sud;
	}

	/**
	 * Retourne la pi�ce a l'est
	 * @return Objet de type piece
	 */
	public Piece getEst() {
		return est;
	}

	/**
	 * Cr�e un lien avec la pi�ce a l'est pass�e en param�tre
	 * @param est Objet de type piece
	 */
	public void setEst(Piece est) {
		this.est = est;
	}

	/**
	 * Retourne la pi�ce a l'ouest
	 * @return Objet de type piece
	 */
	public Piece getOuest() {
		return ouest;
	}
	/**
	 * Cr�e un lien avec la pi�ce a l'ouest pass�e en param�tre
	 * @param ouest Objet de type piece
	 */
	public void setOuest(Piece ouest) {
		this.ouest = ouest;
	}


}
