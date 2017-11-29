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

    
       public static void main(String[] args) {
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

        }

        System.out.println("Game over!");
    }
       
               
}
