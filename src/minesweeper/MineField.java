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
        System.out.println("x:"+x+",y:"+y);
        for(int i=0;i<x;i++)
        {
            ArrayList<Spot> mineRow = mines.get(i);
            for(int j=0;j<y;j++)
            {
                Spot mine = mineRow.get(j);
                List<Spot> neighbouringMines;
                List<Spot> neighbouringEmptySpots;
                if(mine.getClass()==MineSpot.class)
                {
                    int startingRow = i-1;
                    int startingCol = j-1;
                    int endingRow = i+1;
                    int endingCol = j+1;
                    if(startingRow<0) startingRow=0;
                    if(startingCol<0) startingCol=0;
                    if(endingRow>x) endingRow = x;
                    if(endingCol>y) endingCol = y;
                    neighbouringMines = new ArrayList<Spot>();
                    System.out.println("Start("+startingRow+","+startingCol+") End("+endingRow+","+endingCol+")"+i+","+j);
                    for(int c=startingRow;c<endingRow;c++)
                    {
                        for(int d=startingCol;d<endingCol;d++)
                        {
                            Spot spot = mines.get(c).get(d);
                            if(spot.getClass()==MineSpot.class)
                            {
                                neighbouringMines.add(spot);
                            }
                            spot.addObserver(mine);
                        }
                    }
                    MineSpot temp = (MineSpot) mine;
                    temp.setNeighbouringMines(neighbouringMines);
                }
                else
                {
                    int startingRow = i-1;
                    int startingCol = j-1;
                    int endingRow = i+1;
                    int endingCol = j+1;
                    if(startingRow<0) startingRow=0;
                    if(startingCol<0) startingCol=0;
                    if(endingRow>x) endingRow = x;
                    if(endingCol>y) endingCol = y;
                    neighbouringEmptySpots = new ArrayList<Spot>();
                    neighbouringMines = new ArrayList<Spot>();
                    System.out.println("Start("+startingRow+","+startingCol+") End("+endingRow+","+endingCol+")"+i+","+j);
                    for(int c=startingRow;c<endingRow;c++)
                    {
                        for(int d=startingCol;d<endingCol;d++)
                        {
                            Spot spot = mines.get(c).get(d);
                            if(spot.getClass()==MineSpot.class)
                            {
                                neighbouringMines.add(spot);
                                System.out.println("Added");
                            }
                            else
                            {
                                neighbouringEmptySpots.add(spot);
                            }
                            spot.addObserver(mine);
                        }
                    }
                    EmptySpot temp = (EmptySpot) mine;
                    temp.setNeighbouringMines(neighbouringMines);
                    temp.setNeighbouringEmptySpots(neighbouringEmptySpots);
                }
            }
        }
    } 
}