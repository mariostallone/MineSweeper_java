/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import minesweeper.spots.EmptySpot;
import minesweeper.spots.MineSpot;
import minesweeper.spots.Spot;

/**
 *
 * @author Mario Stallone
 */
public class MineSweeper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        System.out.println("Instructions");
        System.out.println("============");
        System.out.println("1. Enter the spot to open by specifying a point such as 1a");
        System.out.println("2. Sit Back and Enjoy!");
        System.out.println();
        MineGenerator generator = new MineGenerator();
        generator.generateMineField(4, 4);
        do {
            generator.drawMineField(4, 4);
            System.out.println("Mine?");
            String read = null;
            try 
            {
                read = InputReader.readString();
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(MineSweeper.class.getName()).log(Level.SEVERE, null, ex);
            }
            int i = Integer.parseInt(Character.toString(read.charAt(0)));
            int j = Character.toString(read.charAt(1)).charAt(0)-96;
            Spot mine = generator.getMineField().getMines().get(i - 1).get(j - 1);
            mine.setOpen(true);
            if(mine.getClass()==MineSpot.class)
            {
               generator.drawMineField(4, 4);
               System.out.println("Game Over - You Lost");
               break;
            }
            if(mine.getClass()==EmptySpot.class)
            {
                int temp = generator.getMineField().getOpenEmptySpotCount();
                generator.getMineField().setOpenEmptySpotCount(++temp);
                if(generator.getMineField().getTotalEmptySpotCount()==generator.getMineField().getOpenEmptySpotCount())
                {
                    generator.drawMineField(4, 4);
                    System.out.println("Game Over - You Won");
                    break;
                }
                if(Constants.DEBUG==1) System.out.println("Total : "+generator.getMineField().getTotalEmptySpotCount()+"Empty :"+generator.getMineField().getOpenEmptySpotCount());
            }
        } while (true);
    }
}