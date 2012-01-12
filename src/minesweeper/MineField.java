/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import minesweeper.spots.EmptySpot;
import minesweeper.spots.MineSpot;
import minesweeper.spots.Position;
import minesweeper.spots.Spot;
/**
 *
 * @author Mario Stallone
 */
public class MineField 
{
    private ArrayList<ArrayList<Spot>> mines;
    private int mineCount;
    private int openEmptySpotCount;
    private int totalEmptySpotCount;
    public int getOpenEmptySpotCount() {
        return openEmptySpotCount;
    }

    public void setOpenEmptySpotCount(int openEmptySpotCount) {
        this.openEmptySpotCount = openEmptySpotCount;
    }

    public int getTotalEmptySpotCount() {
        return totalEmptySpotCount;
    }

    public void setTotalEmptySpotCount(int totalEmptySpotCount) {
        this.totalEmptySpotCount = totalEmptySpotCount;
    }
    public ArrayList<ArrayList<Spot>> getMines() 
    {
        return mines;
    }
    public void setMines(ArrayList<ArrayList<Spot>> mines) 
    {
        this.mines = mines;
    }
    public int getMineCount() 
    {
        return mineCount;
    }
    public void setMineCount(int mineCount) 
    {
        this.mineCount = mineCount;
    }
    public void createMineField(int x,int y)
    {
        mines = new ArrayList<ArrayList<Spot>>();
        totalEmptySpotCount=0;
        for(int i=0;i<x;i++)
        {
            ArrayList<Spot> mineRow = new ArrayList<Spot>();
            for(int j=0;j<y;j++)
            {
                Spot mine;
                Position pos = new Position();
                pos.setColumn(i);
                pos.setRow(j);
                if(new Random().nextInt(100)%2==0)
                {
                    mine=new MineSpot();
                }
                else
                {
                    mine = new EmptySpot();
                    totalEmptySpotCount++;
                }
                mine.setPosition(pos);
                mineRow.add(mine);
            }
            mines.add(mineRow);
        }
        addObservers(x, y);
    } 
    public void addObservers(int x,int y)
    {
        if(Constants.DEBUG==1)System.out.println("x:"+x+",y:"+y);
        for(int i=0;i<x;i++)
        {
            ArrayList<Spot> mineRow = mines.get(i);
            for(int j=0;j<y;j++)
            {
                Spot mine = mineRow.get(j);
                List<Spot> neighbouringMines=null;
                if(mine.getClass()==MineSpot.class)
                { 
                    neighbouringMines = new ArrayList<Spot>();
                    for(int c=0;c<x;c++)
                    {
                        for(int d=0;d<y;d++)
                        {
                            Spot spot = mines.get(c).get(d);
                            if(spot.getClass()==MineSpot.class)
                            {
                                neighbouringMines.add(spot);
                                spot.addObserver(mine);
                            }
                        }
                    }
                    MineSpot temp = (MineSpot) mine;
                    temp.setNeighbouringMines(neighbouringMines);
                }
            }
        }
    }
}