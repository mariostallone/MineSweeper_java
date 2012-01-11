/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.spots;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Mario Stallone
 */
public abstract class Spot extends Observable implements Observer
{
    private boolean open;
    private Position position;
    public Position getPosition() 
    {
        return position;
    }
    public void setPosition(Position position) 
    {
        this.position = position;
    }
    public boolean isOpen() 
    {     
        return open;
    }
    public void setOpen(boolean open) 
    {
        setChanged();
        notifyObservers();
        System.out.println("Open");
        this.open = open;
    } 
}
