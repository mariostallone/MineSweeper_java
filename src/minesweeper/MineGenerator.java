/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.util.ArrayList;
import minesweeper.spots.EmptySpot;
import minesweeper.spots.MineSpot;
import minesweeper.spots.Spot;

/**
 *
 * @author Mario Stallone
 */
public class MineGenerator 
{
    private MineField mineField;
    
    public void generateMineField(int x,int y)
    {
        this.mineField = new MineField();
        mineField.createMineField(x,y);
    }
    public void drawMineField(int x,int y)
    {
        char ch = 'a';
        System.out.print("   ");
        for(int j=1;j<=y;j++)
        {
            System.out.print(ch+"   ");
            ch++;
        }
        System.out.println();
        for(int i=1;i<=x;i++)
        {
            System.out.print(i+"  ");
            ArrayList<Spot> mineRow = mineField.getMines().get(i-1);
            for(int j=1;j<=y;j++)
            {
                Spot mine = mineRow.get(j-1);
                if(mine.getClass()==MineSpot.class)
                {
                    if(mine.isOpen())
                    {
                        System.out.print("B   ");
                    }
                    else
                    {
                        System.out.print("+   ");
                    }
                }
                else
                {
                    if(mine.isOpen())
                    {
                        EmptySpot mineSpot = (EmptySpot)mine;
                        //System.out.print("0   ");
                        System.out.print(mineSpot.getNeighbouringMines().size()+"   ");
                    }
                    else
                    {
                        System.out.print("*   ");
                    }
                }
            }
            System.out.println();
        }
    }
    public MineField getMineField() 
    {
        return mineField;
    }
    public void setMineField(MineField mineField) 
    {
        this.mineField = mineField;
    }
}
