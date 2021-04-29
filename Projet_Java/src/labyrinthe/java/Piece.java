package labyrinthe.java;

public class Piece {
	protected Piece nord;
	protected Piece sud;
	protected Piece est;
	protected Piece ouest;

	public Piece() {
	}

	public Piece getNord() {
		return nord;
	}

	public void setNord(Piece nord) {
		this.nord = nord;
	}

	public Piece getSud() {
		return sud;
	}

	public void setSud(Piece sud) {
		this.sud = sud;
	}

	public Piece getEst() {
		return est;
	}

	public void setEst(Piece est) {
		this.est = est;
	}

	public Piece getOuest() {
		return ouest;
	}

	public void setOuest(Piece ouest) {
		this.ouest = ouest;
	}


}
