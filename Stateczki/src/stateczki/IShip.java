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
public interface IShip {
    
    int getDecksCount();
    
    void hit();
    
    boolean isSunk();
    
    void setOnField(Field field, int deckNo);
    }



