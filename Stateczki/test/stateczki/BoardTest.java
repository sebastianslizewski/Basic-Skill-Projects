/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateczki;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;


/**
 *
 * @author sba
 */
public class BoardTest {

    private Board board;
       
    @Before
    public void setUp() throws Exception {
        board = new Board();
    }
    

    @Test
    public void shouldAddOneMast() throws Exception {

        board.addShip(0, 0, new OneMast());

        assertEquals(1, board.getShipsCount());
    }

    @Test
    public void shouldAddOneMastOnField() throws Exception {

        
        board.addShip(0, 0, new OneMast());

        Field field = board.getField(0, 0);
        assertEquals(State.STAY, field.getState());

        assertEquals(1, board.getShipsCount());
    }

    @Test (expected = IllegalMoveException.class)
    public void shouldNotBeAbleToAddFiveOneMasts() throws Exception {
            board.addShip(1, 1, new OneMast());
            board.addShip(3, 3, new OneMast());
            board.addShip(5, 5, new OneMast());
            board.addShip(7, 7, new OneMast());
            
            board.addShip(9, 9, new OneMast());
    }
    
    @Test (expected = IllegalMoveException.class)
    public void shouldNotBeAbleToAddTwoFourMasts() throws Exception {
            board.addShip(0, 0, new FourMast());
            board.addShip(5, 0, new FourMast());
            
    }
    
    
    

    @Test(expected = IllegalMoveException.class)
    public void shouldFailToAddOutsideX() throws Exception {

        
        board.addShip(-1, 0, new OneMast());

    }

    @Test(expected = IllegalMoveException.class)
    public void shouldFailToAddOutsideY() throws Exception {

        
        board.addShip(0, 11, new OneMast());

    }
}
