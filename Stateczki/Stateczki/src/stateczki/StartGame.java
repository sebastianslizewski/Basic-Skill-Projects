package stateczki;

import java.util.Scanner;

public class StartGame {

		public static int moveCounterInt;
	
	
	
	public static void StartGameNormalMode (){
	
		
		Board board = new Board();
        board.fillBoard();
        Scanner scanner = new Scanner(System.in);
        
        while (board.getShipsCount() > 0) {

            board.printBoard();
            String move = scanner.nextLine();
            move = move.toUpperCase();
            int x = move.charAt(0) - 'A';
            int y = move.charAt(1) - '0';

            try {
                board.shoot(x, y);
            } catch (IllegalMoveException e) {
                System.out.println("Error:" + e.getMessage());
            }

        	}System.out.println("Game over!");
        }
	
	public static void StartGameHardcoreMode (){
		moveCounterInt = Integer.parseInt(Main.moveCounterStringToInt);
		Board board = new Board();
        board.fillBoard();
        Scanner scanner = new Scanner(System.in);
        
             
        
        while (board.getShipsCount() > 0 && moveCounterInt > 0 ) {
        	
        	
        	
            board.printBoard();
            String move = scanner.nextLine();
            move = move.toUpperCase();
            int x = move.charAt(0) - 'A';
            int y = move.charAt(1) - '0';
            

            try {
                board.shoot(x, y);
            } catch (IllegalMoveException e) {
                System.out.println("Error:" + e.getMessage());
            }
            --moveCounterInt; 
        	} 
        
        
        System.out.println("\n You didn't make your goal. \n Game over!");
	}
}


