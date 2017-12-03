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

public class Field {

    private final int x;
    private final int y;
    private State state;
    private IShip ship;

    public Field(int x, int y, State state) {
        this.x = x;
        this.y = y;
        this.state = state;

    }

    public void setShip(IShip ship) {
        this.ship = ship;
    }

    public char stateToChar() {
        char value;
        switch (state) {
            case STAY:
            case EMPTY:
                value = ' ';
                break;
            case HIT:
                value = 'O';
                break;
            case SUNK:
                value = 'X';
                break;
            case MISS:
                value = '!';
                break;
            default:
                value = '?';
        }
        return value;

    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public IShip getShip() {
        return ship;
    }
}
