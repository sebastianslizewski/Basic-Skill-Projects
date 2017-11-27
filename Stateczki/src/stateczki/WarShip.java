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
public abstract class WarShip implements IShip{
    
    
    enum Orientation{
        HORIZONTAL, VERTICAL
    }
    private Orientation orientation;
    private int hits;
    private Field[] occupied;
    
    public WarShip(){
        occupied = new Field[getDecksCount()];
    }
    
    @Override
    public boolean isSunk(){
        return hits == getDecksCount();
    }
    
    public void setOnField(Field field, int deckNo){
    
        field.setShip(this);
        field.setState(State.STAY);
        occupied[deckNo] = field;
}
    
    
    @Override
    public void hit(){
     hits++;
     if(isSunk()){
         for (int i = 0; i < occupied.length; i++) {
             occupied[i].setState(State.SUNK);
             
            }
        }
    }
} 
    class OneMast extends WarShip {
        
        @Override
    public int getDecksCount(){
    return 1;
        }
    }

    class TwoMast extends WarShip {
    
        @Override
    public int getDecksCount(){
    return 2;
        }
    }
    
    class ThreeMast extends WarShip {
    
        @Override
    public int getDecksCount(){
    return 3;
        }
    }
    
    class FourMast extends WarShip {
        @Override
    public int getDecksCount(){
    return 4;
        }
    }
 
   
       


