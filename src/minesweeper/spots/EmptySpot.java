/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.spots;

import java.util.List;
import java.util.Observable;

/**
 *
 * @author Mario Stallone
 */
public class EmptySpot extends Spot
{
    List<Spot> neighbouringMines;
    List<Spot> neighbouringEmptySpots;
    public List<Spot> getNeighbouringEmptySpots() {
        return neighbouringEmptySpots;
    }

    public void setNeighbouringEmptySpots(List<Spot> neighbouringEmptySpots) {
        this.neighbouringEmptySpots = neighbouringEmptySpots;
    }

    public List<Spot> getNeighbouringMines() {
        return neighbouringMines;
    }

    public void setNeighbouringMines(List<Spot> neighbouringMines) {
        this.neighbouringMines = neighbouringMines;
    }

    @Override
    public void update(Observable o, Object arg) {
        //throw new UnsupportedOperationException("Not supported yet.");
        System.out.println(this.getPosition());
    }
}
