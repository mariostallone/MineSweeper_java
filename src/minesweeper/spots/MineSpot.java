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
public class MineSpot extends Spot
{
    List<Spot> neighbouringMines;
    public List<Spot> getNeighbouringMines() {
        return neighbouringMines;
    }
    public void setNeighbouringMines(List<Spot> neighbouringMines) {
        this.neighbouringMines = neighbouringMines;
    }

    @Override
    public void update(Observable o, Object arg) {
        //throw new UnsupportedOperationException("Not supported yet.");
        System.out.println("Mine"+this.getPosition());
        this.setBlasted();
    }
    public void setBlasted()
    {
        this.open=true;
    }
}
