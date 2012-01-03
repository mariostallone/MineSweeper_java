/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.spots;

/**
 *
 * @author Mario Stallone
 */
public class Position 
{
    private int row;
    private int column;
    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
    @Override
    public String toString()
    {
        return row+","+column;
    }
}
