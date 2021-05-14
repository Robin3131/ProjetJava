package labyrinthe.java;

public class Piece {
	protected Piece nord;
	protected Piece sud;
	protected Piece est;
	protected Piece ouest;
	/**
	 * Crée un pièce
	 * 
	 */
	public Piece() {
	}

	/**
	 * Retourne la pièce au nord
	 * @return Objet de type piece
	 */
	public Piece getNord() {
		return nord;
	}

	/**
	 * Crée un lien avec la pièce du nord passée en paramètre
	 * @param nord Objet de type piece
	 */
	public void setNord(Piece nord) {
		this.nord = nord;
	}

	/**
	 * Retourne la pièce au sud
	 * @return Objet de type piece
	 */
	public Piece getSud() {
		return sud;
	}

	/**
	 * Crée un lien avec la pièce du sud passée en paramètre
	 * @param sud Objet de type piece
	 */
	public void setSud(Piece sud) {
		this.sud = sud;
	}

	/**
	 * Retourne la pièce a l'est
	 * @return Objet de type piece
	 */
	public Piece getEst() {
		return est;
	}

	/**
	 * Crée un lien avec la pièce a l'est passée en paramètre
	 * @param est Objet de type piece
	 */
	public void setEst(Piece est) {
		this.est = est;
	}

	/**
	 * Retourne la pièce a l'ouest
	 * @return Objet de type piece
	 */
	public Piece getOuest() {
		return ouest;
	}
	/**
	 * Crée un lien avec la pièce a l'ouest passée en paramètre
	 * @param ouest Objet de type piece
	 */
	public void setOuest(Piece ouest) {
		this.ouest = ouest;
	}


}
