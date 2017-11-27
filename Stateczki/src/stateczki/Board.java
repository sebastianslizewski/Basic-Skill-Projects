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
public class Board {
    
   public static final int BOARD_SIZE = 10;
    
   private Field [][] fields = new Field [BOARD_SIZE][BOARD_SIZE];
   
   private int shipsCount;
   private int numberOfShipsByDeck[] = new int [SHIP_TYPES_COUNT];
   private static final int SHIP_TYPES_COUNT = 4;
   public Board(){
       
       for (int y = 0; y < BOARD_SIZE; y++) {
           for (int x = 0; x < BOARD_SIZE; x++) {
               fields[y][x] = new Field(x, y, State.EMPTY);
               
           }
           
       }
   }
   public void fillBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                fields[i][j].setState(getRandomShip(Math.random()));
                
            }
           
        }
           }
   private static State getRandomShip(double random) {
        if(random < 0.2) {
                   return State.HIT;
                } else if (random > 0.8){
                    return State.EMPTY;
                } else 
                    return State.MISS;
    }
   private static void printLetters(){
        System.out.print("  ");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print((char)('A' + i ));                 
        }
        System.out.print('\n');
    }
   public void printBoard(){
       printLetters();
       for (int i = 0; i < 10; i++) {
            int numberToPrint = i + 1;
           if( numberToPrint < 10){
                System.out.print(' ');
            }    
            System.out.print(numberToPrint);
            for (int j = 0; j < 10; j++) {
                char shipValue = fields[i][j].stateToChar();
                System.out.print(shipValue);
                              
            } System.out.print('\n');
        } 
    }

    public void addShip(int x, int y, IShip ship ) throws IllegalMoveException  {
        
        if(numberOfShipsByDeck[ship.getDecksCount() - 1] 
                    == getTotalCountOfShips(ship.getDecksCount())){
            throw new IllegalMoveException("You have all one masts set!");
        }
       
       
        if( x < 0 || x >= BOARD_SIZE || y < 0 || y >= 10){
            throw new IllegalMoveException("Ship set outside board!");
        }
        ship.setOnField(fields[y][x], 0);
       
        shipsCount++;
        numberOfShipsByDeck[ship.getDecksCount() - 1]++;
    }

    public int getShipsCount() {
        return shipsCount;
    }
    
    public Field getField(int x, int y) {
        return fields[y][x];
    }

    private int getTotalCountOfShips(int decksCount) {
        return SHIP_TYPES_COUNT - decksCount + 1;
    }
}
