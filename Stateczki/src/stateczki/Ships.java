/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateczki;


/**
 *
 * @author sba
 */
public class Ships {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
       Board board = new Board();
       board.fillBoard();
       
        board.printBoard();
        board.printBoard();
              
    }
       
    
    private static State getRandomShip(double random) {
        if(random < 0.2) {
                   return State.HIT;
                } else if (random > 0.8){
                    return State.EMPTY;
                } else 
                    return State.MISS;
    }
       
}
