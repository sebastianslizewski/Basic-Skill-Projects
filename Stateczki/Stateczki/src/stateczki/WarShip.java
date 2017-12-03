/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateczki;

/**
 *
 * @author sebastianslizewski
 */
public abstract class WarShip implements IShip{
    
    
    enum Orientation {
        HORIZONTAL, VERTICAL
    }

    private Orientation orientation;
    private int hits;
    private Field[] occupied;

    public WarShip(Orientation orientation) {
        this.orientation = orientation;
        occupied = new Field[getDecksCount()];
    }

    @Override
    public boolean isSunk() {
        return hits == getDecksCount();
    }

    public void setOnField(Field field, int deckNo) {

        field.setShip(this);
        field.setState(State.STAY);
        occupied[deckNo] = field;
    }

    @Override
    public void hit() {
        hits++;
        if(isSunk()) {
            for (int i = 0; i < occupied.length; i++) {
                occupied[i].setState(State.SUNK);
            }
        }
    }

    public Orientation getOrientation() {
        return orientation;
    }
}

class OneMast extends WarShip {

    public OneMast(Orientation orientation) {
        super(orientation);
    }

    public OneMast() {
        this(Orientation.HORIZONTAL);
    }

    @Override
    public int getDecksCount() {
        return 1;
    }
}

class TwoMasts extends WarShip {

    public TwoMasts(Orientation orientation) {
        super(orientation);
    }

    @Override
    public int getDecksCount() {
        return 2;
    }
}

class ThreeMasts extends WarShip {

    public ThreeMasts(Orientation orientation) {
        super(orientation);
    }

    @Override
    public int getDecksCount() {
        return 3;
    }
}

class FourMasts extends WarShip {

    public FourMasts(Orientation orientation) {
        super(orientation);
    }

    @Override
    public int getDecksCount() {
        return 4;
    }
    }
 
   
       


