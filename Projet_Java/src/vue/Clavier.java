package vue;

import java.util.Scanner;


public class Clavier {
	    private static Scanner scanner = new Scanner(System.in);

	    /**
	     *Fonction qui retourne un string entré par l'utilisateur
	     *@return string
	     */
	    public static String entrerClavierString() {
	        return scanner.next();
	    }
	    
	    /**
	     *Fonction qui retourne un nombre entré par l'utilisateur
	     *@return int
	     */
	    public static int entrerClavierInt() {
	        return scanner.nextInt();
	    }

	
}
