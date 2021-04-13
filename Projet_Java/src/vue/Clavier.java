package vue;

import java.util.Scanner;

public class Clavier {
	    private static Scanner scanner = new Scanner(System.in);


	    public static String entrerClavierString() {
	        return scanner.next();
	    }
	    
	    public static int entrerClavierInt() {
	        return scanner.nextInt();
	    }

	
}
