/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateczki;

import java.util.Scanner;

/**
 *
 * @author sebastianslizewski
 */
public class Main {

	public static String moveCounterStringToInt;
       
	public static void main(String[] args) {
    	   
    	
        Board board = new Board();
        board.fillBoard();
        
        System.out.println("Welcome in Stateczki game. \n If you want to try hardcore mode type: H");
        Scanner scanner = new Scanner(System.in);
        String hardcoreUserType = scanner.nextLine();
        hardcoreUserType = hardcoreUserType.toUpperCase();
        
        
        if(GameSettings.turnOnHardcore("H", hardcoreUserType) == true) {
        	    	
        	System.out.println("Type how many moves you will need to win!");
        	hardcoreUserType = scanner.nextLine();
        	moveCounterStringToInt = hardcoreUserType;
        	StartGame.StartGameHardcoreMode();
                
        } else StartGame.StartGameNormalMode();         
       }
}
